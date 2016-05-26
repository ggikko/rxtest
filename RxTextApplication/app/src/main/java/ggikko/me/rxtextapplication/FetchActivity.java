package ggikko.me.rxtextapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FetchActivity extends AppCompatActivity {

    public static String TAG = "ggikko";

    Observable<String> firstObservable;

    Observer<String> firstObserver;

    /** view binding */
    @BindView(R.id.result) TextView result;

    @OnClick(R.id.btn_create_observerable)
    void callBtnOk(){
        firstObservable.subscribe(firstObserver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        firstObservable = Observable.just("Hello ggikko!-");

        firstObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "first on completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "first on error");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "first on next : " + s);
                //Recursion test
                firstObservable.subscribeOn(Schedulers.computation()).subscribe(firstObserver);
            }
        };

//        firstObservable.subscribe(firstObserver);

        Observable<Integer> firstArrayObserverable
                = Observable.from(new Integer[]{1, 2, 3, 4, 5, 6}); // Emits each item of the array, one at a time

        firstArrayObserverable.subscribe(i->{
                Log.e(TAG, String.valueOf(i)); // Prints the number received
            });

        Observer<Integer> secondObserver = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "on completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "on error");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, integer +"");
            }
        };

        Observable<Integer> observable = firstArrayObserverable.map(i -> i * 2).filter(i -> i!=4);;
        observable.subscribe(secondObserver);

        Observable<String> getDataNaverObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String data = getData("http://www.naver.com");
                    subscriber.onNext(data); // content 받아옴
                    subscriber.onCompleted(); // 완료
                }catch(Exception e){
                    subscriber.onError(e); // 에러발생
                }
            }
        });

        getDataNaverObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> result.setText(data), error ->Log.e(TAG,"\nerror : "+ error.toString()));

    }

    private String getData(String site) {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(new URL(site).openStream()));
            String result = "";
            while((inputReader.readLine()!=null))result += inputReader.readLine();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return site;
    }



}
