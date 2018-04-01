package com.driff.apps.advancedandroid.base;

import android.support.test.InstrumentationRegistry;

/**
 * Created by johnj on 3/20/2018.
 */

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent(){
        return (TestApplicationComponent) ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext()).component;
    }

}
