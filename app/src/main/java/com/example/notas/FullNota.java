package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notas.Models.NotaModel;

public class FullNota extends AppCompatActivity {
    private NotaModel item;
    private TextView tit, cont, date;
    private ImageView volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_nota);

        item = (NotaModel) getIntent().getSerializableExtra("data");
        tit = (TextView)findViewById(R.id.title);
        cont = (TextView)findViewById(R.id.content);
        date = (TextView)findViewById(R.id.numero);


        tit.setText(item.getTitulo());
        cont.setText(item.getContenido());
        date.setText(item.getFecha());

        volver = (ImageView)findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });
    }

    public void Home(){
        Intent sig = new Intent(this,MainActivity.class);
        startActivity(sig);
    }
}