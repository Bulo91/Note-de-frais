package com.example.notedefrais;

import android.content.Intent;
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

import com.example.notedefrais.dao.UserDao;
import com.example.notedefrais.entity.User;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        saveButton = findViewById(R.id.buttonRegisterMain);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class); // redirige vers register activity
                startActivity(intent);
            }
        });
    }

    private void login() {
        String email = emailEditText.getText().toString().trim(); // Utilisez trim() pour supprimer les espaces avant et après.
        String password = passwordEditText.getText().toString().trim();

        // Vérifier si les champs ne sont pas vides
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
            return; // Arrêtez la méthode ici si les champs sont vides
        }
        //
        User user = UserDao.findUserByEmailAndPassword(email, password);

        if (user != null) {
            // L'utilisateur existe, redirection vers une autre activité
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Termine MainActivity pour empêcher le retour à l'écran de connexion
        } else {
            Toast.makeText(this, "Informations d'identification invalides.", Toast.LENGTH_SHORT).show();
        }
    }

}
