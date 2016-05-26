package ggikko.me.rxtextapplication.base.follow.wharton;

import java.io.IOException;

import okhttp3.OkHttpClient;

/**
 * Created by admin on 16. 5. 26..
 */
public class Tweeter {

    private final TwitterApi api = new TwitterApi(new OkHttpClient());
    private final String user;

    public Tweeter(String user) {
        this.user = user;
    }

    public void tweet(String tweet) throws IOException {
        api.postTweet(user, tweet);
    }

    /**
     *    module 단위로 injection 및 constructor 생산자로서 서로 dependency생성
     *    constructor , field, method inject
     */
}
