package com.example.notedefrais;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notedefrais.dao.HebergementDao;
import com.example.notedefrais.dao.TypeDao;
import com.example.notedefrais.entity.Hebergement;
import com.example.notedefrais.entity.Type;

import java.time.LocalDate;

public class HebergementActivity extends AppCompatActivity {
    private EditText editDate, editMontant, editDistance;
    private Button buttonSaveHebergement;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hebergement);
        editMontant = findViewById(R.id.editMontantH);
        editDate = findViewById(R.id.editDateH);
        editDistance = findViewById(R.id.editDistanceH);
        buttonSaveHebergement = findViewById(R.id.btnSaveH);

        buttonSaveHebergement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerHebergement();
            }
        });

    }
    private void registerHebergement(){
        String date = editDate.getText().toString().trim();
        double montant = Double.parseDouble(editMontant.getText().toString().trim());
        double distance = Double.parseDouble(editDistance.getText().toString().trim());

        Hebergement newHebergement = new Hebergement();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            newHebergement.setDate(LocalDate.parse(date));
        }
        newHebergement.setMontant(montant);
        newHebergement.setDistance(distance);

        Type type = TypeDao.findById(2);
        newHebergement.setType(type);

        HebergementDao.saveHebergement(newHebergement);

        // Affichage d'un message de succès
        Toast.makeText(this, "Hebergement enregistré avec succès", Toast.LENGTH_SHORT).show();

        // Redirection vers MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Termine RegisterActivity pour empêcher l'utilisateur de revenir à cette activité en appuyant sur le bouton retour

    }
}