package com.example.almocofacil.activities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListAlunoAdapter extends BaseAdapter {
    // TODO: Recebe uma lista de alunos
    public List<Aluno> alunoList;

    Activity activity;

    public ListAlunoAdapter(List<Aluno> list, Activity activity) {
        super();
        this.alunoList = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunoList.size();
    }

    @Override
    public Object getItem(int position) {
        return alunoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();

        if (view == null)
        {
            view = inflater.inflate(R.layout.listaluno_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) view.findViewById(R.id.textMatricula);
            holder.txtSecond = (TextView) view.findViewById(R.id.textNome);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        Aluno mapA = alunoList.get(position);
        holder.txtFirst.setText(mapA.getMatricula());
        holder.txtSecond.setText(mapA.getNome());

        return view;
    }
}
