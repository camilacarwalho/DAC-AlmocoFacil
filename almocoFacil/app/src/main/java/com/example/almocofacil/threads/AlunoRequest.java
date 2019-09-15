package com.example.almocofacil.threads;

import android.os.AsyncTask;

import com.example.almocofacil.domain.serializer.AlunoSerializer;
import com.google.gson.Gson;

public class AlunoRequest implements Runnable {

    private AlunoSerializer alunoSerializer;

    public AlunoRequest(AlunoSerializer alunoSerializer) {
        this.alunoSerializer = alunoSerializer;
    }

    private AlunoSerializer doInBackground() {

        //criando json para enviar na requisicao
        Gson gson = new Gson();
        String json = gson.toJson(alunoSerializer);

        String object = ApiRequest.request(json, "http://10.0.3.2:8080/app/api/alunos");
        //String object = ApiRequest.request(json, "http://192.168.0.108:8080/app/api/alunos");

        //criando representacao simples de aluno apartir de um json em formato string
        AlunoSerializer alunoSerializer = gson.fromJson(object, AlunoSerializer.class);
        return alunoSerializer;
    }

    //imprimindo o objeto recebido pela requisição
    @Override
    public void run() {
        System.out.println(doInBackground());
    }
}
