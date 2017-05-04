package agence;

import java.util.List;

import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;
import agence.model.Reservation;

public class ReservationMainTest {

	public static void main(String[] args) 
	{
		// J'instancie le dao qui va récupérer à ma place les données
        // dans la BDD
        ReservationDao reservationDao = new ReservationDaoSql();
        // Ma liste d'élèves qui va contenir la liste de résultats
        List<Reservation> listeDreservations;
        // je demande au DAO de me trouver tous les élèves de la BDD
        listeDreservations = reservationDao.findAll();  
        // mettre à jour l'élève n°3, je change sa note
        Reservation reservationAChanger = reservationDao.findById(54);
        // je mets à jour au niveau de l'OBJET la note
        reservationAChanger.setNumero("2222");
        // je mets à jour au niveau BDD !!
        Reservation reservationMiseAJour = reservationDao.update(reservationAChanger);
        // Je supprime l'élève n°5
        Reservation reservationASupprimer = reservationDao.findById(54);
        reservationDao.delete(reservationASupprimer);
	}

}
