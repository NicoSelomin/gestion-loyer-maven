package com.nicoselomin.domaine.modeles;


import java.util.Date;

public class Rappel {
    private String id;
    private String message;
    private Date dateEnvoi;
    private String destinataireId;

    // Constructeur
    public Rappel(String id, String message, Date dateEnvoi, String destinataireId) {
        this.id = id;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.destinataireId = destinataireId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public String getDestinataireId() {
        return destinataireId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public void setDestinataireId(String destinataireId) {
        this.destinataireId = destinataireId;
    }
}
