package ggikko.me.rxtextapplication.base.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.rxtextapplication.base.util.ByePrinter;
import ggikko.me.rxtextapplication.base.util.GoodPrinter;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;

/**
 * Created by admin on 16. 5. 26..
 */

@Module
public class TestModule {

    @Provides @Singleton HelloPrinter helloPrinter(){
        return HelloPrinter.getInstance();
    }

    @Provides @Singleton ByePrinter byePrinter(){
        return new ByePrinter();
    }

    @Provides @Singleton GoodPrinter goodPrinter(){
        return new GoodPrinter();
    }



}
