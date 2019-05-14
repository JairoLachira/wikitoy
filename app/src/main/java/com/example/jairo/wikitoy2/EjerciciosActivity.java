package com.example.jairo.wikitoy2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EjerciciosActivity extends AppCompatActivity {

    private EditText etr1,etr2,etr3, etr4, etr5, etr6;
    private Button btnop1, btnop2, btnop3, btnop4, btnop5, btnop6;
    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        showToolbar("Ejercicios", true);
        etr1 = (EditText)findViewById(R.id.etresultado1);
        etr2 = (EditText)findViewById(R.id.etresultado2);
        etr3 = (EditText)findViewById(R.id.etresultado3);
        etr4 = (EditText)findViewById(R.id.etresultado4);
        etr5 = (EditText)findViewById(R.id.etresultado5);
        etr6 = (EditText)findViewById(R.id.etresultado6);

        btnop1 = (Button)findViewById(R.id.btnop1);
        btnop2 = (Button)findViewById(R.id.btnop2);
        btnop3 = (Button)findViewById(R.id.btnop3);
        btnop4 = (Button)findViewById(R.id.btnop4);
        btnop5 = (Button)findViewById(R.id.btnop5);
        btnop6 = (Button)findViewById(R.id.btnop6);

        mp = new MediaPlayer();

    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public Boolean comprobar1(View view)
    {
        return  (etr1.getText().toString().equals("13")) ? iscorrect(btnop1, etr1, etr2) : isincorrect(btnop1, etr1, etr2);
    }
    public Boolean comprobar2(View view)
    {
        return  (etr2.getText().toString().equals("10")) ? iscorrect(btnop2, etr2, etr3) : isincorrect(btnop2, etr2, etr3);
    }
    public Boolean comprobar3(View view)
    {
        return  (etr3.getText().toString().equals("42")) ? iscorrect(btnop3, etr3, etr4) : isincorrect(btnop3, etr3, etr4);
    }
    public Boolean comprobar4(View view) {
        return  (etr4.getText().toString().equals("40")) ? iscorrect(btnop4, etr4, etr5) : isincorrect(btnop4, etr4, etr5);
    }

    public Boolean comprobar5(View view) {
        return  (etr5.getText().toString().equals("41")) ? iscorrect(btnop5, etr5, etr6) : isincorrect(btnop5, etr5, etr6);
    }

    public Boolean comprobar6(View view) {
        return  (etr6.getText().toString().equals("48")) ? iscorrect(btnop6, etr6, etr6) : isincorrect(btnop6, etr6, etr6);
    }

    public void verestadisticas(View view)
    {
        Intent i=new Intent(this, EstadisticasActivity.class);
        startActivity(i);
    }

    Boolean iscorrect(Button btn, EditText etactual, EditText etnext)
    {
        mp.stop();
        mp = MediaPlayer.create(this,R.raw.sound_correct);
        mp.start();

        btn.setText("✓");
        btn.setEnabled(false);
        btn.setBackgroundResource(R.drawable.boton_correcto);
        etactual.setFocusable(false);
        etnext.requestFocus();

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT correctas FROM operaciones WHERE nombre='suma'", null);
        int n_correctas = 0;

        if (fila.moveToFirst()){
           n_correctas = Integer.parseInt(fila.getString(0));
        }

        ContentValues registro_content = new ContentValues();
        registro_content.put("correctas",n_correctas+1);
        int update = bd.update("operaciones",registro_content,"nombre='suma'",null);

        bd.close();
        if(update==1) {
           // Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    Boolean isincorrect(Button btn,EditText etactual, EditText etnext)
    {
        mp.stop();
        mp = MediaPlayer.create(this,R.raw.sound_incorrect);
        mp.start();

        btn.setText("×");
        btn.setEnabled(false);
        btn.setBackgroundResource(R.drawable.boton_incorrecto);
        etactual.setFocusable(false);
        etnext.requestFocus();

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT incorrectas FROM operaciones WHERE nombre='suma'", null);
        int n_incorrectas = 0;

        if (fila.moveToFirst()){
            n_incorrectas = Integer.parseInt(fila.getString(0));
        }

        ContentValues registro_content = new ContentValues();
        registro_content.put("incorrectas",n_incorrectas+1);
        int update = bd.update("operaciones",registro_content,"nombre='suma'",null);

        bd.close();
        if(update==1) {
           // Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();
        }

        return false;
    }



}
