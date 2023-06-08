package com.example.week12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductView>{
    private Context context;
    private ArrayList<Product> products = new ArrayList<Product>();

    public ProductAdapter(Context context, ArrayList<Product> products) {
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
        if(!Storage.getInstance().getProduct(pos).star) {
            holder.imgStar.setVisibility(View.GONE);
        }

        holder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Storage.getInstance().delProduct(pos);
                notifyItemRemoved(pos);
            }
        });

        holder.imgEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (holder.txtNameEdit.getVisibility() == View.GONE) {
                    holder.txtNameEdit.setText(holder.txtName.getText());
                    holder.txtNameEdit.setVisibility(View.VISIBLE);
                    holder.txtName.setVisibility(View.GONE);
                }
                else{
                    Product product = Storage.getInstance().getProduct(pos);
                    product.setText(holder.txtNameEdit.getText().toString());
                    holder.txtNameEdit.setVisibility(View.GONE);
                    holder.txtName.setVisibility(View.VISIBLE);
                    //MainActivity.getInstance().getRefresher2().onRefresh2();
                }

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount(){
        return products.size();
    }
}
