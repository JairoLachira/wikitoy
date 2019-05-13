package com.example.jairo.wikitoy2;

public class YoutubeVideos {
    String videoURL;

    public  YoutubeVideos()
    {

    }

    public  YoutubeVideos(String videoURL)
    {
        this.videoURL = videoURL;
    }



    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
