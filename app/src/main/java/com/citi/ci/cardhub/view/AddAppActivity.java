package com.citi.ci.cardhub.view;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;
import com.lqm.roundview.RoundImageView;

import butterknife.BindView;


public class AddAppActivity extends AppCompatActivity {

    @BindView(R.id.add_card_detail)
    RoundImageView cardInfo;
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
        setContentView(R.layout.activity_add_app);
    }


}
