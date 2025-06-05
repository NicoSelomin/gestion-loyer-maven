package com.nicoselomin.dao.database;

import java.sql.Connection;
import java.sql.Statement;

public class DBInitializer {

    public static void initialiserTables() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS utilisateur (" +
                "id VARCHAR(20) PRIMARY KEY," +
                "nom VARCHAR(50)," +
                "prenom VARCHAR(50)," +
                "numero_tel VARCHAR(20)," +
                "date_naissance DATE," +
                "adresse VARCHAR(100)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS compte (" +
                "email VARCHAR(100) PRIMARY KEY," +
                "mot_de_passe VARCHAR(100)," +
                "role VARCHAR(20)," +
                "date_creation DATE," +
                "date_derniere_connexion DATE," +
                "statut VARCHAR(20)," +
                "utilisateur_id VARCHAR(20)," +
                "FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS locataire (" +
                "id VARCHAR(20) PRIMARY KEY," +
                "FOREIGN KEY (id) REFERENCES utilisateur(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS proprietaire (" +
                "id VARCHAR(20) PRIMARY KEY," +
                "FOREIGN KEY (id) REFERENCES utilisateur(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS bien_immobilier (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "designation VARCHAR(100)," +
                "adresse VARCHAR(100)," +
                "type VARCHAR(50)," +
                "loyer_mensuel FLOAT," +
                "charge_mensuel FLOAT," +
                "statut VARCHAR(50)," +
                "proprietaire_id VARCHAR(20)," +
                "FOREIGN KEY (proprietaire_id) REFERENCES proprietaire(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS contrat_location (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "reference VARCHAR(50)," +
                "date_entree DATE," +
                "loyer_et_charges FLOAT," +
                "depot_de_garantie FLOAT," +
                "jour_paiement INT," +
                "date_sortie DATE," +
                "etat VARCHAR(20)," +
                "lien VARCHAR(100)," +
                "locataire_id VARCHAR(20)," +
                "bien_id INT," +
                "FOREIGN KEY (locataire_id) REFERENCES locataire(id)," +
                "FOREIGN KEY (bien_id) REFERENCES bien_immobilier(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS paiement (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "mois DATE," +
                "montant_paye FLOAT," +
                "date_paiement DATE," +
                "mode_paiement VARCHAR(20)," +
                "statut VARCHAR(20)," +
                "contrat_id INT," +
                "FOREIGN KEY (contrat_id) REFERENCES contrat_location(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS quittance (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "lien VARCHAR(100)," +
                "reference VARCHAR(50)," +
                "date_generation DATE," +
                "paiement_id INT," +
                "FOREIGN KEY (paiement_id) REFERENCES paiement(id)" +
                ");"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS message (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "contenu_texte TEXT," +
                "piece_jointe VARCHAR(100)," +
                "date_envoie DATE," +
                "statut VARCHAR(20)," +
                "utilisateur_id VARCHAR(20)," +
                "FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)" +
                ");"
            );

            System.out.println("✅ Toutes les tables ont été créées avec succès !");

        } catch (Exception e) {
            throw new DAOException("❌ Erreur lors de la création des tables", e);
        }
    }
}
