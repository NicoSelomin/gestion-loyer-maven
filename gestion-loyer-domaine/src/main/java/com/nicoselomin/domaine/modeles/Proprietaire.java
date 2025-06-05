package com.nicoselomin.domaine.modeles;

import java.time.LocalDate;

public class Proprietaire extends Utilisateur {

    public Proprietaire(String id, String nom, String prenom, String numeroTel, LocalDate dateNaissance, String adresse) {
        super(id, nom, prenom, numeroTel, dateNaissance, adresse);
    }

}
