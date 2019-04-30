package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTituloNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTituloNombre = (TextView)findViewById(R.id.tvTituloNombre);
        SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE );
        tvTituloNombre.setText("Hola " + prefs.getString("nombreuser","") + ", ¿Qué deseas hacer?");
    }

    public void iralecciones(View view)
    {
        Intent i=new Intent(this, LeccionesActivity.class);
        startActivity(i);
    }
}
