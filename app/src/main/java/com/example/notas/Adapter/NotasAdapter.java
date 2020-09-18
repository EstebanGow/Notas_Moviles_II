package com.example.notas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notas.Models.NotaModel;
import com.example.notas.R;

import java.util.List;

public class NotasAdapter extends BaseAdapter {
    Context context;
    List<NotaModel> datos;
    public NotasAdapter(Context context, List<NotaModel> datos) {
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.view_note_layout,null);
        TextView tit = (TextView) vista.findViewById(R.id.title);
        //TextView cont = (TextView) vista.findViewById(R.id.content);
        TextView num = (TextView) vista.findViewById(R.id.numero);

        tit.setText(datos.get(position).getTitulo());
        //cont.setText(datos.get(position).getContenido());
        num.setText(datos.get(position).getFecha());
        return vista;
    }
}