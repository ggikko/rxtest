package ggikko.me.rxtextapplication.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.rxtextapplication.FetchActivity;
import ggikko.me.rxtextapplication.R;
import ggikko.me.rxtextapplication.RxTextApplication;
import ggikko.me.rxtextapplication.base.activity.BaseActivity;
import ggikko.me.rxtextapplication.base.util.ByePrinter;
import ggikko.me.rxtextapplication.base.util.DaddyPrinter;
import ggikko.me.rxtextapplication.base.util.GoodPrinter;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;
import ggikko.me.rxtextapplication.base.util.MommyPrinter;
import rx.Observable;
import rx.Observer;

public class MainActivity extends BaseActivity implements MainViewInterface {

    private final String TAG = "ggikko";

    @Inject HelloPrinter helloPrinter;
    @Inject ByePrinter byePrinter;
    @Inject GoodPrinter goodPrinter;
//    @Inject DaddyPrinter daddyPrinter;
//    @Inject MommyPrinter mommyPrinter;

    private Observer<String> ggikkoObserver;
    private Observable<String> ggikkoObservable;

    StringBuffer total = new StringBuffer();

    @BindView(R.id.btn_create_observerable) Button btn_create_observerable;
    @BindView(R.id.btn_subscribe_observerable) Button btn_subscribe_observerable;
    @BindView(R.id.result) TextView resultText;
    @BindView(R.id.btn_inject) Button btn_inject;

    @OnClick(R.id.btn_fetch)
    void callFetchActivity(){
        startActivity(new Intent(MainActivity.this, FetchActivity.class));
    }

    boolean flag = false;

    @OnClick(R.id.btn_create_observerable)
    void callCreate(){
        if(flag) {
            flag=false;
            ggikkoObservable = Observable.just("Hello ggikko!!"); // Emits "Hello"
        }else{
            flag=true;
            ggikkoObservable = Observable.just("Bye ggikko!!"); // Emits "Bye"
        }
    }

    @OnClick(R.id.btn_subscribe_observerable)
    void callSubscribe(){
        if(ggikkoObservable != null)
        ggikkoObservable.subscribe(ggikkoObserver);
    }

    @OnClick({R.id.btn_make1,R.id.btn_make2,R.id.btn_make3,R.id.btn_dagger, R.id.btn_inject})
    void callMakeSubscription(View view){
        switch (view.getId()) {
            case R.id.btn_make1 :  {
                mainPresenter.createTextObservable("btn 1");
                break;
            }
            case R.id.btn_make2 :  {
                mainPresenter.createTextObservable("btn 2");
                break;
            }
            case R.id.btn_make3 :  {
                mainPresenter.createTextObservable("btn 3");
                break;
            }
            case R.id.btn_dagger :  {
                startActivity(new Intent(MainActivity.this, DaggerActivity.class));
                break;
            }
            case R.id.btn_inject :  {
//                resultText.setText(daddyPrinter.daddy());
                break;
            }
        }
    }

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        ((RxTextApplication)getApplication()).getTestComponent().injectMainActivity(MainActivity.this);

        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate();

        ggikkoObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
            }

            @Override
            public void onNext(String s) {
                // Called each time the observable emits data
                resultText.setText(s);
                Log.d(TAG, s);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume, FetchActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause, FetchActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy, FetchActivity");
    }


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onText(String result) {
        total.append(result);
        resultText.setText(total.toString());
    }

}
