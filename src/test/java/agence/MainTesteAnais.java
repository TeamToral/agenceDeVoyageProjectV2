package agence;

import agence.dao.AdresseDaoSql;
import agence.dao.AeroportDaoSQL;
import agence.dao.LoginDaoSql;
import agence.model.Adresse;
import agence.model.Aeroport;

public class MainTesteAnais {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Adresse adresseTemp = new Adresse();
		adresseTemp.setAdresse(" 11 square de la sarcelle ");
		adresseTemp.setCodePostal("64140");
		adresseTemp.setVille("Pau");
		adresseTemp.setPays("France");

		AdresseDaoSql adresseDaoSql = new AdresseDaoSql();
		adresseDaoSql.create(adresseTemp);

		// System.out.println(adresse);
		adresseTemp.setVille("moncul");
		adresseDaoSql.update(adresseTemp);

		Aeroport aeroportTemp = new Aeroport();
		aeroportTemp.setNom(" CDG ");

		AeroportDaoSQL aeroportDaoSql = new AeroportDaoSQL();
		aeroportDaoSql.create(aeroportTemp);

		System.out.println(aeroportTemp);
		aeroportTemp.setNom("bibi");
		aeroportDaoSql.update(aeroportTemp);

	}
}
