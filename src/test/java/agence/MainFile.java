package agence;

import java.util.List;

import agence.dao.AdresseDao;
import agence.dao.AdresseDaoFile;
import agence.dao.PassagerDao;
import agence.dao.PassagerDaoFile;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoFile;
import agence.model.Adresse;
import agence.model.Passager;
import agence.model.Reservation;

public class MainFile
{

    public static void main(String[] args)
    {
        AdresseDao adresseDao = new AdresseDaoFile();
        List<Adresse> adresses = adresseDao.findAll();
        Adresse adresse = adresseDao.findById(2);

        PassagerDao passagerDao = new PassagerDaoFile();
        List<Passager> passagers = passagerDao.findAll();
        Passager passager = passagerDao.findById(1);

        ReservationDao reservationDao = new ReservationDaoFile();
        List<Reservation> reservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(2);
        // Recherche par passager
        List<Reservation> reservationsPassager = reservationDao
                .findByPassager(passager);

    }

}
