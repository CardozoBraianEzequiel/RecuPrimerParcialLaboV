package com.utn.recuperatoriopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private List<Auto> listaAuto;
    private AutoAdapter autoAdapter;
    private Auto auto;
    private int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listaAuto = new ArrayList<Auto>();

        //Generar el handler
        Handler handler = new Handler(this);
        //Ejecutar el hilo
        EjecutarHttp miHilo = new EjecutarHttp(handler);
        //Ejecutar metodo start()
        miHilo.start();

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        //Obtener el mensaje y castear la lista
        List<Auto> lista = (List<Auto>)  msg.obj;
        this.listaAuto = lista;

        //Recuperar el recycler de la View
        RecyclerView recyclerView = findViewById(R.id.recycler);

        //Setear manera de representar la lista
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        //Crear el adapter y pasarle la lista y pasarsela al adapter
        AutoAdapter autoAdapter = new AutoAdapter(listaAuto, this);
        this.autoAdapter = autoAdapter;
        recyclerView.setAdapter(this.autoAdapter);
        return false;
    }

    public void editarAuto(int posicion) {


        //intención de abrir una segunda activity:
        Intent i = new Intent(this, EditarAutoActivity.class);
        //Guardar producto y posicion
        this.auto = this.listaAuto.get(posicion);
        this.posicion = posicion;


        //Pasar datos:
        i.putExtra("make", this.auto.getMake());
        i.putExtra("model", this.auto.getModel());
        i.putExtra("year", this.auto.getYear().intValue());
        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                String make = data.getStringExtra("make");
                Integer year = data.getIntExtra("year", 0);
                String model = data.getStringExtra("model");

                this.auto.setMake(make);
                this.auto.setModel(model);
                this.auto.setYear(year);

                this.autoAdapter.notifyItemChanged(this.posicion);
            }
        }
    }
}