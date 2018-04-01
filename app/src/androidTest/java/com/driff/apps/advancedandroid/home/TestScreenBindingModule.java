package com.driff.apps.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.driff.apps.advancedandroid.di.ControllerKey;
import com.driff.apps.advancedandroid.trending.TrendingReposComponent;
import com.driff.apps.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by johnj on 3/20/2018.
 */
@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

}
