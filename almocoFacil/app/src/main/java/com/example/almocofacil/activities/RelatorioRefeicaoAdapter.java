package com.example.almocofacil.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.RelatorioRequisicaoDado;

import java.text.SimpleDateFormat;
import java.util.List;

public class RelatorioRefeicaoAdapter extends BaseAdapter {

    List<RelatorioRequisicaoDado> requisicao;

    Activity activity;

    public RelatorioRefeicaoAdapter(List<RelatorioRequisicaoDado> requisicao, Activity activity) {
        this.requisicao = requisicao;
        this.activity = activity;
    }

    @Override public int getCount() {return requisicao.size(); }
    @Override public Object getItem(int i) {return requisicao.get(i);}
    @Override public long getItemId(int i) {return 0;}

    private class ViewHolder{
        TextView data;
        TextView refeicao;
        TextView status;
        TextView quant;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if(view == null){
            view = inflater.inflate(R.layout.relatorio_refeicao_row, null);
            holder = new ViewHolder();
            holder.data = (TextView) view.findViewById(R.id.tvData);
            holder.refeicao = (TextView) view.findViewById(R.id.tvRefeicao);
            holder.status = (TextView) view.findViewById(R.id.tvStatus);
            holder.quant = (TextView) view.findViewById(R.id.tvQuantidade);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        RelatorioRequisicaoDado requisicaoMap = requisicao.get(i);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

        holder.data.setText(sdf.format(requisicaoMap.getData()));
        holder.refeicao.setText(requisicaoMap.getRefeicao().getNome());
        holder.status.setText(requisicaoMap.getStatus().getNome());
        holder.quant.setText(String.valueOf(requisicaoMap.getQuant()));

        return view;
    }
}
