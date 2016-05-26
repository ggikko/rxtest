package ggikko.me.rxtextapplication.base.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.rxtextapplication.base.di.module.Test2Module;
import ggikko.me.rxtextapplication.base.ui.DaggerActivity;

/**
 * Created by admin on 16. 5. 26..
 */

//@Singleton
@Component(modules = Test2Module.class)
public interface Test2Component {

//    void inject(DaggerActivity daggerActivity);

}
