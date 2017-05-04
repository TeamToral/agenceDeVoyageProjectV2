package agence.dao;

import agence.model.Aeroport;

/**
 * Contrat que les DAOs de l'objet métier Aeroport vont devoir respecter
 * Contexte :
 * - BO = Aeroport
 * - PK = Long
 * 
 * @author Eric Sultan
 */
public interface AeroportDao extends Dao<Aeroport, Integer>
{
}
