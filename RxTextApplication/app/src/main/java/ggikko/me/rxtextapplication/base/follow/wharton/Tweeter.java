package ggikko.me.rxtextapplication.base.follow.wharton;

/**
 * Created by admin on 16. 5. 26..
 */
public class Tweeter {
    public void tweet(String tweet){
        TwitterApi api = new TwitterApi();
        api.postTweet("ggikko", tweet);

    }
}
