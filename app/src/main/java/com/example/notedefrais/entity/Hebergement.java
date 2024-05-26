package com.example.notedefrais.entity;

import java.time.LocalDate;

public class Hebergement extends NoteDeFrais {

    public static final int getDistance = 0;
    private double distance;
    private Type type;
    public Hebergement(){
        super();
    }
    public Hebergement(LocalDate date, double montant, int distance) {
        super(date,montant,"Note de frais hebergement");
        this.distance = distance;
    }

    // Getters et setters`
    public void setDistance(double distance) {

        this.distance = distance;
    }
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nVille : " + distance ;

        return resultat ;
    }
    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }

}