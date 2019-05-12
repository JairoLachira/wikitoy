package com.example.jairo.wikitoy2;

public class slider {
    private int Image;
    private String Title;

    public  slider(int imagen, String title) {
        Image = imagen;
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
