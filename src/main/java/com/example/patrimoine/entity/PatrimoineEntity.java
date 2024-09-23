package com.example.patrimoine.entity;

import java.time.LocalDateTime; // Importer LocalDateTime

public class PatrimoineEntity {

    private int id; // Ajout de l'ID
    private String possesseur;
    private LocalDateTime derniereModification;

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(String possesseur) {
        this.possesseur = possesseur;
    }

    public LocalDateTime getDerniereModification() {
        return derniereModification;
    }

    public void setDerniereModification(LocalDateTime derniereModification) {
        this.derniereModification = derniereModification;
    }
}
