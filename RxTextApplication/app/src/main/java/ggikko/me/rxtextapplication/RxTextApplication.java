package ggikko.me.rxtextapplication;

import android.app.Application;


import ggikko.me.rxtextapplication.base.di.component.DaggerTest2Component;
import ggikko.me.rxtextapplication.base.di.component.DaggerTestComponent;
import ggikko.me.rxtextapplication.base.di.component.Test2Component;
import ggikko.me.rxtextapplication.base.di.component.TestComponent;
import ggikko.me.rxtextapplication.base.di.module.Test2Module;
import ggikko.me.rxtextapplication.base.di.module.TestModule;
import lombok.Getter;

/**
 * Created by admin on 16. 5. 26..
 */
public class RxTextApplication extends Application {

    @Getter TestComponent testComponent;
    @Getter Test2Component test2Component;

    @Override
    public void onCreate() {
        dependency();
        super.onCreate();
    }

    private void dependency() {
//        testComponent = DaggerTestComponent.builder().test2Component(test2Component).testModule(new TestModule()).build();
//        testComponent = DaggerTestComponent.builder().testModule(new TestModule()).build();
        testComponent = DaggerTestComponent.builder().test2Component(getTest22Component()).build();
    }

    public Test2Component getTest22Component(){
        return  DaggerTest2Component.builder().build();
    }

}
