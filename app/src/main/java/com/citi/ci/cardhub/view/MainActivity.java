package com.citi.ci.cardhub.view;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.citi.cardstack.AllMoveDownAnimatorAdapter;
import com.citi.cardstack.CardStackView;
import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.adapter.TestStackAdapter;

import java.util.Arrays;

/**
 * zhangyanfu
 */
public class MainActivity extends AppCompatActivity implements CardStackView.ItemExpendListener {
    public static Integer[] TEST_DATAS = new Integer[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25,
            R.color.color_26
    };
    public static Integer[] TEST_DATAS_temp = new Integer[]{
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one
    };
    private CardStackView mStackView;
    private LinearLayout mActionButtonContainer;
    private TestStackAdapter mTestStackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStackView = (CardStackView) findViewById(R.id.stackview_main);
        mActionButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mStackView.setItemExpendListener(this);
        mTestStackAdapter = new TestStackAdapter(this);
        mStackView.setAdapter(mTestStackAdapter);


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS_temp));
                    }
                }
                , 200
        );
        mTestStackAdapter.setOnItemCilckListener(new TestStackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_image:
//                mStackView.setAnimatorAdapter(new AllMoveDownAnimatorAdapter(mStackView));

                break;
//            case R.id.menu_up_down:
//                mStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(mStackView));
//                break;
//            case R.id.menu_up_down_stack:
//                mStackView.setAnimatorAdapter(new UpDownStackAnimatorAdapter(mStackView));
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    public void onPreClick(View view) {
//        mStackView.pre();
//    }
//
//    public void onNextClick(View view) {
//        mStackView.next();
//    }

    @Override
    public void onItemExpend(boolean expend) {
        mActionButtonContainer.setVisibility(expend ? View.VISIBLE : View.GONE);
    }
}

