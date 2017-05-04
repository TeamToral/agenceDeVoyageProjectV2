/**
 * 
 */
package agence.model;

/**
 * Représente un compte utilisateur créé pur un client
 * 
 * @author seme
 */
public class Login
{

    /**
     * Identifiant technique du compte
     */
    private int idLog;
    /**
     * Login choisi par le client.
     * Peut être une adresse email ou un pseudo
     */
    private String login;
    /**
     * Mot de passe
     */
    private String motDePasse;
    /**
     * Est-il administrateur ?
     */
    private boolean admin;

    /**
     * Constructeur par défaut
     */
    public Login()
    {

    }

    /**
     * Constructeur
     * 
     * @param idLog
     *            Identifiant technique du compte login
     */
    public Login(int idLog)
    {
        this();
        this.idLog = idLog;
    }

    /**
     * @return the idLog
     */
    public int getIdLog()
    {
        return idLog;
    }

    /**
     * @param idLog
     *            the idLog to set
     */
    public void setIdLog(int idLog)
    {
        this.idLog = idLog;
    }

    /**
     * @return the login
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login)
    {
        this.login = login;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse()
    {
        return motDePasse;
    }

    /**
     * @param motDePasse
     *            the motDePasse to set
     */
    public void setMotDePasse(String motDePasse)
    {
        this.motDePasse = motDePasse;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin()
    {
        return admin;
    }

    /**
     * @param admin
     *            the admin to set
     */
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }

    @Override
    public String toString()
    {
        return "Login [idLog=" + idLog + ", Login=" + login + ", motDePasse="
                + motDePasse + ", admin=" + admin + "]";
    }

}
