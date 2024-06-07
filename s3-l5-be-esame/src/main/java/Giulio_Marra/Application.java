package Giulio_Marra;

import Giulio_Marra.dao.ContenutiDAO;
import Giulio_Marra.entities.Libri;
import Giulio_Marra.entities.Riviste;
import Giulio_Marra.enums.Genere;
import Giulio_Marra.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3-l5-be-esame");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ContenutiDAO contenutoDao = new ContenutiDAO(em);

        try {
            Libri darknebula = new Libri("Dark Nebula", 1973, 206, "Brian Stableford", Genere.FANTASY);
            Libri fahrenheit = new Libri("Fahrenheit 451", 1953, 160, "Ray Bradbury", Genere.HORROR);
            Libri guidagalattica = new Libri("Guida Galattica per autostoppisti", 1980, 230, "Douglas Adams", Genere.FANTASCIENZA);

            Riviste cucina = new Riviste("Cucina Ayurveda", 2024, 321, Periodicita.MENSILE);
            Riviste focus = new Riviste("Focus Scienza", 2019, 201, Periodicita.SEMESTRALE);
            Riviste game = new Riviste("Game Sub", 2012, 156, Periodicita.SETTIMANALE);

            contenutoDao.saveContenuto(darknebula);
            contenutoDao.saveContenuto(fahrenheit);
            contenutoDao.saveContenuto(guidagalattica);
            contenutoDao.saveContenuto(cucina);
            contenutoDao.saveContenuto(focus);
            contenutoDao.saveContenuto(game);

            System.out.println("Hello World!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
