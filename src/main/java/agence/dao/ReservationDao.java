package agence.dao;

import java.util.List;

import agence.model.Client;
import agence.model.Passager;
import agence.model.Reservation;

public interface ReservationDao extends Dao<Reservation, Integer>
{
    /**
     * Retourne la liste des réservations en fonction d'un passager
     * 
     * @param passager
     *            Le passager
     * @return Liste des réservations en fonction du passager passé en paramètre
     */
    public List<Reservation> findByPassager(Passager passager);

    /**
     * Retourne la liste des réservations en fonction d'un client
     * 
     * @param client
     *            Le client qui a réservé
     * @return Liste des réservations du client
     */
    public List<Reservation> findByClient(Client client);
}
