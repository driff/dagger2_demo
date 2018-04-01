package com.driff.apps.advancedandroid.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by johnj on 3/12/2018.
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

}
