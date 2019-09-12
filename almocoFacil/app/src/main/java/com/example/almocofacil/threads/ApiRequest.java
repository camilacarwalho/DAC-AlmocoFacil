package com.example.almocofacil.threads;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


//classe generica para requisicao a api do servidor usando json como comunicação
public class ApiRequest implements Runnable {

    //retorna objeto json em formato string
    public static String request(String json, String url) {

        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    @Override
    public void run() {

    }
}
