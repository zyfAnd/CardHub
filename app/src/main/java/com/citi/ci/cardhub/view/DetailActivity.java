package com.citi.ci.cardhub.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.citi.ci.cardhub.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;


public class DetailActivity extends AppCompatActivity {
    //定义图标数组
    private int[] imageRes = {
            R.drawable.alipay,
            R.drawable.alipay,
            R.drawable.alipay,
            R.drawable.alipay,
            R.drawable.alipay,
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
    public  int length = imageRes.length;

    public ImageView cardImgae;
    public GridView gridView;
    public int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intiViews();
        Intent intent = getIntent();
        pos = intent.getIntExtra("position",0);
        initData();
    }
    private void intiViews(){
        cardImgae = (ImageView) findViewById(R.id.card_image);
        gridView = (GridView) findViewById(R.id.gridview);

    }
    private void initData(){
        switch (pos%5) {
            case 0:
                cardImgae.setImageResource(R.drawable.one);
                break;
            case 1:
                cardImgae.setImageResource(R.drawable.two);
                break;
            case 2:
                cardImgae.setImageResource(R.drawable.three);
                break;
            case 3:
                cardImgae.setImageResource(R.drawable.four);
                break;
            case 4:
                cardImgae.setImageResource(R.drawable.five);
                break;

        }
        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageRes[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem 与动态数组的元素相对应
        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,//数据来源
                R.layout.item_gridview,//item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.img_shoukuan, R.id.txt_shoukuan});
        //添加并且显示
        gridView.setAdapter(saImageItems);
        //添加消息处理
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==5){
                    Logger.e("position-----add---"+position);
                    FragmentManager fm = getSupportFragmentManager();
                    BottomDialogFragment editNameDialog = new BottomDialogFragment();
                    editNameDialog.show(fm, "fragment_bottom_dialog");
                }
                Toast.makeText(DetailActivity.this,name[position],Toast.LENGTH_LONG).show();
            }
        });
    }

}
