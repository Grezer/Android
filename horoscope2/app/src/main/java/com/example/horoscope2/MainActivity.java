package com.example.horoscope2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    zodiacSign selectedSign;
    CalendarView calendarV;
    TextView textV;
    ImageView imageV;
    Button buttonV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarV = findViewById(R.id.calendarView);
        textV = findViewById(R.id.textView);
        imageV = findViewById(R.id.imageView);
        buttonV = findViewById(R.id.button);

        calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedSign = getSign(month + 1, dayOfMonth);
                textV.setText(selectedSign.dates);
                imageV.setImageDrawable(selectedSign.img);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("dates", selectedSign.dates);
        intent.putExtra("description", selectedSign.description);
        startActivity(intent);
    }

    public zodiacSign getSign(int month, int dayOfMonth) {
        if ((month == 1 && dayOfMonth >=21) || (month == 2 && dayOfMonth <=19))
            return new zodiacSign(getResources().getString(R.string.aquarius), getResources().getString(R.string.description_aquarius), getResources().getDrawable(R.drawable.aquarius));

        if ((month == 3 && dayOfMonth >=21) || (month == 4 && dayOfMonth <=20))
            return new zodiacSign(getResources().getString(R.string.aries), getResources().getString(R.string.description_aries), getResources().getDrawable(R.drawable.aries));

        if ((month == 6 && dayOfMonth >=22) || (month == 7 && dayOfMonth <=22))
            return new zodiacSign(getResources().getString(R.string.cancer), getResources().getString(R.string.description_cancer), getResources().getDrawable(R.drawable.cancer));

        if ((month == 12 && dayOfMonth >=23) || (month == 1 && dayOfMonth <=20))
            return new zodiacSign(getResources().getString(R.string.capricorn), getResources().getString(R.string.description_capricorn), getResources().getDrawable(R.drawable.capricorn));

        if ((month == 5 && dayOfMonth >=22) || (month == 6 && dayOfMonth <=21))
            return new zodiacSign(getResources().getString(R.string.gemini), getResources().getString(R.string.description_gemini), getResources().getDrawable(R.drawable.gemini));

        if ((month == 7 && dayOfMonth >=23) || (month == 8 && dayOfMonth <=21))
            return new zodiacSign(getResources().getString(R.string.leo), getResources().getString(R.string.description_leo), getResources().getDrawable(R.drawable.leo));

        if ((month == 9 && dayOfMonth >=24) || (month == 10 && dayOfMonth <=23))
            return new zodiacSign(getResources().getString(R.string.libra), getResources().getString(R.string.description_libra), getResources().getDrawable(R.drawable.libra));

        if ((month == 2 && dayOfMonth >=20) || (month == 3 && dayOfMonth <=20))
            return new zodiacSign(getResources().getString(R.string.pisces), getResources().getString(R.string.description_pisces), getResources().getDrawable(R.drawable.pisces));

        if ((month == 11 && dayOfMonth >=23) || (month == 12 && dayOfMonth <=22))
            return new zodiacSign(getResources().getString(R.string.sagittarius), getResources().getString(R.string.description_sagittarius), getResources().getDrawable(R.drawable.sagittarius));

        if ((month == 10 && dayOfMonth >=24) || (month == 11 && dayOfMonth <=22))
            return new zodiacSign(getResources().getString(R.string.scorpion), getResources().getString(R.string.description_scorpion), getResources().getDrawable(R.drawable.scorpion));

        if ((month == 4 && dayOfMonth >=21) || (month == 5 && dayOfMonth <=21))
            return new zodiacSign(getResources().getString(R.string.taurus), getResources().getString(R.string.description_taurus), getResources().getDrawable(R.drawable.taurus));

        if ((month == 8 && dayOfMonth >=22) || (month == 9 && dayOfMonth <=23))
            return new zodiacSign(getResources().getString(R.string.virgo), getResources().getString(R.string.description_virgo), getResources().getDrawable(R.drawable.virgo));
        return null;
    }
}
