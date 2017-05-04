package agence.model;

/**
 * Représente le lien entre une ville et un aéroport
 * 
 * @author Seme
 */
public class VilleAeroport
{

    /**
     * Identifiant technique du lien
     */
    private int id;
    /**
     * Ville desservie par l'aéroport
     */
    private Ville ville;
    /**
     * Aéroport qui dessert la ville
     */
    private Aeroport aeroport;

    /**
     * Constructeur par défaut
     */
    public VilleAeroport()
    {

    }

    /**
     * Construcuteur
     * 
     * @param id
     *            Identifiant technique du lien entre la ville et l'aéroport
     */
    public VilleAeroport(int id)
    {
        this();
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the ville
     */
    public Ville getVille()
    {
        return ville;
    }

    /**
     * @param ville
     *            the ville to set
     */
    public void setVille(Ville ville)
    {
        this.ville = ville;
    }

    /**
     * @return the aeroport
     */
    public Aeroport getAeroport()
    {
        return aeroport;
    }

    /**
     * @param aeroport
     *            the aeroport to set
     */
    public void setAeroport(Aeroport aeroport)
    {
        this.aeroport = aeroport;
    }

    public String toString()
    {
        String reponse = "La Ville : " + ville.getNom()
                + " est desservie par l'aéroport : " + aeroport.getNom() + ".";

        return reponse;
    }

}
