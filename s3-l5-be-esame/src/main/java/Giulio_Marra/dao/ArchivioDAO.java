package Giulio_Marra.dao;

import Giulio_Marra.entities.Contenuti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public Contenuti getContenuti(long id) {
        return em.find(Contenuti.class, id);
    }

}
