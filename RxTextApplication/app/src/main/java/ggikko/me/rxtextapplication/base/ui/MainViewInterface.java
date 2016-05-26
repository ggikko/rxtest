package ggikko.me.rxtextapplication.base.ui;


import rx.Observable;

/**
 * Created by admin on 16. 5. 26..
 */
public interface MainViewInterface {

    void onCompleted();

    void onError(String message);

    void onText(String result);

}
