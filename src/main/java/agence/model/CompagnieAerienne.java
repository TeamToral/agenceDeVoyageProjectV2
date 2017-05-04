package agence.model;

public class CompagnieAerienne
{

    /**
     * Id de la compagnie aérienne
     */
    private int idCom;

    /**
     * Nom de la compagnie aérienne
     */
    private String nom;

    /**
     * Constructeur
     * 
     * @param id
     *            Identifiant de la compagnie
     * @param nom
     *            Nom de la compagnie
     */
    public CompagnieAerienne(int id, String nom)
    {
        this.idCom = id;
        this.nom = nom;
    }

    /**
     * @return the idCom
     */
    public int getIdCom()
    {
        return idCom;
    }

    /**
     * @param idCom
     *            the idCom to set
     */
    public void setIdCom(int idCom)
    {
        this.idCom = idCom;
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

    @Override
    public String toString()
    {
        return "CompagnieAerienne [id=" + idCom + ", nom=" + nom + "]";
    }

}
