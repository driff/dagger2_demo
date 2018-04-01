package com.driff.apps.advancedandroid.data;

import android.util.Log;

import com.driff.apps.advancedandroid.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by johnj on 3/12/2018.
 */

public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service){
        this.service = service;
    }

    public Single<List<Repo>> getTrendingRepos(){
        Log.w(this.getClass().getName(), "Request!");
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }

    public Single<Repo> getRepo(String repoOwner, String repoName){
        return service.getRepo(repoOwner, repoName)
                .subscribeOn(Schedulers.io());
    }

}
