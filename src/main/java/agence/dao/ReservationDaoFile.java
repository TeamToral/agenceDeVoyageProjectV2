/**
 * 
 */
package agence.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.EtatReservation;
import agence.model.Passager;
import agence.model.Reservation;

/**
 * @author Seme
 */
public class ReservationDaoFile implements ReservationDao
{

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Reservation> findAll()
    {
        BufferedReader bReader = null;
        List<Reservation> reservations = new ArrayList<>();
        try
        {
            bReader = new BufferedReader(
                    new FileReader(new File("src/resources/reservations.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    Reservation reservation = new Reservation(
                            Integer.parseInt(champs[0]));
                    reservation.setDate(new SimpleDateFormat("yyyy-MM-dd")
                            .parse(champs[1]));
                    reservation.setNumero(champs[2]);
                    if (champs[3].equals(EtatReservation.ANNULEE.getLabel()))
                    {
                        reservation.setEtat(EtatReservation.ANNULEE);
                    }
                    else
                    {
                        reservation.setEtat(EtatReservation.CONFIRMEE);
                    }

                    reservations.add(reservation);
                }
                else
                {
                    premiereLigne = false;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (bReader != null)
            {
                try
                {
                    bReader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return reservations;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */
    @Override
    public Reservation findById(Integer id)
    {
        BufferedReader bReader = null;
        Reservation resservation = null;
        try
        {
            bReader = new BufferedReader(
                    new FileReader(new File("src/resources/reservations.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    if (Integer.parseInt(champs[0]) == id)
                    {
                        Reservation reservation = new Reservation(
                                Integer.parseInt(champs[0]));
                        reservation.setDate(new SimpleDateFormat("yyyy-MM-dd")
                                .parse(champs[1]));
                        reservation.setNumero(champs[2]);
                        if (champs[3]
                                .equals(EtatReservation.ANNULEE.getLabel()))
                        {
                            reservation.setEtat(EtatReservation.ANNULEE);
                        }
                        else
                        {
                            reservation.setEtat(EtatReservation.CONFIRMEE);
                        }

                        return reservation;
                    }
                }
                else
                {
                    premiereLigne = false;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (bReader != null)
            {
                try
                {
                    bReader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return resservation;
    }

    @Override
    public List<Reservation> findByPassager(Passager passager)
    {
        // liste des réservations
        List<Reservation> reservations = new ArrayList<>();
        // Tampon de lecture
        BufferedReader bReader = null;
        try
        {
            // On ouvre le fichier à lire
            bReader = new BufferedReader(new FileReader(
                    new File("src/resources/reservations_passager.csv")));
            // chaîne temporaire
            String s;
            // indicateur de première ligne
            boolean premiereLigne = true;
            // tant qu'il reste des lignes à lire
            while ((s = bReader.readLine()) != null)
            {
                // si je ne suis pas à la première ligne
                if (!premiereLigne)
                {
                    // je divise la chaîne en deux parties
                    String[] champs = s.split(";");
                    // si le numéro du passager passé en paramètre est égal au
                    // numéro du passager lu
                    if (passager.getIdPas() == Integer.parseInt(champs[0]))
                    {
                        // je divise à nouveau pour récupérer tous les codes des
                        // réservations
                        String[] idsRes = champs[1].split(",");
                        // pour chaque élément récupéré
                        for (String idResStr : idsRes)
                        {
                            // je récupère l'identifiant de la réservation
                            int idRes = Integer.parseInt(idResStr);
                            Reservation reservation = this.findById(idRes);
                            // Important : liaison au passager !
                            reservation.setPassager(passager);
                            // je l'ajoute à la liste
                            reservations.add(reservation);
                        } // fin boucle de parcours des ids réservation
                        return reservations;
                    } // fin si numéro du passager == numéro lu
                }
                // sinon (je suis à la première ligne)
                else
                {
                    // j'indique que je ne serai plus à la première ligne
                    premiereLigne = false;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (bReader != null)
            {
                try
                {
                    bReader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return reservations;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.ReservationDao#findByClient(agence.model.Client)
     */
    @Override
    public List<Reservation> findByClient(Client client)
    {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public void create(Reservation objet)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation update(Reservation obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reservation obj)
	{
		// TODO Auto-generated method stub
		
	}
}
