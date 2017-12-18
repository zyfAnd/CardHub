package com.citi.ci.cardhub.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.citi.ci.cardhub.R;
import com.lqm.roundview.RoundImageView;

import butterknife.BindView;


public class AddAppActivity extends AppCompatActivity {

    @BindView(R.id.add_card_detail)
    RoundImageView cardInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_app);
    }


}
