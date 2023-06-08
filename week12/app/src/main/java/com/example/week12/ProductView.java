package com.example.week12;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductView extends RecyclerView.ViewHolder{
    ImageView imgDel, imgEd, imgStar;
    TextView txtName, txtNameEdit;
    public ProductView(@NonNull View itemView) {
        super(itemView);
        imgDel = itemView.findViewById(R.id.imgDel);
        imgEd = itemView.findViewById(R.id.imgEd);
        txtName = itemView.findViewById(R.id.txtName);
        txtNameEdit = itemView.findViewById(R.id.txtNameEdit);
        imgStar = itemView.findViewById(R.id.imgStar);

    }
}
