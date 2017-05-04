package agence.model;

/**
 * Classe Passager qui représente le passager de la réservation
 * 
 * @author Seme
 */
public class Passager
{
    /**
     * Identifiant technique du passager
     */
    private int idPas;
    /**
     * Nom du passager
     */
    private String nom;
    /**
     * Prenom du passager
     */
    private String prenom;

    /**
     * Adresse du passager
     */
    private Adresse adresse;

    /**
     * Constructeur
     * 
     * @param idPas
     *            Identifiant technique du passager
     */
    public Passager(int idPas)
    {
        this.idPas = idPas;
    }

    /**
     * Constructeur par défaut
     */
    public Passager()
    {
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

    /**
     * @return the prenom
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * @param prenom
     *            the prenom to set
     */
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse()
    {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Passager [idPas=" + idPas + ", nom=" + nom + ", prenom="
                + prenom + ", adresse=" + adresse + "]";
    }
}
