package ggikko.me.rxtextapplication;

import android.app.Application;


import ggikko.me.rxtextapplication.base.di.component.DaggerTestComponent;
import ggikko.me.rxtextapplication.base.di.component.TestComponent;
import ggikko.me.rxtextapplication.base.di.module.TestModule;
import lombok.Getter;

/**
 * Created by admin on 16. 5. 26..
 */
public class RxTextApplication extends Application {

    @Getter
    TestComponent testComponent;

    @Override
    public void onCreate() {
        dependency();
        super.onCreate();
    }

    private void dependency() {
        testComponent = DaggerTestComponent.builder().testModule(new TestModule()).build();
    }

}
