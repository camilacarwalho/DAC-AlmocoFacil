package com.example.almocofacil.services;

import android.app.Activity;

import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class AcessoRest<T> {

    protected static final String URL_REST_API = "http://10.0.3.2:8080/app/api/";
    //protected static final String URL_REST_API = "http://192.168.0.108:8080/app/api/";

    private String path;
    private final Activity activity;
    private final Type classResposta;

    public abstract void retorno(final T objeto);

    public AcessoRest(Activity activity, String path, Type classResposta){
        this.path = path;
        this.classResposta = classResposta;
        this.activity = activity;
    }

    public void get(){
        new DefaultRest<T>(activity,URL_REST_API + path, classResposta){
            @Override public void resposta(T objeto) { retorno(objeto);}

            @Override
            public Request solicitar(String url, RequestBody body) {
                return new Request.Builder()
                        .url(url)
                        .get()
                        .build();
            }
        }.run(null);
    }

    public void put(final Object object){
        new DefaultRest<T>(activity,URL_REST_API + path, classResposta){
            @Override public void resposta(T objeto) { retorno(objeto);}

            @Override
            public Request solicitar(String url, RequestBody body) {
                return new Request.Builder()
                        .url(url)
                        .put(body)
                        .build();
            }
        }.run(object);
    }

    public void post(final Object object){
        new DefaultRest<T>(activity,URL_REST_API + path, classResposta){
            @Override public void resposta(T objeto) { retorno(objeto);}

            @Override
            public Request solicitar(String url, RequestBody body) {
                return new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
            }
        }.run(object);
    }


}
