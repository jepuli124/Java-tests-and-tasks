package com.example.week9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserView extends RecyclerView.ViewHolder {
    ImageView profile;
    TextView txtName, txtProfession, txtEmail, txtDegrees;


    public UserView(@NonNull View itemView) {
        super(itemView);
        profile = itemView.findViewById(R.id.PP);
        txtName = itemView.findViewById(R.id.txtName);
        txtProfession = itemView.findViewById(R.id.txtProfession);
        txtEmail = itemView.findViewById(R.id.txtEmail);
        txtDegrees = itemView.findViewById(R.id.txtDegrees);
    }
}
