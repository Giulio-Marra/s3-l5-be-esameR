package Giulio_Marra.dao;

import Giulio_Marra.entities.Contenuti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ContenutiDAO {
    private final EntityManager em;

    public ContenutiDAO(EntityManager em) {
        this.em = em;
    }

    public void saveContenuto(Contenuti contenuto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(contenuto);
        transaction.commit();
        System.out.println("L'elemento " + contenuto.getTitolo() + " è stato aggiunto correttamente al database");
    }
}
