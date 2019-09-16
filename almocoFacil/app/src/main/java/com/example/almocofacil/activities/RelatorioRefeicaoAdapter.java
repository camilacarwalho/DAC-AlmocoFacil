package com.example.almocofacil.activities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.serializer.AutorizacaoRRJersey;
import java.util.List;

public class RelatorioRefeicaoAdapter extends BaseAdapter {

    private Context context;
    private List<AutorizacaoRRJersey> lista;

    public RelatorioRefeicaoAdapter(Context context, List<AutorizacaoRRJersey> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        AutorizacaoRRJersey arj = lista.get(i);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.relatorio_refeicao_row, null);

        TextView modelo0 = (TextView) layout.findViewById(R.id.tvData);
        TextView modelo1 = (TextView) layout.findViewById(R.id.tvRefeicao);
        TextView modelo2 = (TextView) layout.findViewById(R.id.tvStatus);
        TextView modelo3 = (TextView) layout.findViewById(R.id.tvQuantidade);

        modelo0.setTextColor(Color.parseColor("#000000"));
        modelo1.setTextColor(Color.parseColor("#000000"));
        modelo2.setTextColor(Color.parseColor("#000000"));
        modelo3.setTextColor(Color.parseColor("#000000"));

        modelo0.setText(arj.getData());
        modelo1.setText(arj.getNome());
        modelo2.setText(arj.getStatusAutorizacao().toString());
        modelo3.setText(arj.getQuantidade().toString());
        return layout;
    }
}
