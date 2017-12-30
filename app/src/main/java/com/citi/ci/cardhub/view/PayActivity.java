package com.citi.ci.cardhub.view;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;


public class PayActivity extends AppCompatActivity {

    private NumberRunningTextView tvMoney;
    private NumberRunningTextView tvNum;
    private LinearLayout srlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusbarColorUtils.setStatusBarDarkIcon(this, true);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorview = getWindow().getDecorView();
            decorview.setSystemUiVisibility
                    (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_pay);
        initView();
        tvMoney.setContent("845.00");
        tvNum.setContent("6680.55");
    }

    private void initView() {
        srlRoot = (LinearLayout) findViewById(R.id.srl_root);
        tvMoney = (NumberRunningTextView) findViewById(R.id.tv_money);
        tvNum = (NumberRunningTextView) findViewById(R.id.tv_num);

//        srlRoot.setColorSchemeColors(Color.parseColor("#ff7300"));
    }
    public void pay(View view ){
        tvMoney.setContent("0.00");
        tvNum.setContent("7525.55");
    }
    public void backHome(View view){
        PayActivity.this.finish();
    }
}
