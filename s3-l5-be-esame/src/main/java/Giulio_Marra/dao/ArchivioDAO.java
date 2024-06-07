package Giulio_Marra.dao;

import Giulio_Marra.entities.Contenuti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArchivioDAO {
    private final EntityManager em;

    public ArchivioDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void aggiungiContenuto(Contenuti contenuto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(contenuto);
        transaction.commit();
        System.out.println("L'elemento " + contenuto.getTitolo() + " è stato aggiunto correttamente al archivio");
    }

    public Contenuti getContenuti(long isbn) {
        return em.find(Contenuti.class, isbn);
    }

    public List<Contenuti> getContenutiPerAnno(int anno) {
        TypedQuery<Contenuti> query = em.createQuery("SELECT c FROM Contenuti c WHERE c.anno_pubblicazione = :anno", Contenuti.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }


    public List<Contenuti> getContenutiPerAUtore(String autre) {
        TypedQuery<Contenuti> query = em.createQuery("SELECT c FROM Contenuti c WHERE c.autore = :autre", Contenuti.class);
        query.setParameter("autre", autre);
        return query.getResultList();
    }

    public List<Contenuti> getContenutiPerTitolo(String titolo) {
        TypedQuery<Contenuti> query = em.createQuery("SELECT c FROM Contenuti c WHERE c.titolo LIKE :titolo", Contenuti.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<Contenuti> getContenutiAttualmenteInPrestito(long codiceUtente) {
        TypedQuery<Contenuti> query = em.createQuery(
                "SELECT p.contenuto FROM Prestito p WHERE p.utente.numero_tessera = :codiceUtente AND p.data_restituzione IS NULL",
                Contenuti.class
        );
        query.setParameter("codiceUtente", codiceUtente);
        return query.getResultList();
    }

}
