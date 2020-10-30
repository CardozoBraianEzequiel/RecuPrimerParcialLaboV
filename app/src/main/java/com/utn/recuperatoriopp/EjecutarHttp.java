package com.utn.recuperatoriopp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    public Handler handler;

    public EjecutarHttp(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run(){
        //Poner lo que queremos que se ejecute en paralelo
        ConexionHttp con = new ConexionHttp();
        //Recuperar la respuesta
        String json = con.obtenerRespuesta("http://192.168.0.29:3000/autos");
        //Parsear JSON acá
        //Enviar el mensaje
        Message mensaje = new Message();
        try {
            mensaje.obj = generarListaString(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(mensaje);
    }

    private List<Auto> generarListaString(String json) throws JSONException {
        List<Auto> autos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        //Recorrer el json
        for(int i=0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            //Gaurdar el objeto en el array
            Auto autito = new Auto();
            autito.setId((object.getInt("id")));
            autito.setMake((object.getString("make")));
            autito.setModel((object.getString("model")));
            autito.setYear((object.getInt("year")));
            autos.add(autito);
            Log.d("data",object.getString("make") );
        }
        return autos;
    }
}
