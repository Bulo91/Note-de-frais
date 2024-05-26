package com.example.notedefrais;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notedefrais.dao.FraisKilometriqueDao;
import com.example.notedefrais.dao.RoleDao;
import com.example.notedefrais.dao.TypeDao;
import com.example.notedefrais.dao.UserDao;
import com.example.notedefrais.entity.FraisKilometrique;
import com.example.notedefrais.entity.Type;
import com.example.notedefrais.entity.User;

import java.time.LocalDate;

public class FraiskilometriqueActivity extends AppCompatActivity {

    private EditText editDate, editMontant, editLieuDepart, editLieuArrivee, editNomClient, editKilometrage, editPhotocopieCarteGrise;
    private Button buttonSaveFrais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraiskilometrique);

        // Initialiser les vues
        editMontant = findViewById(R.id.editMontantF);
        editDate = findViewById(R.id.editDateF);
        editLieuDepart = findViewById(R.id.editLieuDepartF);
        editLieuArrivee = findViewById(R.id.editLieuArriveeF);
        editNomClient = findViewById(R.id.editNomClientF);
        editKilometrage = findViewById(R.id.editKilometrageF);
        editPhotocopieCarteGrise = findViewById(R.id.editPhotocopieCarteGriseF);
        buttonSaveFrais = findViewById(R.id.btnSaveF);

        buttonSaveFrais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerFraisKilometrique();
            }
        });

    }
    private void registerFraisKilometrique() {
        String date = editDate.getText().toString().trim();
        double montant = Double.parseDouble(editMontant.getText().toString().trim());
        String lieuDepart = editLieuDepart.getText().toString().trim();
        String lieuArrivee = editLieuArrivee.getText().toString().trim();
        String nomClient = editNomClient.getText().toString().trim();
        double kilometrage = Double.parseDouble(editKilometrage.getText().toString().trim());
        String photocopieCarteGrise = editPhotocopieCarteGrise.getText().toString();


        if (date.isEmpty()  || lieuDepart.isEmpty() || lieuArrivee.isEmpty() || nomClient.isEmpty() || photocopieCarteGrise.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validation des champs (à implémenter)


        FraisKilometrique newFraisKilometrique = new FraisKilometrique();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            newFraisKilometrique.setDate(LocalDate.parse(date));
        }
        newFraisKilometrique.setMontant(montant);
        newFraisKilometrique.setLieuDepart(lieuDepart); // Pensez à hasher le mot de passe pour la sécurité
        newFraisKilometrique.setLieuArrivee(lieuArrivee);
        newFraisKilometrique.setNomClient(nomClient);
        newFraisKilometrique.setKilometrage(kilometrage);
        newFraisKilometrique.setPhotocopieCarteGrise(photocopieCarteGrise);


        Type type = TypeDao.findById(4);
        newFraisKilometrique.setType(type);

        FraisKilometriqueDao.saveFraisKilometrique(newFraisKilometrique);


// Affichage d'un message de succès
        Toast.makeText(this, "Frais kilométrique enregistré avec succès", Toast.LENGTH_SHORT).show();

// Redirection vers MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Termine RegisterActivity pour empêcher l'utilisateur de revenir à cette activité en appuyant sur le bouton retour

    }

}
