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

import agence.model.Adresse;
import agence.model.Client;

/**
 * @author Seme
 */
public class AdresseDaoFile implements AdresseDao
{

    /*
     * (non-Javadoc)
     * @see agence.dao.Dao#findAll()
     */
    @Override
    public List<Adresse> findAll()
    {
        List<Adresse> adresses = new ArrayList<>();
        try
        {
            BufferedReader bReader = new BufferedReader(
                    new FileReader(new File("src/resources/adresses.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    Adresse adresse = new Adresse();
                    adresse.setIdAdd(Integer.parseInt(champs[0]));
                    adresse.setAdresse(champs[1]);
                    adresse.setCodePostal(champs[2]);
                    adresse.setVille(champs[3]);
                    adresse.setPays(champs[4]);
                    adresses.add(adresse);
                }
                else
                {
                    premiereLigne = false;
                }
            }
            bReader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return adresses;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.AdresseDao#findById(java.lang.Integer)
     */
    @Override
    public Adresse findById(Integer idAdd)
    {
        Adresse adresse = null;
        BufferedReader bReader = null;
        try
        {
            bReader = new BufferedReader(
                    new FileReader(new File("src/resources/adresses.csv")));
            String s;
            boolean premiereLigne = true;
            while ((s = bReader.readLine()) != null)
            {
                if (!premiereLigne)
                {
                    String[] champs = s.split(";");
                    if (Integer.parseInt(champs[0]) == idAdd)
                    {
                        adresse = new Adresse();
                        adresse.setIdAdd(Integer.parseInt(champs[0]));
                        adresse.setAdresse(champs[1]);
                        adresse.setCodePostal(champs[2]);
                        adresse.setVille(champs[3]);
                        adresse.setPays(champs[4]);
                        return adresse;
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
        return adresse;
    }

    /*
     * (non-Javadoc)
     * @see agence.dao.AdresseDao#findByClient(agence.model.Client)
     */
    @Override
    public Adresse findByClient(Client client)
    {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public void create(Adresse objet)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adresse update(Adresse obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Adresse obj)
	{
		// TODO Auto-generated method stub
		
	}

}
