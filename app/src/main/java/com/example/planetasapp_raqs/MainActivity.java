package com.example.planetasapp_raqs;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPlanets;
    private TextView textViewInfo;
    private ImageView imageViewPlanet;

    private String[] planetNames;
    private int[] planetImages = {
            R.drawable.mercurio,
            R.drawable.venus,
            R.drawable.tierra,
            R.drawable.marte,
            R.drawable.jupiter,
            R.drawable.saturno,
            R.drawable.urano,
            R.drawable.neptuno
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPlanets = findViewById(R.id.spinnerPlanets);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewPlanet = findViewById(R.id.imageViewPlanet);

        planetNames = getResources().getStringArray(R.array.planets_array);

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, planetNames, planetImages);
        spinnerPlanets.setAdapter(adapter);

        spinnerPlanets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedPlanet = planetNames[position];
                textViewInfo.setText(getPlanetInfo(selectedPlanet));
                imageViewPlanet.setImageResource(planetImages[position]);
                applyFadeTransition(imageViewPlanet);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private String getPlanetInfo(String planet) {
        switch (planet) {
            case "Mercurio":
                return getString(R.string.mercurio_desc);
            case "Venus":
                return getString(R.string.venus_desc);
            case "Tierra":
                return getString(R.string.tierra_desc);
            case "Marte":
                return getString(R.string.marte_desc);
            case "Júpiter":
                return getString(R.string.jupiter_desc);
            case "Saturno":
                return getString(R.string.saturno_desc);
            case "Urano":
                return getString(R.string.urano_desc);
            case "Neptuno":
                return getString(R.string.neptuno_desc);
            default:
                return "";
        }
    }

    private void applyFadeTransition(ImageView imageView) {
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(500);
        imageView.startAnimation(fadeIn);
    }
}
