package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Datos_ChildActivity extends AppCompatActivity  {

    private EditText etNombre;
    private List<slider> lstSlider;
    private ViewPager sliderPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__child);
        etNombre = (EditText)findViewById(R.id.etNombre);
        sliderPager = (ViewPager)findViewById(R.id.slider_page);

        lstSlider = new ArrayList<>();
        lstSlider.add(new slider(R.mipmap.slider1,"Aprende con wititoy"));
        lstSlider.add(new slider(R.mipmap.slider2,"Entrena tu cerebro"));
        lstSlider.add(new slider(R.mipmap.slider3,"Sé el primero en clase"));

        SliderPageAdapter adapter = new SliderPageAdapter(this, lstSlider);
        sliderPager.setAdapter(adapter);

        //Inicio de Timer
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new Datos_ChildActivity.SliderTimer(),4000,6000);
    }

    //clase para la transicion de slider
    class SliderTimer extends TimerTask {
        //code-implmentation
        @Override
        public void run() {
            Datos_ChildActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem()<lstSlider.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }else{
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void continuar(View view)
    {
        String nombreUser = etNombre.getText().toString();

        if(nombreUser.trim().length()>0)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nombreuser",nombreUser);
            editor.commit();
        }
        else
        {
            Toast.makeText(this, "Escriba su nombe",    Toast.LENGTH_LONG).show();
        }
    }
}
