package com.example.doanandroid02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroid02.R;
import com.example.doanandroid02.models.Product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductAdapter.ItemHolder> {

    List<Product> products;
    Context context;

    public NewProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{

        public ImageView imgSanPham;
        public TextView textTenSp;
        public TextView textGiaSp;

        public ItemHolder(@NonNull View itemView){
            super(itemView);
            imgSanPham = itemView.findViewById(R.id.imgSanPhamDesc);
            textTenSp = itemView.findViewById(R.id.textTenSpDesc);
            textGiaSp = itemView.findViewById(R.id.textGiaSpDesc);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_desc,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Product product = products.get(position);
        holder.textTenSp.setText(product.getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.textGiaSp.setText(decimalFormat.format(product.gia_sp) + "VND");
        Picasso.with(context).load("http://192.168.56.1/doan-laravel/public/upload/" + product.getAnh())
                .resize(1000,1000)
                .centerCrop()
                .into(holder.imgSanPham);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }
}
