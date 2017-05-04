package agence;

import agence.dao.AdresseDaoSql;
import agence.dao.AeroportDaoSQL;
import agence.dao.LoginDaoSql;
import agence.model.Adresse;
import agence.model.Aeroport;

public class MainTesteAnais {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Adresse adresse = new Adresse();
		adresse.setAdresse(" 11 square de la sarcelle ");
		adresse.setCodePostal("64140");
		adresse.setVille("Pau");
		adresse.setPays("France");

		AdresseDaoSql adresseDaoSql = new AdresseDaoSql();
		adresseDaoSql.create(adresse);

		// System.out.println(adresse);
		adresse.setVille("moncul");
		adresseDaoSql.update(adresse);

		Aeroport aeroport = new Aeroport();
		aeroport.setNom(" CDG ");

		AeroportDaoSQL aeroportDaoSql = new AeroportDaoSQL();
		aeroportDaoSql.create(aeroport);

		System.out.println(aeroport);
		aeroport.setNom("bibi");
		aeroportDaoSql.update(aeroport);

	}
}
