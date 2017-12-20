package com.citi.ci.cardhub.view;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.citi.cardstack.CardStackView;
import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.adapter.MyStackAdapter;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;

import java.util.Arrays;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

/**
 * zhangyanfu
 */
public class MainActivity extends AppCompatActivity implements CardStackView.ItemExpendListener {
    public final static int REQUEST_AUTOTEST = 2;
    public final static int SCANNING_REQUEST_CODE = 1;
    private Dialog chooseDialog;
    private View inflate;
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
            R.drawable.card_02,
            R.drawable.card_01,
            R.drawable.card_03,
            R.drawable.card_04,
            R.drawable.card_05,
            R.drawable.card_01,
            R.drawable.card_02,
            R.drawable.card_03,
            R.drawable.card_04,
            R.drawable.card_05,
            R.drawable.card_01,
            R.drawable.card_02,
            R.drawable.card_03,
            R.drawable.card_04,
            R.drawable.card_05,
            R.drawable.card_01,
            R.drawable.card_02,
            R.drawable.card_03,
            R.drawable.card_04,
            R.drawable.card_05,
            R.drawable.card_01,
            R.drawable.card_02,
            R.drawable.card_03,
            R.drawable.card_04,
            R.drawable.card_05,
            R.drawable.card_01
    };
    private CardStackView mStackView;
    private LinearLayout mActionButtonContainer;
    private MyStackAdapter mTestStackAdapter;

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
        setContentView(R.layout.activity_main);

        mStackView = (CardStackView) findViewById(R.id.stackview_main);
//        mActionButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mStackView.setItemExpendListener(this);
        mTestStackAdapter = new MyStackAdapter(this);
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
        mTestStackAdapter.setOnItemCilckListener(new MyStackAdapter.OnItemClickListener() {
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
//                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                startActivityForResult(intent, SCANNING_REQUEST_CODE);
//                mStackView.setAnimatorAdapter(new AllMoveDownAnimatorAdapter(mStackView));
//                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivityForResult(intent, SCANNING_REQUEST_CODE);

                scan();
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
//        mActionButtonContainer.setVisibility(expend ? View.VISIBLE : View.GONE);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        switch (requestCode) {
////            case SCANNING_REQUEST_CODE:
////                if (resultCode == RESULT_OK) {
////                    final Bundle bundle = data.getExtras();
////                    Handler handler = new Handler(Looper.getMainLooper());
////                    handler.post(new Runnable() {
////                        @Override
////                        public void run() {
////                            Logger.e("scan ------message-----");
////                            Toast.makeText(MainActivity.this,bundle.getString("result"),Toast.LENGTH_LONG).show();
//////                            textView.setText(bundle.getString("result"));
////                        }
////                    });
////                }
////                break;
////            default:
////                break;
////        }
//        if (requestCode == SCANNING_REQUEST_CODE) {
//            //处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
//        }
//    }
    public void scan() {
        Intent intent = new Intent(this, CardIOActivity.class)
                .putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false)
                .putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false)
                .putExtra(CardIOActivity.EXTRA_HIDE_CARDIO_LOGO, true)//去除水印
                .putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, true)//去除键盘
                .putExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE, "zh-Hans")//设置提示为中文
                .putExtra("debug_autoAcceptResult", true);
        startActivityForResult(intent, REQUEST_AUTOTEST);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String outStr = new String();
        if ((requestCode == REQUEST_AUTOTEST) && data != null
                && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            CreditCard result = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
            if (result != null) {
                outStr  = result.cardNumber ;
            }
        }
//        tv_num.setText(outStr);
        Toast.makeText(this,"获取到银行卡信息"+outStr,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,CardInfoActivity.class);
        if(outStr==null&&outStr.equals(""))
        {
            outStr = "8912 5420 0100 5231";
        }
        intent.putExtra("card_num",outStr);
        startActivity(intent);
    }

    public void triggerPayment(View view){
        show();
    }

    private void show(){
        chooseDialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.repayment_dialog, null);
        //将布局设置给Dialog
        chooseDialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = chooseDialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        chooseDialog.show();//显示对话框
    }
    public void repayment(View view){

        startActivity(new Intent(MainActivity.this,PayActivity.class));
        chooseDialog.dismiss();
    }
    public void backToList(View view){
        chooseDialog.dismiss();
    }

    public void addCard(View view){
        scan();
    }
}

