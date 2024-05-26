package com.example.notedefrais.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Role role;

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for nom
    public String getNom() {
        return nom;
    }

    // Setter for nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter for prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter for prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter for role
    public Role getRole() {
        return role;
    }

    // Setter for role
    public void setRole(Role role) {
        this.role = role;
    }
}

