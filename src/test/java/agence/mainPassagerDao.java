package agence;

import java.util.List;

import agence.dao.PassagerDaoSql;
import agence.model.Adresse;
import agence.model.Passager;

public class mainPassagerDao
{
	public static void main(String[] args)
    {
		PassagerDaoSql passagerDao = new PassagerDaoSql();
		
		List<Passager> listePassager = passagerDao.findAll();
		Passager passager = passagerDao.findById(22);
		
		System.out.println(listePassager);
		System.out.println(passager);
		
		Passager test = new Passager();
		test.setNom("Reignoux");
		test.setPrenom("Alexis");
		test.setIdPas(56);
		
		Adresse adresseTest = new Adresse();
		adresseTest.setAdresse("13 chemin du Saint Sacrement");
		adresseTest.setCodePostal("78490");
		adresseTest.setVille("Bazoches sur Guyonne");
		adresseTest.setPays("France");
		
		test.setAdresse(adresseTest);
		
		passagerDao.create(test);
		
		test.setNom("Schouwey");
		passager = passagerDao.update(test);
		
		//passagerDao.delete(passager);
    }
}
