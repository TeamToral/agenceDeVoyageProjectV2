package agence.dao;

import agence.model.Vol;

/**
 * Contrat que les DAOs de l'objet métier Vol vont devoir respecter Contexte : -
 * BO = Vol - PK = Integer
 * 
 * @author Eric Sultan
 */
public interface VolDao extends Dao<Vol, Integer>
{
}
