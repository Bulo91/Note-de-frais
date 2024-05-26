package com.example.notedefrais;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupérer les boutons radio
        RadioButton radioButtonAccommodation = findViewById(R.id.radioButtonAccommodation);
        RadioButton radioButtonTaxi = findViewById(R.id.radioButtonTaxi);
        RadioButton radioButtonLunch = findViewById(R.id.radioButtonLunch);
        RadioButton radioButtonKilometer = findViewById(R.id.radioButtonKilometer);

        // Ajouter des écouteurs de clic pour chaque bouton radio
        radioButtonAccommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HebergementActivity.class));
            }
        });

        radioButtonTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NoteTaxisActivity.class));
            }
        });

        radioButtonLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DejeunerActivity.class));
            }
        });

        radioButtonKilometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FraiskilometriqueActivity.class));
            }
        });

    }
}
