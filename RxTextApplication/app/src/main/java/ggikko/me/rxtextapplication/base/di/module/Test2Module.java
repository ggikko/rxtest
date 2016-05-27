package ggikko.me.rxtextapplication.base.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.rxtextapplication.base.di.qualifier.PerActivity;
import ggikko.me.rxtextapplication.base.util.DaddyPrinter;
import ggikko.me.rxtextapplication.base.util.MommyPrinter;

/**
 * Created by ggikko on 16. 5. 26..
 */
@Module
public class Test2Module {

    @Provides @Singleton
    DaddyPrinter daddyPrinter(){
        return new DaddyPrinter();
    };

    @Provides @Singleton
    MommyPrinter mommyPrinter(){
        return new MommyPrinter();
    };

}
