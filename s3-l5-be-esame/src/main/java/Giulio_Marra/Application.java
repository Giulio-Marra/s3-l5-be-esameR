package Giulio_Marra;

import Giulio_Marra.dao.ArchivioDAO;
import Giulio_Marra.dao.PrestitoDAO;
import Giulio_Marra.dao.UtenteDAO;
import Giulio_Marra.entities.Contenuti;
import Giulio_Marra.entities.Libri;
import Giulio_Marra.entities.Riviste;
import Giulio_Marra.entities.Utente;
import Giulio_Marra.enums.Genere;
import Giulio_Marra.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3-l5-be-esame");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        ArchivioDAO archivioDAO = new ArchivioDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        Libri darknebula = new Libri("Dark Nebula", 1973, 206, "Brian Stableford", Genere.FANTASY);
        Libri fahrenheit = new Libri("Fahrenheit 451", 1953, 160, "Ray Bradbury", Genere.HORROR);
        Libri guidagalattica = new Libri("Guida Galattica per autostoppisti", 1980, 230, "Douglas Adams", Genere.FANTASCIENZA);

        Riviste cucina = new Riviste("Cucina Ayurveda", 2024, 321, Periodicita.MENSILE);
        Riviste focus = new Riviste("Focus Scienza", 2019, 201, Periodicita.SEMESTRALE);
        Riviste game = new Riviste("Game Sub", 2012, 156, Periodicita.SETTIMANALE);

        Utente giulio = new Utente("Giulio", "Marra", LocalDate.of(1995, 01, 21), 4435);
        Utente mario = new Utente("Mario", "Rossi", LocalDate.of(1990, 10, 15), 4498);
        Utente alessandro = new Utente("Alessandro", "Borlotti", LocalDate.of(1987, 12, 21), 9872);

        //archivioDAO.aggiungiContenuto(darknebula); METODO PER AGGUNGERE UN CONTENUTO


        utenteDAO.saveUtente(giulio);
        utenteDAO.saveUtente(mario);
        utenteDAO.saveUtente(alessandro);

        Utente utente1 = utenteDAO.getetUtente(1);
        Utente utente2 = utenteDAO.getetUtente(2);
        Utente utente3 = utenteDAO.getetUtente(3);

        Contenuti contenuto1 = archivioDAO.getContenuti(1);
        Contenuti contenuto2 = archivioDAO.getContenuti(2);
        Contenuti contenuto3 = archivioDAO.getContenuti(3);
        Contenuti contenuto4 = archivioDAO.getContenuti(4);
        Contenuti contenuto5 = archivioDAO.getContenuti(5);
        Contenuti contenuto6 = archivioDAO.getContenuti(6);

        //Prestito prestito1 = new Prestito(utente1, contenuto1, LocalDate.of(2024, 01, 10), LocalDate.of(2025, 02, 10), LocalDate.of(2025, 02, 10));
        //prestitoDAO.savePrestito(prestito1);


        System.out.println("Hello World!");

        em.close();
        emf.close();


    }
}
