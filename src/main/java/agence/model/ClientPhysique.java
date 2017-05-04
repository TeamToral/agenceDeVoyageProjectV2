/**
 * 
 */
package agence.model;

/**
 * @author Seme
 */
public class ClientPhysique extends Client
{
    /**
     * Prénom
     */
    private String prenom;

    /**
     * @param idCli
     */
    
    public ClientPhysique()
    {
        super();
    }
    public ClientPhysique(int idCli)
    {
        super(idCli);
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
}
