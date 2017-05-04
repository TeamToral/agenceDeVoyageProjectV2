/**
 * 
 */
package agence.model;

/**
 * @author Seme
 */
public class ClientMoral extends Client
{
    /**
     * numéro SIRET (15 chiffres)
     */
    private long siret;

    /**
     * @param idCli
     */
    public ClientMoral(int idCli)
    {
        super(idCli);
    }
    public ClientMoral()
    {
        super();
    }

    /**
     * @return the siret
     */
    public long getSiret()
    {
        return siret;
    }

    /**
     * @param siret
     *            the siret to set
     */
    public void setSiret(long siret)
    {
        this.siret = siret;
    }
}
