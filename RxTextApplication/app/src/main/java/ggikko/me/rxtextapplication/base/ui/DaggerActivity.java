package ggikko.me.rxtextapplication.base.ui;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.rxtextapplication.R;
import ggikko.me.rxtextapplication.RxTextApplication;
import ggikko.me.rxtextapplication.base.activity.BaseActivity;
import ggikko.me.rxtextapplication.base.util.ByePrinter;
import ggikko.me.rxtextapplication.base.util.DaddyPrinter;
import ggikko.me.rxtextapplication.base.util.GoodPrinter;
import ggikko.me.rxtextapplication.base.util.HelloPrinter;
import ggikko.me.rxtextapplication.base.util.MommyPrinter;

public class DaggerActivity extends BaseActivity {

    @Inject HelloPrinter helloPrinter;
    @Inject ByePrinter byePrinter;
    @Inject GoodPrinter goodPrinter;
    @Inject DaddyPrinter daddyPrinter;
//    @Inject MommyPrinter mommyPrinter;

    @OnClick({R.id.hello, R.id.babo, R.id.genius})
    void callOnClick(View view){
        switch (view.getId()){

            case R.id.hello :{
                helloPrinter.hello();
                daddyPrinter.daddy();
                break;
            }

            case R.id.babo :{
                helloPrinter.babo();
//                mommyPrinter.mommy();
                break;
            }

            case R.id.genius :{
                helloPrinter.genius();
                byePrinter.bye();
                goodPrinter.good();
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        ButterKnife.bind(this);

        ((RxTextApplication)getApplication()).getTestComponent().injectActivity(DaggerActivity.this);
//        ((RxTextApplication)getApplication()).getTestComponent().inject(DaggerActivity.this);
//        ((RxTextApplication)getApplication()).getTest2Component().inject(DaggerActivity.this);
    }
}
