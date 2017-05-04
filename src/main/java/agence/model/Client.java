/**
 * 
 */
package agence.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente l'objet métier client
 * 
 * @author seme
 */
public abstract class Client
{
    /**
     * Identifiant technique du client
     */
    private int idCli;
    /**
     * Nom de famille
     */
    private String nom;
    /**
     * Numéro de téléhpone
     */
    private String numeroTel;
    /**
     * Numéro de fax
     */
    private String numeroFax;
    /**
     * Adresse email
     */
    private String email;

    /**
     * Réservations du client
     */
    private List<Reservation> listeReservations;
    /**
     * Adresse du client
     */
    private Adresse adresse;
    /**
     * Login du client
     */
    private Login login;

    public Client()
    {
        this.listeReservations = new ArrayList<>();
    }

    public Client(int idCli)
    {

        this();
        this.idCli = idCli;
    }

    /**
     * @return the idCli
     */
    public int getIdCli()
    {
        return idCli;
    }

    /**
     * @param idCli
     *            the idCli to set
     */
    public void setIdCli(int idCli)
    {
        this.idCli = idCli;
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
     * @return the numeroTel
     */
    public String getNumeroTel()
    {
        return numeroTel;
    }

    /**
     * @param numeroTel
     *            the numeroTel to set
     */
    public void setNumeroTel(String numeroTel)
    {
        this.numeroTel = numeroTel;
    }

    /**
     * @return the numeroFax
     */
    public String getNumeroFax()
    {
        return numeroFax;
    }

    /**
     * @param numeroFax
     *            the numeroFax to set
     */
    public void setNumeroFax(String numeroFax)
    {
        this.numeroFax = numeroFax;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the listeReservations
     */
    public List<Reservation> getListeReservations()
    {
        return listeReservations;
    }

    /**
     * @param listeReservations
     *            the listeReservations to set
     */
    public void setListeReservations(List<Reservation> listeReservations)
    {
        this.listeReservations = listeReservations;
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

    /**
     * @return the login
     */
    public Login getLogin()
    {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(Login login)
    {
        this.login = login;
    }

    public String toString()
    {
        String reponse = "Le Client : " + this.nom + ", " + adresse.toString();
        if (listeReservations.size() > 0)
        {
            reponse += " a effectué la/les reservation(s) : \n";
            for (int i = 0; i < listeReservations.size(); i++)
            {
                reponse += "\n" + this.listeReservations.get(i).getNumero();
            }
        }

        return reponse;
    }

}
