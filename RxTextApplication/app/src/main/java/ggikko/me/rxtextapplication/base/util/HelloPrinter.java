package ggikko.me.rxtextapplication.base.util;

import android.util.Log;

/**
 * Created by admin on 16. 5. 26..
 */
public class HelloPrinter {

    public static HelloPrinter getInstance(){
        return new HelloPrinter();
    }

    public static String hello(){
        Log.e("ggikko", "hello");
        return "hello";
    }

    public void babo(){
        Log.e("ggikko", "babo");
    }

    public void genius(){
        Log.e("ggikko", "genius");
    }

}
