package com.example.almocofacil.services;

import android.app.Activity;
import android.util.JsonReader;
import android.util.Log;

import com.example.almocofacil.threads.ApiRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class GetRest<T> {

    private URL endPoint;
    private String path;
    private final Activity activity;
    private final Type classResposta;

    public abstract void retorno(final T objeto);


    public GetRest(Activity activity, String path, Type classResposta){
        this.path = path;
        this.classResposta = classResposta;
        this.activity = activity;
    }

    public void get(){
        new Thread(new Runnable(){
            @Override
            public void run() {


                    OkHttpClient httpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(PathRest.URL_REST_API + path)
                            .get()
                            .build();
                    String resposta;
                    try(Response response = httpClient.newCall(request).execute()){
                        resposta = response.body().string();

                        Gson gson = new Gson();
                        final T resultado = gson.fromJson(resposta, classResposta);
                        concluido(resultado);
                    }catch (IOException e){
                        Log.e("Log",e.getMessage());
                    }
            }
        }).start();
    }

    private void concluido(final T resultado) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                retorno(resultado);
            }
        });
    }


}
