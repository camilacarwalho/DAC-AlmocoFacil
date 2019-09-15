package com.example.almocofacil.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Autorizacao;
import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListAutorizacaoAdapter extends BaseAdapter {

    private class ViewHolder{
        TextView tvMatricula;
        TextView tvNome;
        CheckBox cbComparece;
        TextView tvStatus;
    }

    private List<Autorizacao> autorizacoes;
    Activity activity;

    public ListAutorizacaoAdapter(List<Autorizacao> autorizacoes, Activity activity) {
        this.autorizacoes = autorizacoes;
        this.activity = activity;
    }

    @Override
    public int getCount() {return autorizacoes.size();}

    @Override
    public Object getItem(int i) {return autorizacoes.get(i);}

    @Override
    public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(view == null){
            view = inflater.inflate(R.layout.autorizacao_row, null);
            holder = new ViewHolder();
            holder.tvMatricula = (TextView) view.findViewById(R.id.tvListAutMatricula);
            holder.tvNome = (TextView) view.findViewById(R.id.tvListAutNome);
            holder.cbComparece = (CheckBox) view.findViewById(R.id.cbCompareceu);
            holder.tvStatus = (TextView) view.findViewById(R.id.tvListAutStatus);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Autorizacao autorizacao = autorizacoes.get(i);
        holder.tvNome.setText(autorizacao.getNomeAluno());
        holder.tvMatricula.setText(autorizacao.getMatriculaAluno());
        holder.cbComparece.setVisibility(View.INVISIBLE);
        holder.tvStatus.setText(autorizacao.getStatusAutorizacao().getNome());
        holder.tvStatus.setVisibility(View.VISIBLE);

        if(!autorizacao.isConcluida()){
            holder.cbComparece.setVisibility(View.VISIBLE);
            holder.tvStatus.setVisibility(View.INVISIBLE);
        }

        holder.cbComparece.setChecked(
                autorizacao.getStatusAutorizacao() == StatusAutorizacao.REALIZADA
        );
        return view;
    }
}
