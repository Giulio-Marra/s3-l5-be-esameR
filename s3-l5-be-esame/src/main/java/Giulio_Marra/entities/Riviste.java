package Giulio_Marra.entities;

import Giulio_Marra.enums.Periodicita;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Rivista")
public class Riviste extends Contenuti {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Riviste() {
    }

    public Riviste(String titolo, int anno_pubblicazione, int numero_pagine, Periodicita periodicita) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }

    // Getters and Setters
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
