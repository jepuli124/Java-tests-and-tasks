package com.example.week12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarProductAdapter extends RecyclerView.Adapter<ProductView>{
    private Context context;
    private ArrayList<Product> products = new ArrayList<Product>();

    public StarProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }
    @NonNull
    @Override
    public ProductView onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new ProductView(LayoutInflater.from(context).inflate(R.layout.activity_list_part, parent, false));

    }
    @Override
    public void onBindViewHolder(@NonNull ProductView holder, int position){

        holder.txtName.setText(products.get(position).getText());
        int pos = holder.getAdapterPosition();

    }

    @Override
    public int getItemCount(){
        return products.size();
    }
}
