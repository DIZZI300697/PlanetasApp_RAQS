package com.example.planetasapp_raqs;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPlanets;
    private TextView textViewInfo;
    private ImageView imageViewPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPlanets = findViewById(R.id.spinnerPlanets);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewPlanet = findViewById(R.id.imageViewPlanet);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPlanets.setAdapter(adapter);

        spinnerPlanets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedPlanet = (String) parentView.getItemAtPosition(position);
                textViewInfo.setText(getPlanetInfo(selectedPlanet));
                imageViewPlanet.setImageResource(getPlanetImage(selectedPlanet));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No hacer nada
            }
        });
    }

    private String getPlanetInfo(String planet) {
        switch (planet) {
            case "Mercurio":
                return "Mercurio es el planeta más cercano al Sol y el más pequeño del sistema solar.";
            case "Venus":
                return "Venus tiene una atmósfera muy densa y es el planeta más caliente.";
            case "Tierra":
                return "La Tierra es el único planeta conocido con vida.";
            case "Marte":
                return "Marte es conocido como el planeta rojo y tiene el volcán más grande del sistema solar.";
            case "Júpiter":
                return "Júpiter es el planeta más grande y tiene una gran tormenta llamada la Gran Mancha Roja.";
            case "Saturno":
                return "Saturno es conocido por sus impresionantes anillos.";
            case "Urano":
                return "Urano tiene un eje de rotación inclinado y rota de lado.";
            case "Neptuno":
                return "Neptuno es conocido por sus fuertes vientos y tormentas.";
            default:
                return "";
        }
    }

    private int getPlanetImage(String planet) {
        switch (planet) {
            case "Mercurio":
                return R.drawable.mercurio;
            case "Venus":
                return R.drawable.venus;
            case "Tierra":
                return R.drawable.tierra;
            case "Marte":
                return R.drawable.marte;
            case "Júpiter":
                return R.drawable.jupiter;
            case "Saturno":
                return R.drawable.saturno;
            case "Urano":
                return R.drawable.urano;
            case "Neptuno":
                return R.drawable.neptuno;
            default:
                return 0;
        }
    }
}
