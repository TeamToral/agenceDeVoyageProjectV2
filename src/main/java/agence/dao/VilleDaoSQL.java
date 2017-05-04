package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Ville;

public class VilleDaoSQL extends DaoSQL implements VilleDao
{
    @Override
    public List<Ville> findAll()
    {
        // Liste des villes que l'on va retourner
        List<Ville> villes = new ArrayList<Ville>();
        // Connexion à la BDD
        try
        {
            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM ville");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Ville
                Ville ville = new Ville(tuple.getInt("id"),
                        tuple.getString("nom"));
                // Ajout du nouvel objet Ville créé à la liste des villes
                villes.add(ville);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les villes
        return villes;
    }

    public Ville findById(Integer id)
    {
        // Déclaration d'un objet ville
        Ville ville = null;

        try
        {
            // Connexion à la BDD
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM ville where id=?");
            // Cherche l'idVill voulu dans la BDD
            ps.setInt(1, id);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                ville = new Ville(tuple.getInt("id"), tuple.getString("nom"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ville;
    }

}
