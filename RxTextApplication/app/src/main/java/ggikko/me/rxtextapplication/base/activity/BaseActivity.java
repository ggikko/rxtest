package ggikko.me.rxtextapplication.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ggikko.me.rxtextapplication.RxTextApplication;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by admin on 16. 5. 26..
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "ggikko";

    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume, BaseActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause, BaseActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy, BaseActivity");

    }
}
