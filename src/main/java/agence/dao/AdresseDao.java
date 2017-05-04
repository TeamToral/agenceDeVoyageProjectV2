/**
 * 
 */
package agence.dao;

import agence.model.Adresse;
import agence.model.Client;

/**
 * Interface qui hérite de Dao afin de préciser quel sera le type de donnée
 * récupéré.
 * En l'occurrence : Adresse
 * De plus, on renseigne le type de la clé : ici, Integer
 * 
 * @author seme
 */
public interface AdresseDao extends Dao<Adresse, Integer>
{
    /**
     * Retourne l'adresse d'un client
     * 
     * @param client
     *            Le client pour lequel on cherche l'adresse
     * @return L'adresse du client
     */
    public Adresse findByClient(Client client);
}
