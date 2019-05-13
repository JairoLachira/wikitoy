package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class LeccionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecciones);
        showToolbar("Lecciones", true);
    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void iratablasdesuma(View view) {
        seguntipo("Suma");
    }

    public void iratablasderesta(View view) {
        seguntipo("Resta");
    }

    public void iratablasdemulti(View view) {
        seguntipo("Multiplicación");
    }

    public void iratablasdedivi(View view) {
        seguntipo("División");
    }

    void seguntipo(String tipo)
    {
        Intent i=new Intent(this, TablasActivity.class);
        i.putExtra("tabla", tipo);
        startActivity(i);
    }

    public void irapdf(View view) {
        Intent i=new Intent(this, PdfActivity.class);
        startActivity(i);
    }

    public void iratutoriales(View view) {
        Intent i=new Intent(this, TutorialesActivity.class);
        startActivity(i);
    }
}
