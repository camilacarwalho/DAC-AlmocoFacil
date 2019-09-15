package com.example.almocofacil.persistence;
import android.content.Context;
import android.content.SharedPreferences;

public class AccessManager {
    private final static String TOKEN_FILE = "token_manager";
    private final static String CODE_KEY = "_code_";
    private final static String NAME_KEY = "_name_";
    private final static String TOKN_KEY = "_tokn_";
    private final static String SENH_KEY = "_senh_";
    private final Context ctx;

    public AccessManager(Context ctx){
        this.ctx = ctx;
    }

    public boolean checkToken(){
        SharedPreferences sp = ctx.getSharedPreferences(TOKEN_FILE, Context.MODE_PRIVATE);
        return sp.getString(TOKN_KEY, null) != null;
    }

    public void store(AccessDTO dto){
        if (dto == null) throw new IllegalArgumentException("Mandou nulo");
        SharedPreferences sp = ctx.getSharedPreferences(TOKEN_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(TOKN_KEY, dto.getToken());
        editor.putString(NAME_KEY, dto.getName());
        editor.putInt(CODE_KEY, dto.getCode());
        editor.putString(SENH_KEY,dto.getSenha());

        editor.commit();
    }

    public void remove(){
        SharedPreferences sp = ctx.getSharedPreferences(TOKEN_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(TOKN_KEY);
        editor.remove(NAME_KEY);
        editor.remove(CODE_KEY);
        editor.remove(SENH_KEY);

        editor.commit();
    }

    public AccessDTO get(){
        if (checkToken()) {
            SharedPreferences sp = ctx.getSharedPreferences(TOKEN_FILE, Context.MODE_PRIVATE);
            String t  = sp.getString(TOKN_KEY, null);
            String n  = sp.getString(NAME_KEY, null);
            String s = sp.getString(SENH_KEY, null);
            Integer c = sp.getInt(CODE_KEY, 0);
            AccessDTO dto = new AccessDTO();
            dto.setCode(c);
            dto.setName(n);
            dto.setSenha(s);
            dto.setToken(t);
            return dto;
        }
        return null;
    }}
