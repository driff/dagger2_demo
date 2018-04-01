package com.driff.apps.advancedandroid.trending;

import com.driff.apps.advancedandroid.data.RepoRepository;
import com.driff.apps.advancedandroid.di.ScreenScope;
import com.driff.apps.advancedandroid.model.Repo;

import javax.inject.Inject;

/**
 * Created by johnj on 3/12/2018.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener{

    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository){
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepos();
    }

    private void loadRepos() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(__->viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t)->viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
