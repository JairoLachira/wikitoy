package com.example.jairo.wikitoy2;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
    MainFragment.OnFragmentInteractionListener,
        DeveloperFragment.OnFragmentInteractionListener
{

    private TextView tvTituloNombre;
    MenuItem inicioItem, tutotialesItem;

    private BottomNavigationView menuItem;
    FragmentTransaction transition = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE );

        menuItem=(BottomNavigationView)findViewById(R.id.menuItem);

        MainFragment inicioFragment = new MainFragment();
        transition =  getSupportFragmentManager().beginTransaction();
        transition.replace(R.id.container, inicioFragment);
        transition.commit();

        menuItem.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.inicioItem:
                        MainFragment inicioFragment = new MainFragment();
                        transition =  getSupportFragmentManager().beginTransaction();
                        transition.replace(R.id.container, inicioFragment);
                        transition.commit();
                        break;
                    case R.id.desarrolladorItem:
                        DeveloperFragment developerFragment =new DeveloperFragment();
                        transition =  getSupportFragmentManager().beginTransaction();
                        transition.replace(R.id.container, developerFragment);
                        transition.commit();
                        break;
                }
                return true;
            }
        });

        showToolbar("Hola " + prefs.getString("nombreuser",""), false);
    }

    public void showToolbar(String title, boolean upButton)
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void iralecciones(View view)
    {
        Intent i=new Intent(this, LeccionesActivity.class);
        startActivity(i);
    }

    public void iraejercicios(View view)
    {
        Intent i=new Intent(this, EjerciciosActivity.class);
        startActivity(i);
    }

    public void iramapas(View view)
    {
        Intent i=new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
