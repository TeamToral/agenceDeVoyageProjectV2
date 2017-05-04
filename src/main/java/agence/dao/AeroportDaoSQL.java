package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
            // 4. Execution de la requ�te
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

	@Override
	public void create(Aeroport aeroport)
	{
		Connection conn = null;
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");
            
            // Cr�er ma requ�te d'insertion INSERT INTO
            PreparedStatement requete;
            String sql = "insert into aeroport (nom)" + " VALUES(?)";
                requete = conn
                        .prepareStatement(sql, new String[] { "id" }/*Statement.RETURN_GENERATED_KEYS*/);


            
            requete.setString(1, aeroport.getNom());
           

            // je l'ex�cute
            
           int i = requete.executeUpdate();
            if (i > 0)
            { 
            	ResultSet generatedKeys = requete.getGeneratedKeys();
            	if (generatedKeys.next())
            	{
            		aeroport.setIdAer(generatedKeys.getInt(1));
            	}
            }
            

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        	
        }


	@Override
	public Aeroport update(Aeroport aeroport)
	{
		Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn
                    .prepareStatement("update aeroport set aeroport=?,nom=? where idAer = ?");

           
            ps.setLong(5, aeroport.getIdAer());
            
            ps.setString(1, aeroport.getNom());
            

            ps.executeUpdate();

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        
		return aeroport;
	}

	@Override
	public void delete(Aeroport aeroport)
	{
		Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

            PreparedStatement ps = conn.prepareStatement("delete from aeroport where idAer = ?");
            ps.setLong(1, aeroport.getIdAer());

            ps.executeUpdate();

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
		
	}

}
