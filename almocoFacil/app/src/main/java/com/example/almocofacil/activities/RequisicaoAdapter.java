package com.example.almocofacil.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.almocofacil.R;
import com.example.almocofacil.domain.Requisicao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RequisicaoAdapter extends BaseAdapter {

    List<Requisicao> requisicoes;
    Activity activity;

    private class ViewHolder{
        TextView dataInicio;
        TextView dataFinal;
        TextView refeicao;
        TextView status;
    }

    public RequisicaoAdapter(List<Requisicao> requisicoes, Activity activity) {
        this.requisicoes = requisicoes;
        this.activity = activity;
    }

    @Override public int getCount() {return requisicoes.size();}
    @Override public Object getItem(int i) {return requisicoes.get(i);}
    @Override public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        LayoutInflater inflater = activity.getLayoutInflater();

        if (view == null){
            view = inflater.inflate(R.layout.requisicao_row, null);
            holder = new ViewHolder();
            holder.dataInicio = view.findViewById(R.id.tvDataInicio);
            holder.dataFinal = view.findViewById(R.id.tvDataFinal);
            holder.refeicao = view.findViewById(R.id.tvRefeicao);
            holder.status = view.findViewById(R.id.tvSatus);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Requisicao requisicao = requisicoes.get(i);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

        Calendar cal = Calendar.getInstance();
        cal.setTime(requisicao.getDataInicio());
        cal.add(Calendar.DAY_OF_MONTH,1);
        holder.dataInicio.setText(sdf.format(cal.getTime()));

        cal.setTime(requisicao.getDataFinal());
        cal.add(Calendar.DAY_OF_MONTH,1);
        holder.dataFinal.setText(sdf.format(cal.getTime()));
        holder.refeicao.setText(requisicao.getRefeicaoNome());
        holder.status.setText(requisicao.getStatus().getNome());

        return view;
    }
}
