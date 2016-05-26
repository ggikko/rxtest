package ggikko.me.rxtextapplication.base.follow.wharton;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by ggikko on 16. 5. 26..
 */
public class Timeline {

    private final List<Tweet> cache = new ArrayList<>();
    private final TwitterApi api = new TwitterApi(new OkHttpClient());
    private final String user;

    public Timeline(String user) {
        this.user = user;
    }

    public List<Tweet> get() {
        return new ArrayList<>();
    }

    public void loadMore(int amount) {

    }

}
