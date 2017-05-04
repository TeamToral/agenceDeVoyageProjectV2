package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Escale;
import agence.model.Vol;

public class VolDaoSql extends DaoSQL implements VolDao
{
    @Override
    public List<Vol> findAll()
    {
        // Liste des vols que l'on va retourner
        List<Vol> vols = new ArrayList<Vol>();
        // Création d'un objet aeroport pour faire un findbyid;
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();
        EscaleDao escaleDao = new EscaleDaoSql();
        // Connexion à la BDD
        try
        {

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM vol");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Vol
                Vol vol = new Vol(tuple.getInt("idVol"));
                vol.setDateArrivee(tuple.getDate("dateArrivee"));
                vol.setDateDepart(tuple.getDate("dateDepart"));
                vol.setHeureArrivee(tuple.getTime("heureArrivee"));
                vol.setHeureDepart(tuple.getTime("heureDepart"));
                vol.setAeroportArrivee(aeroportDAO
                        .findById(tuple.getInt("idAeroportArrivee")));
                vol.setAeroportDepart(
                        aeroportDAO.findById(tuple.getInt("idAeroportDepart")));
                /*
                 * Recherche des escales
                 */
                List<Escale> escales = escaleDao.findByVol(vol);
                if (escales != null)
                {
                    // liaison avec le vol
                    vol.setEscales(escales);
                }
                // Ajout du nouvel objet vol créé à la liste des vols
                vols.add(vol);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

            // fermeture de la base aeroport
            aeroportDAO.fermetureConnexion();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        // Retourne la liste de tous les aéroports
        return vols;
    }

    public Vol findById(Integer idVol)
    {
        // Déclaration d'un objet vol
        Vol vol = null;
        // Création d'un objet aeroport pour faire un findbyid;
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();

        try
        {

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM vol where idVol=?");
            // Cherche l'idVol voulu dans la BDD
            ps.setInt(1, idVol);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                vol = new Vol(tuple.getInt("idVol"));
                vol.setDateArrivee(tuple.getDate("dateArrivee"));
                vol.setDateDepart(tuple.getDate("dateDepart"));
                vol.setHeureArrivee(tuple.getTime("heureArrivee"));
                vol.setHeureDepart(tuple.getTime("heureDepart"));
                vol.setAeroportArrivee(aeroportDAO
                        .findById(tuple.getInt("idAeroportArrivee")));
                vol.setAeroportDepart(
                        aeroportDAO.findById(tuple.getInt("idAeroportDepart")));
                // fermeture de la base aeroport
                aeroportDAO.fermetureConnexion();
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return vol;
    }

	@Override
	public void create(Vol objet)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vol update(Vol obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Vol obj)
	{
		// TODO Auto-generated method stub
		
	}
}
