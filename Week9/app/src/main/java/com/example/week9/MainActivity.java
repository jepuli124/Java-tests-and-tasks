package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        UserStorage.getInstance().loadUsers(context);
    }
    public void switchToSideAddInfo(View view) {
        Intent intent = new Intent(this, SideActivityAddInfo.class);
        startActivity(intent);
    }
    public void switchToSideListUsers(View view) {
        Intent intent = new Intent(this, SideActivityListUsers.class);
        startActivity(intent);
    }
}