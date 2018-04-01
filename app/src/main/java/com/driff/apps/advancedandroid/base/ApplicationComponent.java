package com.driff.apps.advancedandroid.base;

import com.driff.apps.advancedandroid.data.RepoServiceModule;
import com.driff.apps.advancedandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 3/4/2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ActivityBindingModule.class, ServiceModule.class, RepoServiceModule.class})
public interface ApplicationComponent {


    void inject(MyApplication myApplication);
}
