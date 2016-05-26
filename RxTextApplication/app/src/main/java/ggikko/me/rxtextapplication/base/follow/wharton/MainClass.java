package ggikko.me.rxtextapplication.base.follow.wharton;

import java.io.IOException;

/**
 * Created by admin on 16. 5. 26..
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        Tweeter tweeter = new Tweeter("ggikko");
        tweeter.tweet("Hello, ggikko");
        tweeter.tweet("where u at?");
        tweeter.tweet("a Yo!");

    }
}
