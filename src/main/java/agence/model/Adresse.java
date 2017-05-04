/**
 * 
 */
package agence.model;

/**
 * Classe qui représente l'objet métier Adresse
 * 
 * @author seme
 */
public class Adresse
{

    /**
     * Identifiant technique de l'adresse
     */
    private int idAdd;

    /**
     * Numéro et voie
     */
    private String adresse;

    /**
     * Code postal
     */
    private String codePostal;

    /**
     * Ville
     */
    private String ville;

    /**
     * Pays
     */
    private String pays;

    /**
     * Constructeur
     * 
     * @param idAdd
     *            L'identifiant de l'adresse
     */
    public Adresse(int idAdd)
    {
        this.idAdd = idAdd;
    }

    /**
     * Constructeur par défaut
     */
    public Adresse()
    {
    }

    /**
     * @return the idAdd
     */
    public int getIdAdd()
    {
        return idAdd;
    }

    /**
     * @param idAdd
     *            the idAdd to set
     */
    public void setIdAdd(int idAdd)
    {
        this.idAdd = idAdd;
    }

    /**
     * @return the adresse
     */
    public String getAdresse()
    {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    /**
     * @return the codePostal
     */
    public String getCodePostal()
    {
        return codePostal;
    }

    /**
     * @param codePostal
     *            the codePostal to set
     */
    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }

    /**
     * @return the ville
     */
    public String getVille()
    {
        return ville;
    }

    /**
     * @param ville
     *            the ville to set
     */
    public void setVille(String ville)
    {
        this.ville = ville;
    }

    /**
     * @return the pays
     */
    public String getPays()
    {
        return pays;
    }

    /**
     * @param pays
     *            the pays to set
     */
    public void setPays(String pays)
    {
        this.pays = pays;
    }

    @Override
    public String toString()
    {
        return "Adresse [adresse=" + adresse + ", codePostal=" + codePostal
                + ", ville=" + ville + ", pays=" + pays + "identifiant adresse=" + idAdd + "]";
    }

}
