package com.example.myapplication.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activities.common.ParentActivity;

/*
* jimmy
* */
public class LoginActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onLogin(View view) {
        Log.d(TAG, "Login button clicked.");

//
        Intent intent = new Intent(this, LoginResultActivity.class);
        Log.d(TAG, "Going to get widget value");


        String username = ((TextView) findViewById(R.id.username)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        Log.d(TAG, "username:" + username);
        Log.d(TAG, "password:" + password);
        intent.putExtra("username", username);
        intent.putExtra("password", password);

//        intent.putExtra("username",username);
//        intent.putExtra("password",password);
        startActivity(intent);

        //Ev1.setText(strTmp);
    }

//
//    public void clickMenuSettings(MenuItem menuItem) {
//        Log.d(TAG, "settings....");
//
//    }

    public void makePhoneCall(View view) {

        Uri uri = Uri.parse("tel:123456789012345");

        Intent intent = new Intent(Intent.ACTION_CALL, uri);

        startActivity(intent);

    }


}
