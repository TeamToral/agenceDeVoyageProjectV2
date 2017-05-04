package agence.dao;

import java.util.List;

import agence.model.Escale;
import agence.model.Vol;

public interface EscaleDao extends Dao<Escale, Integer>
{
    /**
     * Récupère la liste des escales d'un vol
     * 
     * @param vol
     *            Le vol pour lequel on cherche ses escales
     * @return La liste des escales
     */
    public List<Escale> findByVol(Vol vol);
}
