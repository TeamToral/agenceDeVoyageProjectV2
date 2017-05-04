package agence.dao;

import java.util.List;

/**
 * Contrat que tous les DAOs devront respecter.
 * 
 * @author seme
 * @param <T>
 * @param <PK>
 */
public interface Dao<T, PK>
{
    /**
     * Retourne la liste de tous les objets métiers de la source de données
     * 
     * @return Liste des objets métiers de la source de données
     */
    List<T> findAll();

    /**
     * Retourne un objet métier en fonction de sa clé primaire
     * 
     * @param id
     *            Clé primaire
     * @return L'objet métier trouvé
     */
    T findById(PK id);

}
