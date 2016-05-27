package ggikko.me.rxtextapplication.base.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.rxtextapplication.base.di.qualifier.PerActivity;
import ggikko.me.rxtextapplication.base.util.ByePrinter;
import ggikko.me.rxtextapplication.base.util.DaddyPrinter;
import ggikko.me.rxtextapplication.base.util.GoodPrinter;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;

/**
 * Created by admin on 16. 5. 26..
 */

@Module
public class TestModule {

    @Provides @PerActivity HelloPrinter helloPrinter(DaddyPrinter daddyPrinter){
        return HelloPrinter.getInstance();
    }
//    @Provides @PerActivity HelloPrinter helloPrinter(DaddyPrinter daddyPrinter){
//        return HelloPrinter.getInstance();
//    }

    @Provides @PerActivity ByePrinter byePrinter(){
        return new ByePrinter();
    }

    @Provides @PerActivity GoodPrinter goodPrinter(){
        return new GoodPrinter();
    }



}
