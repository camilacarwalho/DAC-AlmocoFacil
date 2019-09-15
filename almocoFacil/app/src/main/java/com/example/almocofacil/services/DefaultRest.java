package com.example.almocofacil.services;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class DefaultRest<T> {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private String path;
    private final Activity activity;
    private final Type classResposta;

    public abstract void resposta(final T objeto);

    public abstract Request solicitar(String url, RequestBody body);

    public DefaultRest(Activity activity, String path, Type classResposta){
        this.path = path;
        this.classResposta = classResposta;
        this.activity = activity;
    }

    protected void run(final Object object){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .create();
                RequestBody body = null;
                if (object != null){
                    String json = gson.toJson(object);
                    body = RequestBody.create(json, JSON);
                }
                Request request = solicitar(path, body);
                OkHttpClient httpClient = new OkHttpClient();
                try(Response response = httpClient.newCall(request).execute()){
                    String resp = response.body().string();
                    if (response.code() == 200){
                        final  T resultado = gson.fromJson(resp, classResposta);
                        concluido(resultado);
                    } else {
                        concluido(null);
                    }
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
                resposta(resultado);
            }
        });
    }



}
