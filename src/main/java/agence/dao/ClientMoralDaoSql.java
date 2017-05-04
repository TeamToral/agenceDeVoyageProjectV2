/**
 * 
 */
package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.ClientMoral;
import agence.model.ClientPhysique;

/**
 * @author Seme
 */
public class ClientMoralDaoSql extends ClientDaoSql
{
    public List<Client> findAll()
    {
        // Liste des clients que l'on va retourner
        List<Client> ListClients = new ArrayList<Client>();
        AdresseDaoSql adresseDAO = new AdresseDaoSql();
        LoginDaoSql loginDAO = new LoginDaoSql();

        try
        {

            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM client WHERE siret IS NOT NULL");

            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Client
                Client objClient = new ClientMoral(tuple.getInt("idClient"));

                objClient.setNom(tuple.getString("nom"));
                objClient.setNumeroTel(tuple.getString("numTel"));
                objClient.setNumeroFax(tuple.getString("numFax"));
                objClient.setEmail(tuple.getString("eMail"));
                ((ClientMoral) objClient).setSiret(tuple.getLong("siret"));

                objClient
                        .setAdresse(adresseDAO.findById(tuple.getInt("idAdd")));
                objClient.setLogin(loginDAO.findById(tuple.getInt("idLog")));

                // Ajout du nouvel objet Client créé à la liste des clients
                ListClients.add(objClient);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les clients
        return ListClients;
    }

    @Override
    public Client findById(Integer idCli)
    {
        // Déclaration d'un objet Client
        Client objClient = null;
        AdresseDaoSql adresseDAO = new AdresseDaoSql();
        LoginDaoSql loginDAO = new LoginDaoSql();

        try
        {
            // Connexion à la BDD
            PreparedStatement ps = connexion.prepareStatement(
                    "SELECT * FROM client WHERE idClient=? AND siret IS NOT NULL");
            // Cherche l'idVill voulu dans la BDD
            ps.setInt(1, idCli);

            // Récupération des résultats de la requête
            ResultSet tuple = ps.executeQuery();

            if (tuple.next())
            {
                objClient = new ClientMoral(tuple.getInt("idClient"));
                objClient.setNom(tuple.getString("nom"));
                objClient.setNumeroTel(tuple.getString("numTel"));
                objClient.setNumeroFax(tuple.getString("numFax"));
                objClient.setEmail(tuple.getString("eMail"));
                ((ClientMoral) objClient).setSiret(tuple.getLong("siret"));

                objClient
                        .setAdresse(adresseDAO.findById(tuple.getInt("idAdd")));
                objClient.setLogin(loginDAO.findById(tuple.getInt("idLog")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return objClient;
    }

	@Override
	public void create(Client objet)
	{
Connection conn = null;
		
		try{
		
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");
        // Cr��er ma requetes d'insertion INSERT INTO
        PreparedStatement requete;
       
        requete = conn
                .prepareStatement("insert into client (nom,numTel,numFax,eMAil,siret,idAdd,idLog)" + " VALUES(?,?,?,?,?,?,?)");
        	requete.setString(1, objet.getNom());
        	requete.setString(2, objet.getNumeroTel());
        	requete.setString(3, objet.getNumeroFax());
        	requete.setString(4, objet.getEmail());
        	requete.setLong(5, ((ClientMoral)objet).getSiret());
        	requete.setInt(6, objet.getAdresse().getIdAdd());
        	requete.setInt(7, objet.getLogin().getIdLog());
        	
        	 requete.executeUpdate();
        
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
	public Client update(Client obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client obj)
	{
		// TODO Auto-generated method stub
		
	}

}
