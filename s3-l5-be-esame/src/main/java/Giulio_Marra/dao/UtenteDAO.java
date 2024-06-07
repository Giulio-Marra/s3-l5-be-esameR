package Giulio_Marra.dao;

import Giulio_Marra.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void saveUtente(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " è stato aggiunto correttamente al database");
    }

    public Utente getetUtente(long isbn) {
        return em.find(Utente.class, isbn);
    }


}
