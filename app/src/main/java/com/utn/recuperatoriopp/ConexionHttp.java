package com.utn.recuperatoriopp;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionHttp {

    public String obtenerRespuesta(String urlString) {
        //A través de una ruta
        try {
            URL url = new URL(urlString); //objeto al cual le vamos a pegar
            //Generar objeto - castear porque devuelve un obj genérico
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //Establecer el metodo a ejecutar
            urlConnection.setRequestMethod("GET");
            //Conectarse
            urlConnection.connect();

            //Evaluar el response code para conexiones http (200)
            if(200 == urlConnection.getResponseCode()) {
                //Recuperar el InputStream - enlace a la conexión
                InputStream is = urlConnection.getInputStream();

                //Recorrer respuesta y guardarla en un objeto auxiliar
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                //leer el input stream y escribir en el baos
                byte[] buffer = new byte[1024];
                int lenght = 0; //para leer lo que
                while((lenght = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, lenght);
                }

                //Cerrar la conexión!
                is.close();

                return baos.toString();
            } else {
                throw new RuntimeException("Error" + urlConnection.getResponseCode());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
