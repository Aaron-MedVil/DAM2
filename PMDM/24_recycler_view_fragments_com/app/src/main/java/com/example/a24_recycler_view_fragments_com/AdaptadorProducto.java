package com.example.a24_recycler_view_fragments_com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolderProducto> {

    ArrayList<Producto> listProducto;

    /**
     * Carga el layout personalizado que hemos creado en la vista
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null, false);
        return new ViewHolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {

        final Producto producto = listProducto.get(position);
        String nomProd = producto.getNomProducto(), descProd = producto.getDescProducto();
        int imgProd = producto.getImgProducto();
    }

    @Override
    public int getItemCount() { return listProducto.size(); }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
        }
    }
}