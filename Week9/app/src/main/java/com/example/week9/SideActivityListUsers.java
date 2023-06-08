package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SideActivityListUsers extends AppCompatActivity {

    private UserStorage userStorage;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_list_users);

        userStorage = UserStorage.getInstance();
        recyclerView = findViewById(R.id.ListOfThings);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), userStorage.getUsers()));
    }


}