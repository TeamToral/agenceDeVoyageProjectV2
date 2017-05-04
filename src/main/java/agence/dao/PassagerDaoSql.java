/**
 * 
 */
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
import agence.model.Passager;
import agence.model.Reservation;

/**
 * @author Seme
 */
public class PassagerDaoSql extends DaoSQL implements PassagerDao
{
	AdresseDao adresseDao = new AdresseDaoSql();

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findAll()
	 */
	@Override
	public List<Passager> findAll()
	{
		// Initialiser ma liste de passagers
		List<Passager> listePassagers = new ArrayList<>();
		try
		{
			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM passager");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next())
			{
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet passager
				Passager passager = new Passager();
				// appel des mutateurs
				passager.setIdPas(resultSet.getInt("idPassager"));
				passager.setNom(resultSet.getString("nom"));
				passager.setPrenom(resultSet.getString("prenom"));
				passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
				// j'ajoute l'objet passager ainsi muté à la liste des
				// passagers
				listePassagers.add(passager);
			}

		} catch (SQLException e)
		{
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des passagers de la BDDonnéys
		return listePassagers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public Passager findById(Integer id)
	{
		// Initialiser mon passager
		Passager passager = null;
		try
		{
			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM passager WHERE idPassager = " + id);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next())
			{
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				passager = new Passager();
				// appel des mutateurs
				passager.setIdPas(resultSet.getInt("idPassager"));
				passager.setNom(resultSet.getString("nom"));
				passager.setPrenom(resultSet.getString("prenom"));
				passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
			}

		} catch (SQLException e)
		{
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne l'objet métier
		return passager;
	}

	@Override
	public void create(Passager passager)
	{
		
		
		try
		{
			AdresseDaoSql adresseDao = new AdresseDaoSql();
			PreparedStatement requete;
			
			Adresse adresse = new Adresse();
			adresse = adresseDao.findById(passager.getAdresse().getIdAdd());
						
			// On prepare la requete de creation
			requete = connexion.prepareStatement("insert into passager (nom,prenom,idAdd)" + " VALUES(?,?,?)", new String[] { "id" }/*Statement.RETURN_GENERATED_KEYS*/);

			
			requete.setString(1, passager.getNom());
			requete.setString(2, passager.getPrenom());
			// Je convertis une java.util.Date en java.sql.Date
			
			try
			{
				String temp = adresse.getPays();
			}
			catch (NullPointerException e)
			{
				adresseDao.create(passager.getAdresse());
			} finally
			{
				requete.setInt(3, passager.getAdresse().getIdAdd());
			}
			


			// je l'exécute et je teste si elle a �tait effectu�e
			if (requete.executeUpdate() > 0)
			{
				ResultSet generatedKeys = requete.getGeneratedKeys();
				if (generatedKeys.next())
				{
					passager.setIdPas(generatedKeys.getInt(1));
				}
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			e.printStackTrace();
		} finally
		{


		}

	}

	@Override
	public Passager update(Passager passager)
	{
		
		try
		{
			PreparedStatement ps = connexion.prepareStatement("update passager set nom=?,prenom=? where idPassager = ?");

			ps.setLong(3, passager.getIdPas());

			ps.setString(1, passager.getNom());
			ps.setString(2, passager.getPrenom());
			//ps.setInt(3, passager.getAdresse().getIdAdd());
			
			ps.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{

		}

		return passager;
	}

	@Override
	public void delete(Passager passager)
	{
		try
        {
			ReservationDaoSql rds = new ReservationDaoSql();
			List <Reservation> listeReservation = new ArrayList <>();
			
			listeReservation.addAll(rds.findByPassager(passager));
			
			PreparedStatement ps = null;
			
			
			for ( Reservation reservation : listeReservation )
			{
				ps = connexion.prepareStatement("delete from reservation where idResa = ?");
				ps.setLong(1, reservation.getIdRes());
				ps.executeQuery();
			}		 
			
            ps = connexion.prepareStatement("delete from passager where idPassager = ?");
            ps.setLong(1, passager.getIdPas());

            ps.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {

        }

	}

}
