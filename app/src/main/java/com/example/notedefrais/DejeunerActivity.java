package com.example.notedefrais;

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

import com.example.notedefrais.dao.DejeunerDao;
import com.example.notedefrais.dao.TypeDao;
import com.example.notedefrais.entity.Dejeuner;
import com.example.notedefrais.entity.Type;

import java.time.LocalDate;

public class DejeunerActivity extends AppCompatActivity {

    private EditText editDate, editMontant, editNomSociete;
    private Button buttonSaveDejeuner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dejeuner);

        editDate = findViewById(R.id.editDateD);
        editMontant = findViewById(R.id.editMontantD);
        editNomSociete = findViewById(R.id.editMontantD);
        buttonSaveDejeuner = findViewById(R.id.btnSaveD);

        buttonSaveDejeuner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDejeuner();
            }
        });
    }
    private void registerDejeuner(){
        String date = editDate.getText().toString().trim();
        double montant = Double.parseDouble(editMontant.getText().toString().trim());
        String nomSociete = editNomSociete.getText().toString().trim();

        if (date.isEmpty() || nomSociete.isEmpty()){
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        Dejeuner newDejeuner = new Dejeuner();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            newDejeuner.setDate(LocalDate.parse(date));
        }
        newDejeuner.setMontant(montant);
        newDejeuner.setNomSociete(nomSociete);

        Type type = TypeDao.findById(1);
        newDejeuner.setType(type);

        DejeunerDao.saveDejeuner(newDejeuner);

        Toast.makeText(this, "Déjeuner enregistré avec succès", Toast.LENGTH_SHORT).show();

        // Redirection vers MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Termine RegisterActivity pour empêcher l'utilisateur de revenir à cette activité en appuyant sur le bouton retour



    }
}