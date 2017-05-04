package agence.model;

import java.sql.Date;

/**
 * Réservation d'un vol pour un passager effectuée par un client
 * 
 * @author Seme
 */
public class Reservation
{

    /**
     * Identifiant technique de la réservation
     */
    private int idRes;
    /**
     * Date de la réservation
     */
    private Date date;
    /**
     * Numéro de la réservation
     */
    private String numero;
    /**
     * Etat de la réservation (annulée ou confirmée)
     */
    private EtatReservation etat;
    /**
     * La référence du passager
     */
    private Passager passager;

    /**
     * identifiant technique du passager
     */
    private int idPas;
    /**
     * identifiant technique du client
     */
    private int idCli;

    /**
     * Vol associé à la réservation
     */
    private Vol vol;

    /**
     * Client qui a effectué la réservation
     */
    private Client client;

    public Reservation(int idRes)
    {
        this.idRes = idRes;
    }

    /**
     * Constructeur par défaut
     */
    public Reservation()
    {
    }

    /**
     * @return the idRes
     */
    public int getIdRes()
    {
        return idRes;
    }

    /**
     * @param idRes
     *            the idRes to set
     */
    public void setIdRes(int idRes)
    {
        this.idRes = idRes;
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * @param numero
     *            the numero to set
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * @return the etat
     */
    public EtatReservation getEtat()
    {
        return etat;
    }

    /**
     * @param etat
     *            the etat to set
     */
    public void setEtat(EtatReservation etat)
    {
        this.etat = etat;
    }

    /**
     * @return the passager
     */
    public Passager getPassager()
    {
        return passager;
    }

    /**
     * @param passager
     *            the passager to set
     */
    public void setPassager(Passager passager)
    {
        this.passager = passager;
    }

    /**
     * @return the idPas
     */
    public int getIdPas()
    {
        return idPas;
    }

    /**
     * @param idPas
     *            the idPas to set
     */
    public void setIdPas(int idPas)
    {
        this.idPas = idPas;
    }

    /**
     * @return the idCli
     */
    public int getIdCli()
    {
        return idCli;
    }

    /**
     * @param idCli
     *            the idCli to set
     */
    public void setIdCli(int idCli)
    {
        this.idCli = idCli;
    }

    /**
     * @return the vol
     */
    public Vol getVol()
    {
        return vol;
    }

    /**
     * @param vol
     *            the vol to set
     */
    public void setVol(Vol vol)
    {
        this.vol = vol;
    }

    /**
     * @return the client
     */
    public Client getClient()
    {
        return client;
    }

    /**
     * @param client
     *            the client to set
     */
    public void setClient(Client client)
    {
        this.client = client;
    }

    public String toString()
    {
        String reponse = "La Reservation : " + this.numero
                + "\n\ta été effectuée par le client : " + client.getNom()
                + "\n\tElle porte sur le vol de "
                + vol.getAeroportDepart().getNom() + " à "
                + vol.getAeroportArrivee().getNom()
                + ".\n\tElle concerne le passager : " + passager.getNom() + " "
                + passager.getPrenom();

        return reponse;
    }

}
