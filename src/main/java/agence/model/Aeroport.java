package agence.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente l'objet métier Aéroport
 */
public class Aeroport
{

    /**
     * id technique de l'aéroport
     */
    private int idAer;

    /**
     * Nom de l'aéroport
     */
    private String nom;

    /**
     * Liste des villes désservies par l'aéroport
     */
    private List<Ville> villes = new ArrayList<Ville>();

    /**
     * Constructeur
     * 
     * @param idAer
     *            Identifiant technique de l'aéroport
     * @param nom
     *            Nom de l'aéroport
     */
    public Aeroport(int idAer, String nom)
    {
        this.nom = nom;
        this.idAer = idAer;
    }
    
    public Aeroport()
    {
       
    }


    /**
     * Ajout d'une ville existante à la liste des villes desservies par
     * l'aéroport
     * 
     * @param ville
     *            Ville à ajouter
     */
    public void ajouterVille(Ville ville)
    {
        this.villes.add(ville); // ajout d'une ville déjà existante
    }

    /**
     * @return the idAer
     */
    public int getIdAer()
    {
        return idAer;
    }

    /**
     * @param idAer
     *            the idAer to set
     */
    public void setIdAer(int idAer)
    {
        this.idAer = idAer;
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
     * @return the villes
     */
    public List<Ville> getVilles()
    {
        return villes;
    }

    /**
     * @param villes
     *            the villes to set
     */
    public void setVilles(List<Ville> villes)
    {
        this.villes = villes;
    }

    @Override
    public String toString()
    {
        return "Aeroport [idAer=" + idAer + ", nom=" + nom + ", villes="
                + villes + "]";
    }

}
