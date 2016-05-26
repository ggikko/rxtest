package ggikko.me.rxtextapplication.base.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.rxtextapplication.R;
import ggikko.me.rxtextapplication.base.activity.BaseActivity;
import rx.Observable;
import rx.Observer;

public class MainActivity extends BaseActivity {

    private final String TAG = "ggikko";

    private Observer<String> ggikkoObserver;
    private Observable<String> ggikkoObservable;

    @Bind(R.id.btn_create_observerable) Button btn_create_observerable;
    @Bind(R.id.btn_subscribe_observerable) Button btn_subscribe_observerable;
    @Bind(R.id.result) TextView result;

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
        ggikkoObservable.subscribe(ggikkoObserver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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
                result.setText(s);
                Log.d(TAG, s);
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume, MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause, MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy, MainActivity");

    }
}
