package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class TablasActivity extends AppCompatActivity {

    public  String titulo_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas);
        Bundle bundle = getIntent().getExtras();
        titulo_toolbar = bundle.getString("tabla");
        showToolbar(titulo_toolbar, true);
    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void irTabla1(View view) {
        enviar_segun_tabla("1");
    }

    public void irTabla2(View view) {
        enviar_segun_tabla("2");
    }

    public void irTabla3(View view) {
        enviar_segun_tabla("3");
    }

    public void irTabla4(View view) {
        enviar_segun_tabla("4");
    }

    public void irTabla5(View view) {
        enviar_segun_tabla("5");
    }

    public void irTabla6(View view) {
        enviar_segun_tabla("6");
    }

    public void irTabla7(View view) {
        enviar_segun_tabla("7");
    }

    public void irTabla8(View view) {
        enviar_segun_tabla("8");
    }

    public void irTabla9(View view) {
        enviar_segun_tabla("9");
    }

    public void irTabla10(View view) {
        enviar_segun_tabla("10");
    }

    public void irTabla11(View view) {
        enviar_segun_tabla("11");
    }

    public void irTabla12(View view) {
        enviar_segun_tabla("12");
    }

    void enviar_segun_tabla(String numero_tabla)
    {
        Intent i=new Intent(this, ListTablaActivity.class);
        i.putExtra("tabla", titulo_toolbar);
        i.putExtra("numeroTabla", numero_tabla);
        startActivity(i);
    }
}
