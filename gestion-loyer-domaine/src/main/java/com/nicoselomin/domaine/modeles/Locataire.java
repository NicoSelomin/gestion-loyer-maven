package com.nicoselomin.domaine.modeles;

import java.time.LocalDate;

public class Locataire extends Utilisateur {

    public Locataire(String id, String nom, String prenom, String numeroTel, LocalDate dateNaissance, String adresse) {
        super(id, nom, prenom, numeroTel, dateNaissance, adresse);
    }

}
