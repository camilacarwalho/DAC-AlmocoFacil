package com.example.almocofacil.services;


import android.app.Activity;

import com.example.almocofacil.threads.ApiRequest;
import com.google.gson.Gson;

public abstract class AcessarRest<T,S> {

    private static String URL_REST_API = "http://10.9.3.2:8080/app/api/";
    //private static String URL_REST_API = "http://192.168.0.108:8080/app/api/";

    private final Activity activity;
    private String path;

    public AcessarRest(Activity activity, String path) {
        this.activity = activity;
        this.path = path;
    }

    public abstract void retorno(final S objeto);

    public void run(final T objeto, final Class<S> classeResposta){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                String json = gson.toJson(objeto);

                try {
                    //reposta em formato string de um json
                    String retorno = ApiRequest.request(json, URL_REST_API + path);
                    //criando representacao simples de aluno apartir de um json em formato string
                    final S resultado = gson.fromJson(retorno, classeResposta);

                    concluido(resultado);

                }catch (Exception e){
                    concluido(null);
                }

            }
        }).start();
    }

    private void concluido(final S  object){

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                retorno(object);
            }
        });

    }

}
