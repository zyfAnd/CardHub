package com.citi.ci.cardhub.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;


public class PersonInfoActivity extends AppCompatActivity  {

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
        setContentView(R.layout.activity_person_info);
    }

    public void backHome(View view){
        PersonInfoActivity.this.finish();
    }
    public void updatePersonInfo(View view){
        startActivity(new Intent(PersonInfoActivity.this,UpdatePersonActivity.class));
    }
    public void update(View view){
        startActivity(new Intent(PersonInfoActivity.this,BoundingCardActivity.class));
    }
}
