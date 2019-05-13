package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListTablaActivity extends AppCompatActivity {

    private ListView lsTabla;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_tabla);

            lsTabla = (ListView)findViewById(R.id.list_tabla);
            Bundle bundle = getIntent().getExtras();
            String tipo_tabla = bundle.getString("tabla");
            int tabla = Integer.parseInt(bundle.getString("numeroTabla"));

            List<String> operaciones = new ArrayList<String>();
            String operacion = "";

            switch (tipo_tabla.toLowerCase())
            {
                case "suma": for (int i=0;i<13;i++) { operacion = tabla + " + " + i + " = " + (tabla + i); operaciones.add(operacion); }break;
                case "resta": for (int i=12;i<25;i++) { operacion = i + " - " + tabla + " = " + (i - tabla); operaciones.add(operacion); }break;
                case "multiplicación": for (int i=0;i<13;i++) { operacion = tabla + " × " + i + " = " + (tabla * i); operaciones.add(operacion); }break;
                case "división": for (int i=12;i<145;i+=12) { operacion = i + " ÷ " + tabla + " = " + i / tabla; operaciones.add(operacion); }break;
            }

            lsTabla.setAdapter(new ArrayAdapter<String>(this, R.layout.text_list_view, operaciones));
            showToolbar("Tabla del " + tabla, false);
        }
        catch(Exception e)
        {
            Toast.makeText(this,"on create list tabla" + e.toString(),Toast.LENGTH_LONG).show();
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
