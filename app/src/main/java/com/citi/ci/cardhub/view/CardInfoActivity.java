package com.citi.ci.cardhub.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;


public class CardInfoActivity extends AppCompatActivity {

    private TextView tvCardNum;

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
        setContentView(R.layout.activity_card_info);
        intitViews();
        Intent intent = getIntent();
        String cardnum = intent.getStringExtra("Card_info");
    }

    private void intitViews() {
        tvCardNum = (TextView) findViewById(R.id.cardInfo);
    }

    public void confirm(View view) {
        CardInfoActivity.this.finish();
        startActivity(new Intent(CardInfoActivity.this, AddAppActivity.class));
    }

    public void backHome(View view) {
//        Intent intent = new Intent(CardInfoActivity.class,);
//        startActivity();
        CardInfoActivity.this.finish();
    }
}
