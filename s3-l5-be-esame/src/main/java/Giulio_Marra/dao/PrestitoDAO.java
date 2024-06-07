package Giulio_Marra.dao;

import Giulio_Marra.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void savePrestito(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito " + prestito.getContenuto() + " aggiunto correttamente al database");
    }
}
