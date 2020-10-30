package com.utn.recuperatoriopp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {
    private List<Auto> listaAutos;
    private MainActivity mainActivity;


    public AutoAdapter(List<Auto> listaProductos, MainActivity mainActivity) {

        this.listaAutos = listaProductos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crear la view y el viewHolder y devolverlos
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        AutoViewHolder autoViewHolder = new AutoViewHolder(v, this.mainActivity);

        return autoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoViewHolder holder, int position) {
        //Setear los elementos de la view con los datos del objeto
        Auto auto = listaAutos.get(position); //uso la posición para encontrar el item
        holder.posicion = position;
        //TODO pasar a string los valores
        holder.tvMarca.setText(auto.getMake());
        holder.tvModelo.setText(auto.getModel());

    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }
}