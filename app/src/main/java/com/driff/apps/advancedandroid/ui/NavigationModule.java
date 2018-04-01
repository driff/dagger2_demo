package com.driff.apps.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by johnj on 3/5/2018.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator defaultScreenNavigator);

}
