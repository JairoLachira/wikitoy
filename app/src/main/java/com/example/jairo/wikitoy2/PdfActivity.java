package com.example.jairo.wikitoy2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        showToolbar("PDF", true);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("tablas.pdf").enableSwipe(true).swipeHorizontal(true).enableDoubletap(true).
                defaultPage(0).enableAnnotationRendering(false).password(null).scrollHandle(null).enableAntialiasing(true).
                spacing(0).pageFitPolicy(FitPolicy.WIDTH).load();

    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
