package ggikko.me.rxtextapplication.base.follow.wharton;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by admin on 16. 5. 26..
 */
public class TwitterApi {

    
    public void postTweet(String ggikko, String tweet) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().build();
        client.newCall(request).execute();
    }


}
