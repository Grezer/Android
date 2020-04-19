package com.example.horoscope2;

import android.graphics.drawable.Drawable;

public class zodiacSign {
    public String dates;
    public String description;
    public Drawable img;

    zodiacSign(String dates, String description, Drawable img){
        this.dates = dates;
        this.description = description;
        this.img = img;
    }
    zodiacSign() {}
}
