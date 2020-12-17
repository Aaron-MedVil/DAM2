package com.example.a24_recycler_view_fragments_com;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolderProducto> {

    @NonNull @Override
    public AdaptadorProducto.ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { return null; }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProducto.ViewHolderProducto holder, int position) {}

    @Override
    public int getItemCount() { return 0; }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
        }
    }
}