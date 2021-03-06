package com.driff.apps.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import javax.inject.Inject;

/**
 * Created by johnj on 3/5/2018.
 */

public class DefaultScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject
    DefaultScreenNavigator(){

    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(rootScreen));
        }
    }

    @Override
    public boolean pop() {
        return router!=null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
