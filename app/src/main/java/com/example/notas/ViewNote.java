package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.notas.Adapter.NotasAdapter;
import com.example.notas.Database.SqliteHelper;
import com.example.notas.Models.NotaModel;
import com.example.notas.Operations.NotasOperation;

import java.util.ArrayList;
import java.util.List;

public class ViewNote extends AppCompatActivity {
    private ListView list;
    private NotasOperation operations;
    private ImageView volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        list = (ListView)findViewById(R.id.listado);
        volver = (ImageView)findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        operations = new NotasOperation(this);
        final ArrayList<NotaModel> listaNotas = operations.list();
        NotasAdapter MyAdapter = new NotasAdapter(getApplicationContext(),listaNotas);
        list.setAdapter(MyAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sig = new Intent(getApplicationContext(),FullNota.class);
                sig.putExtra("data", listaNotas.get(i));
                startActivity(sig);
            }
        });

    }

    public void Home(){
        Intent sig = new Intent(this,MainActivity.class);
        startActivity(sig);
    }
}