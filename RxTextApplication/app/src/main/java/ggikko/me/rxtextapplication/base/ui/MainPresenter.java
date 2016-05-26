package ggikko.me.rxtextapplication.base.ui;


import android.util.Log;

import ggikko.me.rxtextapplication.base.presenter.BasePresenter;
import rx.Observable;
import rx.Observer;

/**
 * Created by admin on 16. 5. 26..
 */
public class MainPresenter extends BasePresenter implements Observer<String> {
    MainViewInterface viewInterface;

    public MainPresenter(MainViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {
        viewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        viewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(String s) {
        viewInterface.onText(s);
    }

    public void createTextObservable(String s) {
        Log.e("ggikko", "createTextObservable");
//        unSubscribeAll();
        subscribe(Observable.just(s), MainPresenter.this);
    }

}
