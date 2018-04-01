package com.driff.apps.advancedandroid.home;

import com.driff.apps.advancedandroid.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by johnj on 3/20/2018.
 */

@ActivityScope
@Subcomponent(modules = {TestScreenBindingModule.class})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }

}
