/**
 * 
 */
package agence.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Passager;

/**
 * @author Seme
 */
public class PassagerDaoFile implements PassagerDao
{

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Passager> findAll()
    {
        BufferedReader bReader = null;
        AdresseDaoFile adresseDao = new AdresseDaoFile();
        List<Passager> passagers = new ArrayList<>();
        try
        {
            bReader = new BufferedReader(
                    new FileReader(new File("src/resources/passagers.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    Passager passager = new Passager(
                            Integer.parseInt(champs[0]));
                    passager.setNom(champs[1]);
                    passager.setPrenom(champs[2]);
                    passager.setAdresse(
                            adresseDao.findById(Integer.parseInt(champs[3])));
                    passagers.add(passager);
                }
                else
                {
                    premiereLigne = false;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (bReader != null)
            {
                try
                {
                    bReader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return passagers;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findById(java.lang.Object)
     */
    @Override
    public Passager findById(Integer id)
    {
        BufferedReader bReader = null;
        AdresseDaoFile adresseDao = new AdresseDaoFile();
        Passager passager = null;
        try
        {
            bReader = new BufferedReader(
                    new FileReader(new File("src/resources/passagers.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    if (Integer.parseInt(champs[0]) == id)
                    {
                        passager = new Passager(Integer.parseInt(champs[0]));
                        passager.setNom(champs[1]);
                        passager.setPrenom(champs[2]);
                        passager.setAdresse(adresseDao
                                .findById(Integer.parseInt(champs[3])));
                        return passager;
                    }
                }
                else
                {
                    premiereLigne = false;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (bReader != null)
            {
                try
                {
                    bReader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return passager;
    }

	@Override
	public void create(Passager objet)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Passager update(Passager obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Passager obj)
	{
		// TODO Auto-generated method stub
		
	}

}
