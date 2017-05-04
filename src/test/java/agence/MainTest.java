package agence;

import agence.dao.AdresseDaoSql;
import agence.dao.ClientMoralDaoSql;
import agence.dao.ClientPhysiqueDaoSql;
import agence.dao.LoginDaoSql;
import agence.model.Adresse;
import agence.model.ClientMoral;
import agence.model.ClientPhysique;
import agence.model.Login;

public class MainTest {

	public static void main(String[] args) {

		// Instanciation des DaoSql

		AdresseDaoSql adresseDaoSql = new AdresseDaoSql();
		ClientPhysiqueDaoSql clientPhysiqueDaoSql = new ClientPhysiqueDaoSql();
		ClientMoralDaoSql clientMoralDaoSql = new ClientMoralDaoSql();
		LoginDaoSql loginDaoSql = new LoginDaoSql();

		// Creation d'une adresse

		Adresse adresse = new Adresse();
		adresse.setAdresse("3 rue des orangers");
		adresse.setCodePostal("33000");
		adresse.setVille("Bordeaux");
		adresse.setPays("FRANCE");

		// Creation d'un login

		Login login = new Login();
		login.setLogin("leLogin@yahooooo.fr");
		login.setMotDePasse("mdp");
		login.setAdmin(true);

		// Creation d'un clientPhysique

		ClientPhysique clientPhysique = new ClientPhysique();

		clientPhysique.setNom("Mercury");
		clientPhysique.setPrenom("Freddie");
		clientPhysique.setNumeroTel("0685989636");
		clientPhysique.setNumeroFax("0687898636");
		clientPhysique.setEmail("Freddie.Mercury@dieu-vivant.com");
		clientPhysique.setAdresse(adresse);
		clientPhysique.setLogin(login);
		// Creation d'un client Moral

		ClientMoral clientMoral = new ClientMoral();
		clientMoral.setNom("Mercury");
		clientMoral.setSiret(0124);
		clientMoral.setNumeroTel("0685989636");
		clientMoral.setNumeroFax("0687898636");
		clientMoral.setEmail("Freddie.Mercury@dieu-vivant.com");
		clientMoral.setAdresse(adresse);
		clientMoral.setLogin(login);
		
		loginDaoSql.create(login);
		clientPhysiqueDaoSql.create(clientPhysique);
		clientMoralDaoSql.create(clientMoral);

	}
}
