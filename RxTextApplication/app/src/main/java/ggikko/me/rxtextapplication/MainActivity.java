package ggikko.me.rxtextapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> firstObservable
                = Observable.just("Hello ggikko!-");

        Observer<String> firstObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                Log.d("ggikko", s);
            }
        };

        firstObservable.subscribe(firstObserver);

        Observable<Integer> firstArrayObserverable
                = Observable.from(new Integer[]{1, 2, 3, 4, 5, 6}); // Emits each item of the array, one at a time

        firstArrayObserverable.subscribe(i->{
                Log.d("ggikko", String.valueOf(i)); // Prints the number received
            });
    }

}
