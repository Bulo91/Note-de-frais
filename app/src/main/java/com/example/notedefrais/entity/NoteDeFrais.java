package com.example.notedefrais.entity;

import java.time.LocalDate;

public abstract class NoteDeFrais {
    private LocalDate date;
    private double montant;
    private String details;
    private int id;

    public NoteDeFrais(){}

    public NoteDeFrais(String details) {
        this.details = details;
    }

    public NoteDeFrais(LocalDate date, double montant, String details) {
        this.date = date;
        this.montant = montant;
        this.details = details;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public String getDetails(){
        return details;
    }
    public void setDetails(String details){
        this.details = details;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nVille de départ : " + date ;
        resultat += "\nVille d'arrivée : " + montant ;
        resultat += "\nNom du client : " + details ;

        return resultat ;
    }

}
