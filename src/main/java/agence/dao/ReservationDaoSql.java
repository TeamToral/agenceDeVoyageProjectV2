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
import agence.model.Client;
import agence.model.EtatReservation;
import agence.model.Passager;
import agence.model.Reservation;
import agence.dao.ReservationDao;

/**
 * @author Seme
 */
public class ReservationDaoSql extends DaoSQL implements ReservationDao {
	PassagerDao passagerDao = new PassagerDaoSql();
	ClientDao clientDao;
	VolDao volDao = new VolDaoSql();

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findAll()
	 */
	@Override
	public List<Reservation> findAll() {
		// Initialiser ma liste d'objets métier
		List<Reservation> listeBO = new ArrayList<>();
		try {
			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM reservation");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				Reservation bo = new Reservation();
				// appel des mutateurs
				bo.setIdRes(resultSet.getInt("idResa"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setDate(resultSet.getDate("dateReservation"));
				bo.setNumero(resultSet.getString("numero"));
				bo.setEtat(EtatReservation.permissiveValueOf(resultSet.getString("etat")));
				bo.setPassager(passagerDao.findById(resultSet.getInt("idPassager")));
				/*
				 * Récupération du client
				 */
				clientDao = new ClientMoralDaoSql();
				Client client = clientDao.findById(resultSet.getInt("idClient"));
				// si pas de résultat, c'est un client personne physique
				if (client == null) {
					clientDao = new ClientPhysiqueDaoSql();
					client = clientDao.findById(resultSet.getInt("idClient"));
				}
				// liaison avec le client
				bo.setClient(client);

				// liaison avec le vol
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));

				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
				listeBO.add(bo);
			}
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des passagers de la BDDonnéys
		return listeBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public Reservation findById(Integer id) {
		// Initialiser mon bo
		Reservation bo = null;
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM reservation WHERE idResa = " + id);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				bo = new Reservation();
				// appel des mutateurs
				bo.setIdRes(resultSet.getInt("idResa"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setDate(resultSet.getDate("dateReservation"));
				bo.setNumero(resultSet.getString("numero"));
				bo.setEtat(EtatReservation.permissiveValueOf(resultSet.getString("etat")));
				// liaison avec le passager
				bo.setPassager(passagerDao.findById(resultSet.getInt("idPassager")));
				/*
				 * Récupération du client
				 */
				clientDao = new ClientMoralDaoSql();
				Client client = clientDao.findById(resultSet.getInt("idClient"));
				// si pas de résultat, c'est un client personne physique
				if (client == null) {
					clientDao = new ClientPhysiqueDaoSql();
					client = clientDao.findById(resultSet.getInt("idClient"));
				}
				// liaison avec le client
				bo.setClient(client);

				// liaison avec le vol
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));
			}

		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// catch (ParseException e)
		// {
		// System.err.println("Impossible de parser la date.");
		// e.printStackTrace();
		// }
		// Je retourne l'objet métier
		return bo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.ReservationDao#findByPassager(agence.model.Passager)
	 */
	@Override
	public List<Reservation> findByPassager(Passager passager) {
		// Initialiser ma liste d'objets métier
		List<Reservation> listeBO = new ArrayList<>();
		try {

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM reservation WHERE idPassager = " + passager.getIdPas());

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				Reservation bo = new Reservation();
				// appel des mutateurs
				bo.setIdRes(resultSet.getInt("idResa"));
				bo.setDate(resultSet.getDate("dateReservation"));
				bo.setNumero(resultSet.getString("numero"));
				bo.setEtat(EtatReservation.permissiveValueOf(resultSet.getString("etat")));
				bo.setPassager(passager);
				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
				listeBO.add(bo);
			}

		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des passagers de la BDDonnéys
		return listeBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.ReservationDao#findByClient(agence.model.Client)
	 */
	@Override
	public List<Reservation> findByClient(Client client) {
		// Initialiser ma liste d'objets métier
		List<Reservation> listeBO = new ArrayList<>();
		PassagerDao passagerDao = new PassagerDaoSql();
		VolDao volDao = new VolDaoSql();
		try {

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM reservation WHERE idClient = " + client.getIdCli());

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				Reservation bo = new Reservation();
				// appel des mutateurs
				bo.setIdRes(resultSet.getInt("idResa"));
				bo.setDate(resultSet.getDate("dateReservation"));
				bo.setNumero(resultSet.getString("numero"));
				bo.setEtat(EtatReservation.permissiveValueOf(resultSet.getString("etat")));
				bo.setClient(client);
				// on trouve le passager
				bo.setPassager(passagerDao.findById(resultSet.getInt("idPassager")));
				// on trouve le vol
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));
				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
				listeBO.add(bo);
			}

		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des objets métiers de la BDDonnéys
		return listeBO;
	}

	@Override
	public void create(Reservation reservation) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");
			// Créer ma requête d'insertion INSERT INTO
			PreparedStatement requete;
			// je teste si l'élève est lié à un vol, client, passager
			if (reservation.getPassager() == null) {
				requete = conn.prepareStatement("insert into reservation (dateReservation, numero)" + " VALUES(?,?)");

			} else {
				requete = conn.prepareStatement(
						"insert into reservation (dateReservation, numero, idPassager, idClient)" + " VALUES(?,?,?,?)");
				requete.setInt(3, reservation.getPassager().getIdPas());
				requete.setInt(4, reservation.getClient().getIdCli());
			}

			requete.setDate(1, reservation.getDate());
			requete.setString(2, reservation.getNumero());

			// je l'exécute
			requete.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see formation.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public Reservation update(Reservation reservation) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

			PreparedStatement ps = conn
					.prepareStatement("update reservation set dateReservation=?,numero=? where idResa = ?");

			ps.setInt(3, reservation.getIdRes());

			ps.setDate(1, reservation.getDate());
			ps.setString(2, reservation.getNumero());

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return reservation;
	}

	@Override
	public void delete(Reservation reservation) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user", "password");

			PreparedStatement ps = conn.prepareStatement("delete from reservation where idResa = ?");
			ps.setInt(1, reservation.getIdRes());

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
