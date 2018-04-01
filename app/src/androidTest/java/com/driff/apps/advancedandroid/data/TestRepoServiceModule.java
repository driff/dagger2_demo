package com.driff.apps.advancedandroid.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by johnj on 3/20/2018.
 */

@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);



}
