package com.example.almocofacil.firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.almocofacil.threads.ApiRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.gson.Gson;

public class Notificacao {

    private static final String TAG = "MainActivity";
    private static  Context context;
    private static SharedPreferences sharedPref;

    public Notificacao(Context context){
        this.context = context;
        this.sharedPref = this.context.getSharedPreferences("para-token",Context.MODE_PRIVATE);
        registraToken();
    }

    private void registraToken(){

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        System.out.print(token);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("token", token);
                        editor.commit();
                    }
                });

    }

    public void registraTokenNoServidor(){

        new Thread() {

            @Override
            public void run() {

                String token = sharedPref.getString("token" ,null);

                System.out.println(token);

                Gson gson = new Gson();
                String json = gson.toJson(token);

                String object = ApiRequest.request(json, "http://10.0.3.2:8080/app/api/tokenNotificacao");
                //String object = ApiRequest.request(json, "http://192.168.0.108:8080/app/api/tokenNotificacao");
            }


        }.start();
    }

}
