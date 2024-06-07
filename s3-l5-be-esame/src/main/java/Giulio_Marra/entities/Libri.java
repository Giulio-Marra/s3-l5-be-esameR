package Giulio_Marra.entities;

import Giulio_Marra.enums.Genere;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Libro")
public class Libri extends Contenuti {
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libri() {
    }

    public Libri(String titolo, int anno_pubblicazione, int numero_pagine, String autore, Genere genere) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Getters and Setters
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
