package com.driff.apps.advancedandroid.home;

import com.driff.apps.advancedandroid.di.ActivityScope;
import com.driff.apps.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by johnj on 3/4/2018.
 */

@ActivityScope
@Subcomponent(modules = {MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{
        @Override
        public void seedInstance(MainActivity instance) {

        }
    }

}
