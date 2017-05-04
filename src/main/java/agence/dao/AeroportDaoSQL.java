package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Aeroport;

public class AeroportDaoSQL extends DaoSQL implements AeroportDao
{
    public List<Aeroport> findAll()
    {
        // Liste des aéroports que l'on va retourner
        List<Aeroport> aeroports = new ArrayList<Aeroport>();
        try
        {
            /*
             * Connexion à la BDD
             */

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM aeroport");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Aeroport
                Aeroport aeroport = new Aeroport(tuple.getInt("idAero"),
                        tuple.getString("nom"));
                // Ajout du nouvel objet Aeroport créé à la liste des aéroports
                aeroports.add(aeroport);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de tous les aéroports
        return aeroports;
    }

    public Aeroport findById(Integer idAero)
    {
        // Déclaration d'un objet aeroport
        Aeroport aeroport = null;

        try
        {

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM aeroport where idAero=?");
            // Cherche l'idAero voulu dans la BDD
            ps.setInt(1, idAero);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                aeroport = new Aeroport(tuple.getInt("idAero"),
                        tuple.getString("nom"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return aeroport;
    }

}
