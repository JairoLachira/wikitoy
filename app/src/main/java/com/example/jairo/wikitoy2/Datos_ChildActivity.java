package com.example.jairo.wikitoy2;


import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Datos_ChildActivity extends AppCompatActivity {

    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__child);
        etNombre = (EditText)findViewById(R.id.etNombre);
    }

    public void continuar(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

        String nombreUser = etNombre.getText().toString();

        SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombreuser",nombreUser);
        editor.commit();
    }
}
