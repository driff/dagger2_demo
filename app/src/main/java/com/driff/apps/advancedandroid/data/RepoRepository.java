package com.driff.apps.advancedandroid.data;


import com.driff.apps.advancedandroid.model.Contributor;
import com.driff.apps.advancedandroid.model.Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class RepoRepository {

    private final Provider<RepoRequester> repoRequesterProvider;
    private final List<Repo> cachedTrendingRepos = new ArrayList<>();
    private final Map<String, List<Contributor>> cachedContributors = new HashMap<>();

    @Inject
    RepoRepository(Provider<RepoRequester> repoRequesterProvider){
        this.repoRequesterProvider = repoRequesterProvider;
    }

    public Single<List<Repo>> getTrendingRepos(){
        return Maybe.concat(cachedTrendingRepos(), apiTrendingRepos())
                .firstOrError()
                .subscribeOn(Schedulers.io());
    }

    public Single<Repo> getRepo(String repoOwner, String repoName){
        return Maybe.concat(cachedRepo(repoOwner, repoName), apiRepo(repoOwner, repoName))
                .firstOrError()
                .subscribeOn(Schedulers.io());
    }

    public Single<List<Contributor>> getContributors(String url){
        return Maybe.concat(cachedContributors(url), apiContributors(url))
                .firstOrError()
                .subscribeOn(Schedulers.io());
    }

    private Maybe<List<Contributor>> cachedContributors(String url){
        return Maybe.create(emitter -> {
            if(cachedContributors.containsKey(url)){
                emitter.onSuccess(cachedContributors.get(url));
            }
            emitter.onComplete();
        });
    }

    private Maybe<List<Contributor>> apiContributors(String url){
        return repoRequesterProvider.get().getContributors(url)
                .doOnSuccess(contributors -> cachedContributors.put(url, contributors))
                .toMaybe();
    }

    private Maybe<Repo> apiRepo(String repoOwner, String repoName){
        return repoRequesterProvider.get().getRepo(repoOwner, repoName)
                .toMaybe();
    }

    private Maybe<Repo> cachedRepo(String repoOwner, String repoName){
        return Maybe.create(e->{
            for (Repo cachedRepo : cachedTrendingRepos){
                if(cachedRepo.owner().login().equals(repoOwner)&&cachedRepo.name().equals(repoName)){
                    e.onSuccess(cachedRepo);
                    break;
                }
            }
            e.onComplete();
        });
    }

    private Maybe<List<Repo>> cachedTrendingRepos(){
        return Maybe.create(e ->{
            if(!cachedTrendingRepos.isEmpty()){
                e.onSuccess(cachedTrendingRepos);
            }
            e.onComplete();
        });
    }

    private Maybe<List<Repo>> apiTrendingRepos(){
        return repoRequesterProvider.get().getTrendingRepos()
                .doOnSuccess(repos -> {
                   cachedTrendingRepos.clear();
                   cachedTrendingRepos.addAll(repos);
                }).toMaybe();
    }

}
