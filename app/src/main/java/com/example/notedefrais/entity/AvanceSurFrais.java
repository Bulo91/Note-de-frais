package com.example.notedefrais.entity;

import java.time.LocalDate;

public class AvanceSurFrais extends NoteDeFrais {


    private  String justificatif;
    public AvanceSurFrais() {
        super() ;
    }
    public AvanceSurFrais(double montant, LocalDate date, String justificatif) {
        super(date,montant,"Avance sur frais");
        this.justificatif = justificatif;
    }
    public String getJustificatif() {
        return justificatif;
    }
    public void setJustificatif(String justificatif) {
        this.justificatif = justificatif;
    }
    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nJustificatif : " + justificatif ;

        return resultat ;
    }
}