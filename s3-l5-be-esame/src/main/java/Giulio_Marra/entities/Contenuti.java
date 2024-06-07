package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contenuti")
public abstract class Contenuti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long isbn;

    protected String titolo;
    protected int anno_pubblicazione;
    protected int numero_pagine;

    @OneToMany(mappedBy = "contenuto")
    private List<Prestito> prestiti;

    public Contenuti() {
    }

    public Contenuti(String titolo, int anno_pubblicazione, int numero_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
}
