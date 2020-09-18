package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notas.Models.NotaModel;
import com.example.notas.Operations.NotasOperation;

import java.text.SimpleDateFormat;

public class AddNote extends AppCompatActivity {
    private TextView tit, cont;
    private Button add;
    private NotaModel model;
    private NotasOperation operations;
    private   String dateString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        dateString = sdf.format(date);


        tit = (TextView)findViewById(R.id.title);
        cont = (TextView)findViewById(R.id.content);
        operations = new NotasOperation(this);
        add = (Button)findViewById(R.id.guardar);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guardar();
            }
        });

    }

    public void Guardar(){
        model = new NotaModel(tit.getText().toString(), cont.getText().toString(),dateString);
        int resp = operations.insert(model);
        if(resp > 0){
            Toast.makeText(this, "Nota guardada correctamente", Toast.LENGTH_LONG).show();
            Intent sig = new Intent(this,MainActivity.class);
            startActivity(sig);
        }else{
            Toast.makeText(this, "No se guardó la nota", Toast.LENGTH_LONG).show();
        }
    }
}