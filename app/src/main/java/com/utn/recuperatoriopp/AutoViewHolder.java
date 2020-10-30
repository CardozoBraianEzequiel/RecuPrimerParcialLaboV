package com.utn.recuperatoriopp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvMarca;
    public TextView tvModelo;
    public MainActivity mainActivity;
    public int posicion;

    public AutoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);
        //TextViews
        this.tvMarca = itemView.findViewById(R.id.tvMarca);
        this.tvModelo = itemView.findViewById(R.id.tvModelo);
        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.editarAuto(this.posicion);
    }
}
