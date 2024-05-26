package com.example.notedefrais.entity;

import java.time.LocalDate;

import java.util.List;

 public class Dejeuner extends NoteDeFrais {

    private List<String> inviter;
    private String nomSociete;
    private Type type;
    public  Dejeuner(){
        super();
    }

    public Dejeuner(LocalDate date, double montant, List<String> inviter, String nomSociete) {
        super(date, montant, "Note de frais du déjeuner");
        this.inviter = inviter;
        this.nomSociete = nomSociete;
    }

     public List<String> getInviter() {
         return inviter;
     }

     public void setInviter(List<String> inviter) {
         this.inviter = inviter;
     }

     public String getNomSociete(){
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
         this.nomSociete = nomSociete;
    }

     @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nListe d'inviter : " + inviter ;
        resultat += "\nNom de la société: " + nomSociete ;


        return resultat ;
    }
     public Type getType(){
         return type;
     }
     public void setType(Type type){
         this.type = type;
     }

}