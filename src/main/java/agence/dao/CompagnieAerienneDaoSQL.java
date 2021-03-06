package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.CompagnieAerienne;

public class CompagnieAerienneDaoSQL extends DaoSQL
        implements CompagnieAerienneDao
{
    @Override
    public List<CompagnieAerienne> findAll()
    {
        // Liste des compagnies aeriennes que l'on va retourner
        List<CompagnieAerienne> compagniesAeriennes = new ArrayList<CompagnieAerienne>();
        // Connexion à la BDD
        try
        {
            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM compagnie_aerienne");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet compagnieAerienne
                CompagnieAerienne compagnieAerienne = new CompagnieAerienne(
                        tuple.getInt("id"), tuple.getString("nom"));
                // Ajout du nouvel objet compagnieAerienne créé à la liste des
                // compagniesAeriennes
                compagniesAeriennes.add(compagnieAerienne);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de tous les aéroports
        return compagniesAeriennes;
    }

    public CompagnieAerienne findById(Integer id)
    {
        // Déclaration d'un objet compagnieAerienne
        CompagnieAerienne compagnieAerienne = null;

        try
        {
            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM compagnie_aerienne where id=?");
            // Cherche l'idComp recherché dans la BDD
            ps.setInt(1, id);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                compagnieAerienne = new CompagnieAerienne(tuple.getInt("id"),
                        tuple.getString("nom"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return compagnieAerienne;
    }

	@Override
	public void create(CompagnieAerienne objet)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CompagnieAerienne obj)
	{
		// TODO Auto-generated method stub
		
	}

}
