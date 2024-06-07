package Giulio_Marra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private long id;

    private Contenuti contenuto;
    private LocalDate data_inizio_prestito;
    private LocalDate data_prestito_prevista;
    private LocalDate data_restituzione;
}
