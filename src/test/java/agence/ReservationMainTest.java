package agence;

import java.util.Date;
import java.util.List;

import agence.dao.PassagerDaoSql;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;
import agence.model.Passager;
import agence.model.Reservation;


public class ReservationMainTest {

	public static void main(String[] args) 
	{
		// J'instancie le dao qui va récupérer à ma place les données
        // dans la BDD
        ReservationDao reservationDao = new ReservationDaoSql();
        PassagerDaoSql passagerDao = new PassagerDaoSql();
        // Ma liste d'élèves qui va contenir la liste de résultats
        List<Reservation> listeDreservations;
        // je demande au DAO de me trouver tous les élèves de la BDD
        listeDreservations = reservationDao.findAll(); 
        
        Passager passager = passagerDao.findById(1);
        
        Reservation tokyo = new Reservation();
        tokyo.setNumero("123456");
        tokyo.setPassager(passager);
        tokyo.setIdCli(10);
		
		reservationDao.create(tokyo);
        
        
//        // mettre à jour l'élève n°3, je change sa note
//        Reservation reservationAChanger = reservationDao.findById(55);
//        // je mets à jour au niveau de l'OBJET la note
//        reservationAChanger.setNumero("111");
//        // je mets à jour au niveau BDD !!
//        Reservation reservationMiseAJour = reservationDao.update(reservationAChanger);
//        // Je supprime l'élève n°5
//        Reservation reservationASupprimer = reservationDao.findById(55);
//        reservationDao.delete(reservationASupprimer);
        
	}

}
