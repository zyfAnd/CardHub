package com.citi.ci.cardhub.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.citi.ci.cardhub.R;
import com.citi.ci.cardhub.adapter.DragAdapter;
import com.citi.ci.cardhub.shake.DragGridView;
import com.citi.ci.cardhub.utils.PopupMenuUtil;
import com.citi.ci.cardhub.utils.StatusbarColorUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * zhangyanfu
 */

public class DetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Dialog payDialog;
    private View inflate;
    //定义图标数组
    private int[] imageRes = {
            R.drawable.alipay,
            R.drawable.app1,
            R.drawable.app2,
            R.drawable.app3,
            R.drawable.app4,
            R.drawable.ic_addpic
    };

    //定义图标下方的名称数组
    private String[] name = {
            "AliPay",
            "WeChat",
            "Amazon",
            "Tencent",
            "eBay",
            ""
    };
    public int length = imageRes.length;
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();

    /**
     * 一页可见提条目数
     */
    private static final int VISIBIY_NUMS = 8;
    private DragAdapter mDragAdapter;
    public ImageView cardImgae;
//    public GridView gridView;
    DragGridView mDragGridView;
    private Dialog chooseDialog;
    public int pos;

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
        setContentView(R.layout.activity_detail);

        intiViews();
        mDragGridView.setOnItemClickListener(this);
        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);
        initData();

    }

    private void intiViews() {
        cardImgae = (ImageView) findViewById(R.id.card_image);
//        gridView = (GridView) findViewById(R.id.gridview);
        mDragGridView = (DragGridView) findViewById(R.id.dragGridView);

    }

    private void initData() {
        switch (pos % 5) {
            case 0:
                cardImgae.setImageResource(R.drawable.card_02);
                break;
            case 1:
                cardImgae.setImageResource(R.drawable.card_01);
                break;
            case 2:
                cardImgae.setImageResource(R.drawable.china_bank);
                break;
            case 3:
                cardImgae.setImageResource(R.drawable.china_bank_02);
                break;
            case 4:
                cardImgae.setImageResource(R.drawable.card_05);
                break;
        }

            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            Random random =new Random();


//            if (random.nextInt(3) == 1) {
//                itemHashMap.put("item_image",R.drawable.alipay);
//            }
//
//            if (i+1== VISIBIY_NUMS) {
//                itemHashMap.put("item_image",R.drawable.ic_addpic);
//            }
//
//            else {
//                itemHashMap.put("item_image",R.drawable.alipay);
//                itemHashMap.put("item_text", "AliPay");
//                dataSourceList.add(itemHashMap);
//            }

        for(int i=0;i<VISIBIY_NUMS;i++){
            itemHashMap = new HashMap<>();
            switch (i){
                case 0:
                    itemHashMap.put("item_image",R.drawable.alipay);
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    itemHashMap.put("item_text", "支付宝");
                    dataSourceList.add(itemHashMap);
                    break;
                case 1:
                    itemHashMap.put("item_image",R.drawable.app1);
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    itemHashMap.put("item_text", "网易云音乐");
                    dataSourceList.add(itemHashMap);
                    break;
                case 2:
                    itemHashMap.put("item_image",R.drawable.app2);
                    itemHashMap.put("item_text", "猫眼看电影");
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
                case 3:
                    itemHashMap.put("item_image",R.drawable.app3);
                    itemHashMap.put("item_text", "去哪儿");
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
                case 4:
                    itemHashMap.put("item_image",R.drawable.app4);
                    itemHashMap.put("item_text", "美团");
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
                case 5:
                    itemHashMap.put("item_image",R.drawable.app5);
                    itemHashMap.put("item_text", "摩拜单车");
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
                case 6:
                    itemHashMap.put("item_image",R.drawable.app6);
                    itemHashMap.put("item_text", "大众点评");
                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
                case 7:
                    itemHashMap.put("item_image",R.drawable.add_card_line);
//                    itemHashMap.put("item_text", "ofo");
//                    itemHashMap.put("choose_image",R.drawable.regards_choose_pay);
                    dataSourceList.add(itemHashMap);
                    break;
            }

        }




//            itemHashMap.put("item_text", "eBay" );
//            dataSourceList.add(itemHashMap);
//            itemHashMap.put("item_text", "Amazon" );
//            dataSourceList.add(itemHashMap);
//            itemHashMap.put("item_text", "Tencent" );
//            dataSourceList.add(itemHashMap);
//            itemHashMap.put("item_text", "WeChat");
//            dataSourceList.add(itemHashMap);


        mDragAdapter = new DragAdapter(this, dataSourceList);

        mDragGridView.setAdapter(mDragAdapter);
        //设置需要抖动
        mDragGridView.setNeedShake(true);
        //生成适配器的ImageItem 与动态数组的元素相对应
//        SimpleAdapter saImageItems = new SimpleAdapter(this,
//                lstImageItem,//数据来源
//                R.layout.item_gridview,//item的XML实现
//
//                //动态数组与ImageItem对应的子项
//                new String[]{"ItemImage", "ItemText"},
//
//                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
//                new int[]{R.id.img_shoukuan, R.id.txt_shoukuan});
//        //添加并且显示
//        gridView.setAdapter(saImageItems);
//        //添加消息处理
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 5) {
//                    Logger.e("position-----add---" + position);
//                    FragmentManager fm = getSupportFragmentManager();
//                    BottomDialogFragment editNameDialog = new BottomDialogFragment();
//                    editNameDialog.show(fm, "fragment_bottom_dialog");
//                }
//                Toast.makeText(DetailActivity.this, name[position], Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 7) {
            Logger.e("position-----add---" + position);
//            FragmentManager fm = getSupportFragmentManager();
//            BottomDialogFragment editNameDialog = new BottomDialogFragment();
//            editNameDialog.show(fm, "fragment_bottom_dialog");

            PopupMenuUtil.getInstance()._show(this,view);


        }
//        Toast.makeText(DetailActivity.this, name[position], Toast.LENGTH_LONG).show();
    }
    public void backToHome(View view){
        DetailActivity.this.finish();
    }
    public void pay(View view){
        chooseDialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.payment_success_dialog, null);
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
//        startActivity(new Intent(DetailActivity.this,PayActivity.class));

//        try {
//            Thread.sleep(3000);
//        }catch (Exception e){
//
//        }
//        progressView.setStatus(MyStyleProgress.Status.LoadSuccess);
//        progressView.startAnima();
    }
    public void dismissDialog(View view){
        chooseDialog.dismiss();
    }
}
