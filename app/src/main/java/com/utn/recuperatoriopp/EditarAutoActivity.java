package com.utn.recuperatoriopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

public class EditarAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_auto);


        //recupero el action bar para hacer visible el botón back
        ActionBar actionBar = super.getSupportActionBar(); //Es el menú
        actionBar.setDisplayHomeAsUpEnabled(true); //muestro el botón de back

        //Cargar datos y Vista
        Bundle bundle = super.getIntent().getExtras();
        Auto auto = new Auto();
        auto.setMake(bundle.getString("make"));
        auto.setYear(bundle.getInt("year"));
        auto.setModel(bundle.getString("model"));

        AutoView autoView = new AutoView(this, auto);
        autoView.cargarPantalla();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void enviarDatos() {

        //Recuperar elementos
        EditText edMake = findViewById(R.id.edMarca);
        EditText edModel = findViewById(R.id.edModelo);
        Spinner spYear = (Spinner)findViewById(R.id.spAnio);
        String year = spYear.getSelectedItem().toString();


        Intent intent = new Intent();
        intent.putExtra("make", edMake.getText().toString());
        intent.putExtra("year", Integer.parseInt(year));
        intent.putExtra("model", edModel.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}