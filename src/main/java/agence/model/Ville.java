package agence.model;

/**
 * Représente une ville désservie par un ou plusieurs aéroports
 * 
 * @author Seme
 */
public class Ville
{

    /**
     * Identifiant technique de la ville
     */
    private int idVil;

    /**
     * Nom de la ville
     */
    private String nom;

    /**
     * Constructeur
     * 
     * @param idVil
     *            Identifiant technique
     * @param nom
     *            Nom de la ville
     */
    public Ville(int idVil, String nom)
    {
        this.idVil = idVil;
        this.nom = nom;
    }

    /**
     * @return the idVil
     */
    public int getIdVil()
    {
        return idVil;
    }

    /**
     * @param idVil
     *            the idVil to set
     */
    public void setIdVil(int idVil)
    {
        this.idVil = idVil;
    }

    /**
     * @return the nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * @param nom
     *            the nom to set
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String toString()
    {
        String reponse = "La Ville : " + this.nom;

        return reponse;
    }

}
