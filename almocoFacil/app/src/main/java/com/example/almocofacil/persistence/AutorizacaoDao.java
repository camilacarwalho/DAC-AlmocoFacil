package com.example.almocofacil.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.almocofacil.domain.Aluno;
import com.example.almocofacil.domain.Autorizacao;
import com.example.almocofacil.domain.Refeicao;
import com.example.almocofacil.domain.Requisicao;
import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutorizacaoDao {
    private final String TABLE_AUTORIZACAO = "AUTORIZACAO";
    private DbGateway gw;

    public AutorizacaoDao(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(Autorizacao autorizacao){
        try{
            ContentValues values = new ContentValues();
            values.put("ALUNONOME", autorizacao.getNomeAluno());
            values.put("ALUNOMATRICULA", autorizacao.getMatriculaAluno());
            values.put("DATA", autorizacao.getData().toString());
            values.put("STATUSAUTORIZACAO", autorizacao.getStatusAutorizacao().getNome());
            values.put("REQUISICAOID", autorizacao.getRequisicaoId());
            values.put("REFEICAOID", autorizacao.getRefeicaoId());
            values.put("REFEICAONOME", autorizacao.getRefeicaoNome());
            return gw.getDatabase().insertOrThrow(TABLE_AUTORIZACAO, null, values) > 0;
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id){
        return gw.getDatabase().delete(TABLE_AUTORIZACAO, "ID=?", new String[]{ id + "" }) > 0;
    }


    public List<Autorizacao>listar(){
        List<Autorizacao> autorizacoes = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM AUTORIZACAO", null);

        while(cursor.moveToNext()){

            String status = cursor.getString(5);
            StatusAutorizacao statusAutorizacao = StatusAutorizacao.valueOf(status);

            Autorizacao autorizacao = new Autorizacao();
            autorizacao.setAutorizacaoId(cursor.getInt(0));
            autorizacao.setNomeAluno(cursor.getString(1));
            autorizacao.setMatriculaAluno(cursor.getString(2));

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                autorizacao.setData(format.parse(cursor.getString(3)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            autorizacao.setRefeicaoNome(cursor.getString(4));
            autorizacao.setStatusAutorizacao(statusAutorizacao);
            autorizacao.setRequisicaoId(cursor.getInt(6));
            autorizacao.setRefeicaoId(cursor.getInt(7));

            autorizacoes.add(autorizacao);
        }
        cursor.close();
        return autorizacoes;
    }
}
