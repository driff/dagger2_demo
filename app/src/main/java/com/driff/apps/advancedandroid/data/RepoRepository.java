package com.driff.apps.advancedandroid.data;


import com.driff.apps.advancedandroid.model.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class RepoRepository {

    private final Provider<RepoRequester> repoRequesterPRovider;
    List<Repo> cachedTrendingRepos = new ArrayList<>();

    @Inject
    RepoRepository(Provider<RepoRequester> repoRequesterProvider){
        this.repoRequesterPRovider = repoRequesterProvider;
    }

}
