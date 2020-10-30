package com.utn.recuperatoriopp;

import android.view.View;

public class EditarClick implements View.OnClickListener{
    EditarAutoActivity editarAutoActivity;

    public EditarClick(EditarAutoActivity editarAutoActivity) {
        this.editarAutoActivity = editarAutoActivity;
    }

    @Override
    public void onClick(View v) {

        this.editarAutoActivity.enviarDatos();

    }
}
