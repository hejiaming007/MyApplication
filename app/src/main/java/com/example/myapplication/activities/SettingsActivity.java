/*
 * Copyright (c) 2014. Jimmy own this code.
 */

package com.example.myapplication.activities;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.activities.common.ParentActivity;

public class SettingsActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

}
