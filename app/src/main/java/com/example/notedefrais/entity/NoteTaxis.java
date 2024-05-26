package com.example.notedefrais.entity;

import java.time.LocalDate;

public class NoteTaxis extends NoteDeFrais {
    private String villeDepart;
    private String villeArrivee;
    private String nomClient;
    private Type type;
    public NoteTaxis(){
        super();
    }
    public NoteTaxis(LocalDate date, double montant, String villeDepart, String villeArrivee, String nomClient) {
        super(date, montant, "Frais de taxi");
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.nomClient = nomClient;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nVille de départ : " + villeDepart ;
        resultat += "\nVille d'arrivée : " + villeArrivee ;
        resultat += "\nNom du client : " + nomClient ;

        return resultat ;
    }
    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }
}