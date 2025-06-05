package com.nicoselomin.domaine.modeles;


import java.util.Date;

public class Quittance {
    private String lien;
    private String reference;
    private Date dateGeneration;

    // Constructeur
    public Quittance(String lien, String reference, Date dateGeneration) {
        this.lien = lien;
        this.reference = reference;
        this.dateGeneration = dateGeneration;
    }

    // Getters
    public String getLien() {
        return lien;
    }

    public String getReference() {
        return reference;
    }

    public Date getDateGeneration() {
        return dateGeneration;
    }

    // Setters
    public void setLien(String lien) {
        this.lien = lien;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateGeneration(Date dateGeneration) {
        this.dateGeneration = dateGeneration;
    }
}

