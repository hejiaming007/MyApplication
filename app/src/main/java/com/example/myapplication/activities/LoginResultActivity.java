package com.example.myapplication.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activities.common.ParentActivity;

import org.apache.commons.lang3.StringUtils;

public class LoginResultActivity extends ParentActivity {


    private final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
//        System.out.println("username:"+username); //Ctrl + j

        Log.d(TAG, "username:" + username);

        Log.d(TAG, "password:" + password);


        TextView textView = (TextView) findViewById(R.id.loginResult);

        if (authenticate(username, password)) {
            textView.setText("Success.");
        } else {
            textView.setText("Failed.");
        }

    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
            return super.onOptionsItemSelected(item);
        }


    private boolean authenticate(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        } else {
            return true;
        }
    }

}
