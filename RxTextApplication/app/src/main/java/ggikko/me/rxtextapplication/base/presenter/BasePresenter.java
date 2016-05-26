package ggikko.me.rxtextapplication.base.presenter;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ggikko on 16. 5. 26..
 */
public abstract class BasePresenter implements Presenter {

    private static String TAG = "ggikko";

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {
        Log.e(TAG,"BasePresenter : Oncreate");
        configureSubscription();
    }

    @Override
    public void onPause() {
        Log.e(TAG,"BasePresenter : OnPause");
    }

    @Override
    public void onResume() {
        Log.e(TAG,"BasePresenter : onResume");

    }

    private CompositeSubscription configureSubscription() {
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed()) {
            compositeSubscription = new CompositeSubscription();
            Log.e("ggikko", "gogo");
        }
        return compositeSubscription;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"BasePresenter : onDestroy");
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);

        configureSubscription().add(subscription);
    }


}
