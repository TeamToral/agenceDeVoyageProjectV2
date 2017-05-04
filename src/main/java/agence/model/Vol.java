package agence.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Représente le vol
 * 
 * @author seme
 */
public class Vol
{

    /**
     * identifiant technique du vol
     */
    private int idVol;
    /**
     * date de départ du vol
     */
    private Date dateDepart;
    /**
     * date d'arrivée du vol
     */
    private Date dateArrivee;
    /**
     * heure départ du vol
     */
    private Time heureDepart;
    /**
     * heure d'arrivée du vol
     */
    private Time heureArrivee;
    /**
     * Aéroport de départ
     */
    private Aeroport aeroportDepart;
    /**
     * Aéroport d'arrivée
     */
    private Aeroport aeroportArrivee;

    /**
     * liste d'escales que le vol va effectuer
     */
    private List<Escale> escales;

    /**
     * constructeur de vol
     * 
     * @param idVol
     *            l'ID du vol
     */
    public Vol(int idVol)
    {
        this.idVol = idVol;
        this.escales = new ArrayList<Escale>();
    }

    /**
     * @return the idVol
     */
    public int getIdVol()
    {
        return idVol;
    }

    /**
     * @param idVol
     *            the idVol to set
     */
    public void setIdVol(int idVol)
    {
        this.idVol = idVol;
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
     * @return the aeroportDepart
     */
    public Aeroport getAeroportDepart()
    {
        return aeroportDepart;
    }

    /**
     * @param aeroportDepart
     *            the aeroportDepart to set
     */
    public void setAeroportDepart(Aeroport aeroportDepart)
    {
        this.aeroportDepart = aeroportDepart;
    }

    /**
     * @return the aeroportArrivee
     */
    public Aeroport getAeroportArrivee()
    {
        return aeroportArrivee;
    }

    /**
     * @param aeroportArrivee
     *            the aeroportArrivee to set
     */
    public void setAeroportArrivee(Aeroport aeroportArrivee)
    {
        this.aeroportArrivee = aeroportArrivee;
    }

    /**
     * @return the escales
     */
    public List<Escale> getEscales()
    {
        return escales;
    }

    /**
     * @param escales
     *            the escales to set
     */
    public void setEscales(List<Escale> escales)
    {
        this.escales = escales;
    }

    public String toString()
    {
        String reponse = "Le vol qui part de : " + this.aeroportDepart.getNom()
                + " le " + this.dateDepart + " à " + this.heureDepart
                + "\n\tarrivera à " + this.aeroportArrivee.getNom() + " le "
                + this.dateArrivee + " à " + this.heureArrivee;
        if (escales.size() > 0)
        {
            reponse += "\n\t\tIl fera des escales à : ";
            for (int i = 0; i < escales.size(); i++)
            {
                reponse += "\n\t\t\t"
                        + this.escales.get(i).getAeoroport().getNom() + " le "
                        + this.escales.get(i).getDateArrivee() + " à "
                        + this.escales.get(i).getHeureArrivee() + " jusqu'au "
                        + this.escales.get(i).getDateDepart() + " à "
                        + this.escales.get(i).getHeureDepart();
            }
        }

        return reponse;
    }
}
