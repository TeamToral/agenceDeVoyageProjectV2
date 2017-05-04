package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Adresse;
import agence.model.Client;

public class AdresseDaoSql extends DaoSQL implements AdresseDao
{

    @Override
    public List<Adresse> findAll()
    {
        // Liste des clients que l'on va retourner
        List<Adresse> listeAdresses = new ArrayList<Adresse>();

        try
        {

            /*
             * Connexion à la BDD
             */
            PreparedStatement ps = connexion
                    .prepareStatement("SELECT * FROM adresse");

            // 4. Execution de la requête
            ResultSet tuple = ps.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (tuple.next())
            {
                // Creation d'un objet Client
                Adresse objAdresse = new Adresse(tuple.getInt("idAdd"));

                objAdresse.setAdresse(tuple.getString("adresse"));
                objAdresse.setCodePostal(tuple.getString("codePostal"));
                objAdresse.setVille(tuple.getString("ville"));
                objAdresse.setPays(tuple.getString("pays"));

                // Ajout du nouvel objet Client créé à la liste des clients
                listeAdresses.add(objAdresse);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de toutes les clients
        return listeAdresses;
    }

    @Override
    public Adresse findById(Integer idAdd)
    {
        // Initialiser ma liste d'adresses
        Adresse adresse = null;
        try
        {
            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM adresse WHERE idAdd = " + idAdd);

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet adresse
                adresse = new Adresse();
                // appel des mutateurs
                adresse.setIdAdd(resultSet.getInt("idAdd"));
                adresse.setAdresse(resultSet.getString("adresse"));
                adresse.setCodePostal(resultSet.getString("codePostal"));
                adresse.setVille(resultSet.getString("ville"));
                adresse.setPays(resultSet.getString("pays"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne l'adresse
        return adresse;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.AdresseDao#findByClient(agence.model.Client)
     */
    @Override
    public Adresse findByClient(Client client)
    {
        // Initialiser mon objet métier
        Adresse adresse = null;
        try
        {
            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement
                    .executeQuery("SELECT a.* " + "FROM adresse a "
                            + "INNER JOIN client c ON a.idAdd = c.idAdd "
                            + "WHERE idClient = " + client.getIdCli());

            /*
             * Etape 4 : Parcours des résultats
             */
            if (resultSet.next())
            {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier correspondant
                adresse = new Adresse();
                // appel des mutateurs
                adresse.setIdAdd(resultSet.getInt("idAdd"));
                adresse.setAdresse(resultSet.getString("adresse"));
                adresse.setCodePostal(resultSet.getString("codePostal"));
                adresse.setVille(resultSet.getString("ville"));
                adresse.setPays(resultSet.getString("pays"));
                // Je crée le lien entre le client et son adresse
                client.setAdresse(adresse);
            }

        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne l'adresse
        return adresse;
    }

	@Override
	public void create(Adresse adresse)
    {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "");
            
            // Cr�er ma requ�te d'insertion INSERT INTO
            PreparedStatement requete;
            
                requete = conn
                        .prepareStatement("insert into adresse (adresse, codePostal, ville, pays)" + " VALUES(?,?,?,?)");


            
            requete.setString(1, adresse.getAdresse());
            requete.setString(2, adresse.getCodePostal());
            requete.setString(3, adresse.getVille());
            requete.setString(4, adresse.getPays());
           

            // je l'ex�cute
            
           int i = requete.executeUpdate();
            if (i > 0)
            { 
            	ResultSet generatedKeys = requete.getGeneratedKeys();
            	if (generatedKeys.next())
            	{
            		adresse.setIdAdd(generatedKeys.getInt(1));
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
	public Adresse update(Adresse adresse)
	{
		Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Drive");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "");

            PreparedStatement ps = conn
                    .prepareStatement("update adresse set adresse=?,codePostal=?,ville=?,pays=? where idAdd = ?");

           
            ps.setLong(5, adresse.getIdAdd());
            
            ps.setString(1, adresse.getAdresse());
            ps.setString(2, adresse.getCodePostal());
            ps.setString(3, adresse.getVille());
            ps.setString(4, adresse.getPays());

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
        
		return adresse;
	}

	@Override
	public void delete(Adresse adresse)
	{
		Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "");

            PreparedStatement ps = conn.prepareStatement("delete from adresse where id = ?");
            ps.setLong(1, adresse.getIdAdd());

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
