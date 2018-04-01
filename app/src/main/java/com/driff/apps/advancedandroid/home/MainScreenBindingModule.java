package com.driff.apps.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.driff.apps.advancedandroid.details.RepoDetailsComponent;
import com.driff.apps.advancedandroid.details.RepoDetailsController;
import com.driff.apps.advancedandroid.di.ControllerKey;
import com.driff.apps.advancedandroid.trending.TrendingReposComponent;
import com.driff.apps.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by johnj on 3/5/2018.
 */
@Module(subcomponents = {TrendingReposComponent.class, RepoDetailsComponent.class})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);

}
