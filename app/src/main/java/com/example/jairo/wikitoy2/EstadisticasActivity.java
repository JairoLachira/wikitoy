package com.example.jairo.wikitoy2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EstadisticasActivity extends AppCompatActivity {

    private TextView tvcsuma, tvisuma, tvcresta, tviresta, tvcmulti, tvimulti, tvcdivi, tvidivi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        showToolbar("Estadísticas", false);

        tvcsuma = (TextView)findViewById(R.id.tvcorrectassuma);
        tvisuma = (TextView)findViewById(R.id.tvincorrectassuma);
        tvcresta = (TextView)findViewById(R.id.tvcorrectasresta);
        tviresta = (TextView)findViewById(R.id.tvincorrectasresta);
        tvcmulti = (TextView)findViewById(R.id.tvcorrectasmulti);
        tvimulti = (TextView)findViewById(R.id.tvincorrectasmulti);
        tvcdivi = (TextView)findViewById(R.id.tvcorrectasdivi);
        tvidivi = (TextView)findViewById(R.id.tvincorrectasdivi);

        buscardatosSuma();

    }

    public void iniciarTablas()
    {
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro_content = new ContentValues();
        registro_content.put("nombre","suma");
        registro_content.put("correctas",5);
        registro_content.put("incorrectas",7);

        bd.insert("operaciones",null,registro_content);
        bd.close();
        Toast.makeText(this, "Datos de suma insertados",Toast.LENGTH_SHORT).show();
    }

    public void buscardatosSuma()
    {
        try
        {
            AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            Cursor fila = bd.rawQuery("SELECT nombre, correctas, incorrectas FROM operaciones", null);
            ArrayList<String> registros=new ArrayList<String>();

            while (fila.moveToNext()){
                registros.add(fila.getString(1));
                registros.add(fila.getString(2));
            }

            tvcsuma.setText(registros.get(0) + " Correctas");
            tvisuma.setText(registros.get(1) + " Incorrectas");
            tvcresta.setText(registros.get(2) + " Correctas");
            tviresta.setText(registros.get(3) + " Incorrectas");
            tvcmulti.setText(registros.get(4) + " Correctas");
            tvimulti.setText(registros.get(5) + " Incorrectas");
            tvcdivi.setText(registros.get(6) + " Correctas");
            tvidivi.setText(registros.get(7) + " Incorrectas");

            bd.close();
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
