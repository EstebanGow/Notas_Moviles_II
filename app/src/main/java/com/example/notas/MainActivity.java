package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
 private LinearLayout Add, ViewNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Add = (LinearLayout) findViewById(R.id.agregar);
        ViewNote = (LinearLayout) findViewById(R.id.viewNotes);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddActivity();
            }
        });

        ViewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewActivity();
            }
        });
    }

    public void AddActivity(){
        Intent sig = new Intent(this,AddNote.class);
        startActivity(sig);
    }

    public void ViewActivity(){
        Intent sig = new Intent(this,ViewNote.class);
        startActivity(sig);
    }


}