package com.example.jairo.wikitoy2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.Vector;

public class TutorialesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos=new Vector<YoutubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoriales);
try
{
    showToolbar("Tutoriales", true);

    recyclerView = (RecyclerView)findViewById(R.id.recyclerYoutube);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2Iy92z6WOqI\" frameborder=\"0\" allowfullscreen></iframe>"));
    youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lgPs3UxM2kU\" frameborder=\"0\" allowfullscreen></iframe>"));
    youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M6JJqkPWozY\" frameborder=\"0\" allowfullscreen></iframe>"));
    youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EM00QdtLDOY\" frameborder=\"0\" allowfullscreen></iframe>"));

    VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
    recyclerView.setAdapter(videoAdapter);
}
catch (Exception e)
{
    Toast.makeText(this,"tutorial acti" + e.toString(),Toast.LENGTH_LONG).show();
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
