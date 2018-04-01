package com.driff.apps.advancedandroid.base;

import com.driff.apps.advancedandroid.data.TestRepoServiceModule;
import com.driff.apps.advancedandroid.networking.ServiceModule;
import com.driff.apps.advancedandroid.trending.TrendingReposControllerTest;
import com.driff.apps.advancedandroid.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 3/20/2018.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);
}
