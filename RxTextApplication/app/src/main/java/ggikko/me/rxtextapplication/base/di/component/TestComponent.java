package ggikko.me.rxtextapplication.base.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.rxtextapplication.base.di.module.TestModule;
import ggikko.me.rxtextapplication.base.ui.DaggerActivity;

/**
 * Created by admin on 16. 5. 26..
 */
@Singleton
@Component(modules = TestModule.class)
public interface TestComponent {

    void inject(DaggerActivity daggerActivity);
}
