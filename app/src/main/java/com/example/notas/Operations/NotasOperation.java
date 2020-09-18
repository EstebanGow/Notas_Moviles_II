package com.example.notas.Operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notas.Database.SqliteHelper;
import com.example.notas.Models.NotaModel;

import java.util.ArrayList;

public class NotasOperation {
    private String DBNAME = "notas.db";
    private int VERSION = 1;
    public final Context context;
    private SQLiteDatabase database;
    private SqliteHelper helper;
    private NotaModel model;


    public NotasOperation(Context context) {
        this.context = context;
        helper = new SqliteHelper(context, DBNAME, null,VERSION);
    }

    protected void openRead(){
        database = helper.getReadableDatabase();
    }

    protected void openWrite(){
        database = helper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public int insert(NotaModel model){

        ContentValues content = new ContentValues();
        content.put("titulo", model.getTitulo());
        content.put("contenido",model.getContenido());
        content.put("fecha",model.getFecha());
        openWrite();
        long id = database.insert("nota",null,content);
        close();
        return (int)id;
    }

   public ArrayList<NotaModel> list(){
        ArrayList<NotaModel> lista = new ArrayList<>();
        openRead();
       Cursor cursor = database.rawQuery("SELECT * FROM nota", null);
       if(cursor.moveToFirst()){
           do{
               lista.add(new NotaModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
           }while (cursor.moveToNext());
       }
        close();
        return lista;
    }
}
