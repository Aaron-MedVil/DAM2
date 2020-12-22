package com.example.a24_recycler_view_fragments_com;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolderProducto> {

    ArrayList<Producto> listProducto;

    /**
     * Constructor de la clase
     * @param listProducto
     */
    public AdaptadorProducto(ArrayList<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    /**
     * Carga el layout personalizado que hemos creado en la vista
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null, false);

        // Añadimos al layout de los elementos las propiedades de ancho y alto
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(lp);

        return new ViewHolderProducto(v);
    }

    /**
     * Metodo que asigna los valores de la clase producto a los objetos del layout
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {

        final Producto producto = listProducto.get(position);
        String nomProd = producto.getNomProducto(), descProd = producto.getDescProducto();
        int imgProd = producto.getImgProducto();

        // Asignamos al layout los valores de los elementos de la lista
        holder.item_recycler_producto.setText(nomProd);
        holder.item_recycler_descripcion.setText(descProd);
        holder.imageViewItemRecycler.setImageResource(imgProd);

        // Creamos un evento click en los elementos de la lista
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creamos una intencion
                Intent intent = new Intent(holder.itemView.getContext(), Detalle_Activity.class);

                // Asignamos a la intencion los datos del elemento que hemos seleccionado
                intent.putExtra("item_producto", (Serializable) producto);

                // Iniciamos la actividad
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    /**
     * Devuelve el tamaño de la lista
     * @return
     */
    @Override
    public int getItemCount() { return listProducto.size(); }

    /**
     * Clase en la que definimos los campos del RecyclerView
     */
    public class ViewHolderProducto extends RecyclerView.ViewHolder {

        TextView item_recycler_producto, item_recycler_descripcion;
        ImageView imageViewItemRecycler;

        /**
         * Constructor de la clase
         * @param itemView
         */
        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);

            item_recycler_producto = itemView.findViewById(R.id.textViewProductoItemRecycler);
            item_recycler_descripcion = itemView.findViewById(R.id.textViewDescripcionItemRecycler);
            imageViewItemRecycler = itemView.findViewById(R.id.imageViewItemRecycler);
        }
    }
}