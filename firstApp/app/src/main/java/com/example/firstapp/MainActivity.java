package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeeer(View view) {
        TextView brands = findViewById(R.id.textViewBeer);
        Spinner colorSpinner = findViewById(R.id.spinnerColor);
        String beerType = String.valueOf(colorSpinner.getSelectedItem());
        List<String> brandList;
        brandList = new BeerExpert().getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandList)
            brandsFormatted.append(brand).append('\n');
        brands.setText(brandsFormatted);
    }
}
