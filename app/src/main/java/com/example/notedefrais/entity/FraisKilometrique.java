package com.example.notedefrais.entity;

import java.time.LocalDate;

public class FraisKilometrique extends NoteDeFrais {

    private String lieuDepart;
    private String lieuArrivee;
    private String nomClient;
    private double kilometrage;  // distance - table Note_Frais
    private String photocopieCarteGrise;
    private Type type;

    public FraisKilometrique(){
        super("Note de Frais Kilometrique");
    }
    public FraisKilometrique(LocalDate date, double montant, String lieuDepart,
                             String lieuArrivee, String nomClient, double kilometrage, String photocopieCarteGrise) {
        super(date, montant, "Note de Frais Kilometrique");

        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
        this.nomClient = nomClient;
        this.kilometrage = kilometrage;
        this.photocopieCarteGrise = photocopieCarteGrise;
    }


    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setPhotocopieCarteGrise (String photocopieCarteGrise) {
        this.photocopieCarteGrise = photocopieCarteGrise;
    }
    public String getPhotocopieCarteGrise() {
        return photocopieCarteGrise;
    }
    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nLieu de départ : " + lieuDepart ;
        resultat += "\nLieu d'arrivée : " + lieuArrivee ;
        resultat += "\nNom du client : " + nomClient ;
        resultat += "\nKilométrage : " + kilometrage;
        resultat += "\nPhotocopie de la Carte Grise : " + photocopieCarteGrise;
        return resultat ;
    }

    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }
}
