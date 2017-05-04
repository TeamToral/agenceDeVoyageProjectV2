package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.VilleAeroport;

public class VilleAeroportDaoSql extends DaoSQL implements VilleAeroportDao
{
    @Override
    public List<VilleAeroport> findAll()
    {
        List<VilleAeroport> villeAeroports = new ArrayList<VilleAeroport>();
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();
        VilleDaoSQL villeDAO = new VilleDaoSQL();
        try
        {
            /*
             * Connexion à la BDD
             */

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM ville_aeroport");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Aeroport
                VilleAeroport villeAeroport = new VilleAeroport(
                        tuple.getInt("id"));
                villeAeroport
                        .setVille(villeDAO.findById(tuple.getInt("idVille")));
                villeAeroport.setAeroport(
                        aeroportDAO.findById(tuple.getInt("idAeroport")));
                // Ajout du nouvel objet Aeroport créé à la liste des aéroports
                villeAeroports.add(villeAeroport);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de tous les aéroports
        return villeAeroports;
    }

    @Override
    public VilleAeroport findById(Integer id)
    {
        // Déclaration d'un objet aeroport
        VilleAeroport villeAeroport = null;
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();
        VilleDaoSQL villeDAO = new VilleDaoSQL();

        try
        {

            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM ville_aeroport where id=?");
            // Cherche l'idAero voulu dans la BDD
            ps.setInt(1, id);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                villeAeroport = new VilleAeroport(tuple.getInt("id"));
                villeAeroport
                        .setVille(villeDAO.findById(tuple.getInt("idVille")));
                villeAeroport.setAeroport(
                        aeroportDAO.findById(tuple.getInt("idAeroport")));

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return villeAeroport;
    }

}
