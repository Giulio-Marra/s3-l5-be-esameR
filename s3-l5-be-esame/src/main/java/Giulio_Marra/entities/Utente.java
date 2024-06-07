package Giulio_Marra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String cognome;
    private LocalDate data_di_nascita;
    private int numero_tessera;

    public Utente() {

    }

    public Utente(String nome, String cognome, LocalDate data_di_nascita, int numero_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.numero_tessera = numero_tessera;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(int numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", numero_tessera=" + numero_tessera +
                '}';
    }
}
