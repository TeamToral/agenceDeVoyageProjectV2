/**
 * 
 */
package agence.model;

import java.sql.Time;
import java.util.Date;

/**
 * Représente une escale effectuée lors d'un vol
 * 
 * @author seme
 */
public class Escale
{

    /**
     * Date de départ de l'aéroport
     */
    private Date dateDepart;
    /**
     * Date d'arrivée de l'aéroport
     */
    private Date dateArrivee;
    /**
     * Heure de départ
     */
    private Time heureDepart;
    /**
     * Heure d'arrivée
     */
    private Time heureArrivee;
    /**
     * Identifiant technique de l'escale
     */
    private int idEscale;
    /**
     * Vol contenant l'escale
     */
    private Vol vol;

    /**
     * Aéroport où se fait l'escale
     */
    private Aeroport aeoroport;

    /**
     * Constructeur par défaut
     */
    public Escale()
    {
        this.dateDepart = null;
        this.dateArrivee = null;
        this.heureDepart = null;
        this.heureArrivee = null;
    }

    /**
     * Constructeur
     * 
     * @param idEscale
     *            Identifiant technique de l'escale
     */
    public Escale(int idEscale)
    {
        this.idEscale = idEscale;
    }

    /**
     * @return the dateDepart
     */
    public Date getDateDepart()
    {
        return dateDepart;
    }

    /**
     * @param dateDepart
     *            the dateDepart to set
     */
    public void setDateDepart(Date dateDepart)
    {
        this.dateDepart = dateDepart;
    }

    /**
     * @return the dateArrivee
     */
    public Date getDateArrivee()
    {
        return dateArrivee;
    }

    /**
     * @param dateArrivee
     *            the dateArrivee to set
     */
    public void setDateArrivee(Date dateArrivee)
    {
        this.dateArrivee = dateArrivee;
    }

    /**
     * @return the heureDepart
     */
    public Time getHeureDepart()
    {
        return heureDepart;
    }

    /**
     * @param heureDepart
     *            the heureDepart to set
     */
    public void setHeureDepart(Time heureDepart)
    {
        this.heureDepart = heureDepart;
    }

    /**
     * @return the heureArrivee
     */
    public Time getHeureArrivee()
    {
        return heureArrivee;
    }

    /**
     * @param heureArrivee
     *            the heureArrivee to set
     */
    public void setHeureArrivee(Time heureArrivee)
    {
        this.heureArrivee = heureArrivee;
    }

    /**
     * @return the idEscale
     */
    public int getIdEscale()
    {
        return idEscale;
    }

    /**
     * @param idEscale
     *            the idEscale to set
     */
    public void setIdEscale(int idEscale)
    {
        this.idEscale = idEscale;
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
     * @return the aeoroport
     */
    public Aeroport getAeoroport()
    {
        return aeoroport;
    }

    /**
     * @param aeoroport
     *            the aeoroport to set
     */
    public void setAeoroport(Aeroport aeoroport)
    {
        this.aeoroport = aeoroport;
    }

    @Override
    public String toString()
    {
        return "Escale [dateDepart=" + dateDepart + ", dateArrivee="
                + dateArrivee + ", heureDepart=" + heureDepart
                + ", heureArrivee=" + heureArrivee + ", idEscale=" + idEscale
                + ", vol=" + vol + ", aeoroport=" + aeoroport + "]";
    }

}
