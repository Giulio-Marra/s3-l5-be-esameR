package Giulio_Marra;

import Giulio_Marra.dao.ArchivioDAO;
import Giulio_Marra.dao.PrestitoDAO;
import Giulio_Marra.dao.UtenteDAO;
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
        Libri librocasuale = new Libri("librocasuale", 2000, 220, "Signor Nessuno", Genere.FANTASCIENZA);

        Riviste cucina = new Riviste("Cucina Ayurveda", 2024, 321, Periodicita.MENSILE);
        Riviste focus = new Riviste("Focus Scienza", 2019, 201, Periodicita.SEMESTRALE);
        Riviste game = new Riviste("Game Sub", 2012, 156, Periodicita.SETTIMANALE);

        Utente giulio = new Utente("Giulio", "Marra", LocalDate.of(1995, 01, 21), 4435);
        Utente mario = new Utente("Mario", "Rossi", LocalDate.of(1990, 10, 15), 4498);
        Utente alessandro = new Utente("Alessandro", "Borlotti", LocalDate.of(1987, 12, 21), 9872);

        /*archivioDAO.aggiungiContenuto(darknebula);
        archivioDAO.aggiungiContenuto(fahrenheit);
        archivioDAO.aggiungiContenuto(guidagalattica);
        archivioDAO.aggiungiContenuto(cucina);
        archivioDAO.aggiungiContenuto(focus);
        archivioDAO.aggiungiContenuto(game);


        utenteDAO.saveUtente(giulio);
        utenteDAO.saveUtente(mario);
        utenteDAO.saveUtente(alessandro);*/


        /*Utente utente1 = utenteDAO.getetUtente(1);
        Utente utente2 = utenteDAO.getetUtente(2);
        Utente utente3 = utenteDAO.getetUtente(3);

        Contenuti contenuto1 = archivioDAO.getContenuti(1);
        Contenuti contenuto2 = archivioDAO.getContenuti(2);
        Contenuti contenuto3 = archivioDAO.getContenuti(3);
        Contenuti contenuto4 = archivioDAO.getContenuti(4);
        Contenuti contenuto5 = archivioDAO.getContenuti(5);
        Contenuti contenuto6 = archivioDAO.getContenuti(6);

        Prestito prestito1 = new Prestito(utente1, contenuto1, LocalDate.of(2024, 12, 02), LocalDate.of(2024, 12, 10));
        Prestito prestito2 = new Prestito(utente1, contenuto2, LocalDate.of(2024, 11, 10), LocalDate.of(2024, 12, 11));
        Prestito prestito3 = new Prestito(utente2, contenuto4, LocalDate.of(2024, 8, 10), LocalDate.of(2024, 10, 20));
        Prestito prestito4 = new Prestito(utente1, contenuto3, LocalDate.of(2024, 11, 11), LocalDate.of(2024, 12, 7));
        Prestito prestito5 = new Prestito(utente3, contenuto2, LocalDate.of(2024, 10, 15), LocalDate.of(2024, 12, 2));
        Prestito prestito6 = new Prestito(utente2, contenuto3, LocalDate.of(2024, 2, 22), LocalDate.of(2024, 2, 24));
        Prestito prestito7 = new Prestito(utente2, contenuto4, LocalDate.of(2024, 10, 10), LocalDate.of(2024, 11, 1));
        Prestito prestito8 = new Prestito(utente1, contenuto5, LocalDate.of(2024, 5, 1), LocalDate.of(2024, 6, 8));
        Prestito prestito9 = new Prestito(utente3, contenuto3, LocalDate.of(2024, 6, 2), LocalDate.of(2024, 7, 9));
        Prestito prestito10 = new Prestito(utente2, contenuto6, LocalDate.of(2024, 3, 7), LocalDate.of(2024, 5, 16));

        prestitoDAO.savePrestito(prestito1);
        prestitoDAO.savePrestito(prestito2);
        prestitoDAO.savePrestito(prestito3);
        prestitoDAO.savePrestito(prestito4);
        prestitoDAO.savePrestito(prestito5);
        prestitoDAO.savePrestito(prestito6);
        prestitoDAO.savePrestito(prestito7);
        prestitoDAO.savePrestito(prestito8);
        prestitoDAO.savePrestito(prestito9);
        prestitoDAO.savePrestito(prestito10);*/


        System.out.println("Hello World!");
        //METODO PER CERCARE TRAMITE ISBN, NON HO SALDATO IL DATO MA FATTO UN LOG PER COMODITA
        System.out.println(archivioDAO.getContenuti(1));
        //METOTO PER CERCARE IL CONTENUTO PER ANNO PUBBLICAZIONE
        System.out.println(archivioDAO.getContenutiPerAnno(1953));
        //METODO PER CERCARE IL CONTENUTO PER AUTORE
        System.out.println(archivioDAO.getContenutiPerAUtore("Douglas Adams"));
        //METOTO PER CERCARE PER TIUTOLO O PARTE DEL TITOLO
        System.out.println(archivioDAO.getContenutiPerTitolo("ienza"));
        //
        System.out.println(archivioDAO.getContenutiAttualmenteInPrestito(4498));

        em.close();
        emf.close();


    }
}
