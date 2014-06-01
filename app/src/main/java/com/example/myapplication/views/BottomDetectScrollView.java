/*
 * Copyright (c) 2014. Jimmy own this code.
 */

package com.example.myapplication.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.myapplication.R;

/**
 * Created by Administrator on 14-5-29.
 */
public class BottomDetectScrollView extends ScrollView {

    public static final String TAG = "com.example.myapplication.views.BottomDetectScrollView";

    public BottomDetectScrollView(Context context) {
        super(context);
    }

    public BottomDetectScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomDetectScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    boolean isLoading = false;

    ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.progress_bar, null);

    @Override
    protected synchronized void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = (View) getChildAt(getChildCount() - 1);
        int diff = (view.getBottom() - (getHeight() + getScrollY()));// Calculate the scrolldiff
        if (diff == 0 && isLoading == false) {  // if diff is zero, then the bottom has been reached
            Log.d(BottomDetectScrollView.TAG, "MyScrollView: Bottom has been reached");
            //View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.LinearLayout);


            isLoading = true;


            progressBar.setVisibility(VISIBLE);

            //linearLayout.addView(progressBar);


            for (int i = 0; i < 1; i++) {
                View entry = LayoutInflater.from(getContext()).inflate(R.layout.view_sample_entry, linearLayout);
            }

        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
