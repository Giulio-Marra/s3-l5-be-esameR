package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "contenuto_isbn")
    private Contenuti contenuto;

    private LocalDate data_inizio_prestito;
    private LocalDate data_prestito_prevista;
    private LocalDate data_restituzione;

    public Prestito() {

    }

    public Prestito(Utente utente, Contenuti contenuto, LocalDate data_inizio_prestito, LocalDate data_restituzione) {
        this.utente = utente;
        this.contenuto = contenuto;
        this.data_inizio_prestito = data_inizio_prestito;
        this.data_prestito_prevista = calcolaDataPrevista();
        this.data_restituzione = data_restituzione;
    }

    private LocalDate calcolaDataPrevista() {
        return data_inizio_prestito.plusDays(30);
    }

    public long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Contenuti getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuti contenuto) {
        this.contenuto = contenuto;
    }

    public LocalDate getData_inizio_prestito() {
        return data_inizio_prestito;
    }

    public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
        this.data_inizio_prestito = data_inizio_prestito;
    }

    public LocalDate getData_prestito_prevista() {
        return data_prestito_prevista;
    }

    public void setData_prestito_prevista(LocalDate data_prestito_prevista) {
        this.data_prestito_prevista = data_prestito_prevista;
    }

    public LocalDate getData_restituzione() {
        return data_restituzione;
    }

    public void setData_restituzione(LocalDate data_restituzione) {
        this.data_restituzione = data_restituzione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", contenuto=" + contenuto +
                ", data_inizio_prestito=" + data_inizio_prestito +
                ", data_prestito_prevista=" + data_prestito_prevista +
                ", data_restituzione=" + data_restituzione +
                '}';
    }
}
