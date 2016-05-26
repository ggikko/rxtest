package ggikko.me.rxtextapplication.base.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;

/**
 * Created by admin on 16. 5. 26..
 */

@Module
public class TestModule {

    @Provides
    @Singleton
    HelloPrinter helloPrinter(){
        return HelloPrinter.getInstance();
    }

}
