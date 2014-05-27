/*
 * Copyright (c) 2014. Jimmy own this code.
 */

package com.example.myapplication.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.myapplication.R;
import com.example.myapplication.activities.common.ParentActivity;
import com.example.myapplication.views.PieChart;

public class ScrollViewActivity extends ParentActivity {
    /**
     * Called when the activity is first created.
     */
    private LinearLayout mLayout;
    private ScrollView sView;
    private final Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_scroll_view_activity);

        mLayout = (LinearLayout) this.findViewById(R.id.LinearLayout);
        sView = (ScrollView) this.findViewById(R.id.ScrollView);
        ((Button) this.findViewById(R.id.Button)).setOnClickListener(mClickListener);

    }

    private Button.OnClickListener mClickListener = new Button.OnClickListener() {

        private int index = 1;

        @Override
        public void onClick(View v) {
//            TextView tView = new TextView(Test_ScrollView.this);//定义一个TextView
//            tView.setText("TextView" + index);//设置TextView的文本信息
            //设置线性布局的属性

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

//            mLayout.addView(tView, params);//添加一个TextView控件
            Button button = new Button(ScrollViewActivity.this);//定义一个Button
            button.setText("Button" + index);//设置Button的文本信息
            button.setOnClickListener(mClickListener);// 添加点击事件监听
            button.setId(index++);
            PieChart chart = new PieChart(ScrollViewActivity.this);
            //PieChat entry = new PieChat(ScrollViewActivity.this);
            mLayout.addView(button, params);//添加一个Button控件
            mLayout.addView(chart);
            mHandler.post(mScrollToButton);//传递一个消息进行滚动

        }

    };
    private Runnable mScrollToButton = new Runnable() {

        @Override
        public void run() {
            int off = mLayout.getMeasuredHeight() - sView.getHeight();
            if (off > 0) {
                sView.scrollTo(0, off);//改变滚动条的位置  
            }
        }

    };


}  