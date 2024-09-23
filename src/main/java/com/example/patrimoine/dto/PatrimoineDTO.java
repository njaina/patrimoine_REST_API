package com.example.patrimoine.dto;

import java.time.LocalDateTime;

public class PatrimoineDTO {

    private String possesseur;
    private LocalDateTime derniereModification;

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
