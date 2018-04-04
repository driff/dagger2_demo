package com.driff.apps.advancedandroid.data;

import com.driff.apps.advancedandroid.model.Contributor;
import com.driff.apps.advancedandroid.model.Repo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by johnj on 3/12/2018.
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

    @GET("repos/{owner}/{name}")
    Single<Repo> getRepo(@Path("owner")String repoOwner, @Path("name")String repoName);

    @GET
    Single<List<Contributor>> getContributor(@Url String url);
}
