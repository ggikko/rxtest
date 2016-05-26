package ggikko.me.rxtextapplication.base.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.rxtextapplication.R;
import ggikko.me.rxtextapplication.RxTextApplication;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;

public class DaggerActivity extends AppCompatActivity {

    @Inject HelloPrinter helloPrinter;

    @OnClick({R.id.hello, R.id.babo, R.id.genius})
    void callOnClick(View view){
        switch (view.getId()){

            case R.id.hello :{
                helloPrinter.hello();
                break;
            }

            case R.id.babo :{
                helloPrinter.babo();
                break;
            }

            case R.id.genius :{
                helloPrinter.genius();
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        ButterKnife.bind(this);

        ((RxTextApplication)getApplication()).getTestComponent().inject(DaggerActivity.this);
    }
}
