package com.citi.ci.cardhub.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;


public class PersonInfoActivity extends AppCompatActivity  {

    private EditText edName;
    private EditText edPhone;
    private EditText edAddress;
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
        initViews();
    }

    public void backHome(View view){
        PersonInfoActivity.this.finish();
    }
//    public void updatePersonInfo(View view){
//        startActivity(new Intent(PersonInfoActivity.this,UpdatePersonActivity.class));
//    }
    public void updatePersonInfo(View view){
//        startActivity(new Intent(PersonInfoActivity.this,BoundingCardActivity.class));
        edName.setFocusable(true);
        edName.setFocusableInTouchMode(true);
        edName.requestFocus();
        edAddress.setFocusable(true);
        edAddress.setFocusableInTouchMode(true);
        edAddress.requestFocus();
        edPhone.setFocusable(true);
        edPhone.setFocusableInTouchMode(true);
        edPhone.requestFocus();
    }
    private void initViews(){
        edName = (EditText) findViewById(R.id.nameInfo);
        edAddress = (EditText) findViewById(R.id.addressInfo);
        edPhone = (EditText) findViewById(R.id.phoneInfo);
    }
    public void save(View view){

    }
}
