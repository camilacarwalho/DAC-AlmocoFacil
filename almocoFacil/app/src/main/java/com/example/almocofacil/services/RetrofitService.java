package com.example.almocofacil.services;

import com.example.almocofacil.domain.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("login")
    Call<Usuario> logar(@Field("matricula") String matricula,
                        @Field("senha") String senha);

}
