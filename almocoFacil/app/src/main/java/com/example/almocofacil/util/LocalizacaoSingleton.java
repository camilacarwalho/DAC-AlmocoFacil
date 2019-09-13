package com.example.almocofacil.util;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalizacaoSingleton {

    private static SharedPreferences prefs;

    private LocalizacaoSingleton(){

    }

    public static synchronized SharedPreferences getInstance(Context context){
        if(prefs == null) {
            prefs = context.getSharedPreferences("para-localizacao",Context.MODE_PRIVATE);
        }
        return prefs;
    }
}
