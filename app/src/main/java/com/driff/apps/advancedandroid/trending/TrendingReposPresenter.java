package com.driff.apps.advancedandroid.trending;

import com.driff.apps.advancedandroid.data.RepoRequester;
import com.driff.apps.advancedandroid.di.ScreenScope;
import com.driff.apps.advancedandroid.model.Repo;

import javax.inject.Inject;

/**
 * Created by johnj on 3/12/2018.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener{

    private final TrendingReposViewModel viewModel;
    private final RepoRequester requester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester requester){
        this.viewModel = viewModel;
        this.requester = requester;
        loadRepos();
    }

    private void loadRepos() {
        requester.getTrendingRepos()
                .doOnSubscribe(__->viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t)->viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
