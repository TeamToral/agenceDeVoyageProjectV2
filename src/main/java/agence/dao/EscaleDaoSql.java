package agence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Escale;
import agence.model.Vol;

public class EscaleDaoSql extends DaoSQL implements EscaleDao
{
    @Override
    public List<Escale> findAll()
    {
        // Liste des escales que l'on va retourner
        List<Escale> escales = new ArrayList<Escale>();
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();
        VolDaoSql volDAO = new VolDaoSql();
        try
        {
            // connexion
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM escale");
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet escale
                Escale escale = new Escale(tuple.getInt("idEscale"));
                escale.setDateArrivee(tuple.getDate("dateArrivee"));
                escale.setDateDepart(tuple.getDate("dateDepart"));
                escale.setHeureArrivee(tuple.getTime("heureArrivee"));
                escale.setHeureDepart(tuple.getTime("heureDepart"));
                // ajout des id Adress
                escale.setVol(volDAO.findById(tuple.getInt("idVol")));
                // ajout des aeroports
                escale.setAeoroport(
                        aeroportDAO.findById(tuple.getInt("idAeroport")));
                // Ajout du nouvel objet Aeroport créé à la liste des aéroports
                escales.add(escale);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats
              // ajout des vols;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les escales
        return escales;
    }

    public Escale findById(Integer idEscale)
    {
        Escale escale = new Escale();
        AeroportDaoSQL aeroport = new AeroportDaoSQL();
        VolDaoSql vol = new VolDaoSql();

        try
        {

            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM escale where idEscale=?");
            // Cherche l'idVol voulu dans la BDD
            ps.setInt(1, idEscale);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                escale.setIdEscale(tuple.getInt("idEscale"));
                escale.setDateArrivee(tuple.getDate("dateArrivee"));
                escale.setDateDepart(tuple.getDate("dateDepart"));
                escale.setHeureArrivee(tuple.getTime("heureArrivee"));
                escale.setHeureDepart(tuple.getTime("heureDepart"));
                escale.setVol(vol.findById(tuple.getInt("idVol")));
                escale.setAeoroport(
                        aeroport.findById(tuple.getInt("idAeroport")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return escale;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.EscaleDao#findByVol(agence.model.Vol)
     */
    @Override
    public List<Escale> findByVol(Vol vol)
    {
        // Liste des escales que l'on va retourner
        List<Escale> escales = new ArrayList<Escale>();
        AeroportDaoSQL aeroportDAO = new AeroportDaoSQL();
        try
        {
            // connexion
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * " + "FROM escale e "
                            + "INNER JOIN vol v ON e.idVol = v.idVol "
                            + "WHERE v.idVol = ?");
            ps.setInt(1, vol.getIdVol());
            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet escale
                Escale escale = new Escale(tuple.getInt("idEscale"));
                escale.setDateArrivee(tuple.getDate("dateArrivee"));
                escale.setDateDepart(tuple.getDate("dateDepart"));
                escale.setHeureArrivee(tuple.getTime("heureArrivee"));
                escale.setHeureDepart(tuple.getTime("heureDepart"));
                // ajout des id Adress
                escale.setVol(vol);
                // ajout des aeroports
                escale.setAeoroport(
                        aeroportDAO.findById(tuple.getInt("idAeroport")));
                // Ajout du nouvel objet escale créé à la liste des escales
                escales.add(escale);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats
              // ajout des vols;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les escales
        return escales;
    }

}
