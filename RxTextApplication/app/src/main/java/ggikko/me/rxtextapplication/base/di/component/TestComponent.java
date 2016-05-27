package ggikko.me.rxtextapplication.base.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.rxtextapplication.base.activity.BaseActivity;
import ggikko.me.rxtextapplication.base.di.module.Test2Module;
import ggikko.me.rxtextapplication.base.di.module.TestModule;
import ggikko.me.rxtextapplication.base.di.qualifier.PerActivity;
import ggikko.me.rxtextapplication.base.ui.DaggerActivity;
import ggikko.me.rxtextapplication.base.ui.MainActivity;

/**
 * Created by ggikko on 16. 5. 26..
 */


@PerActivity
@Component(modules = TestModule.class, dependencies = Test2Component.class)
public interface TestComponent {

    void injectActivity(DaggerActivity daggerActivity);
//    void injectMainActivity(MainActivity mainActivity);

}
