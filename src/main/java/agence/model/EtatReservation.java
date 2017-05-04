package agence.model;

/**
 * Etat de la réservation. Peut prendre deux valeurs
 * - annulee
 * - confirmee
 * 
 * @author Seme
 */
public enum EtatReservation
{
    ANNULEE("annulee"), CONFIRMEE("confirmee");

    /**
     * Label du type énuméré
     */
    private final String label;

    private EtatReservation(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    /**
     * Permet d'utiliser les labels correspondants aux valeurs constantes
     * 
     * @param name
     *            Le label à trouver
     * @return La constante correspondante au label
     */
    public static EtatReservation permissiveValueOf(String name)
    {
        for (EtatReservation e : values())
        {
            if (e.getLabel().equals(name))
            {
                return e;
            }
        }
        return null;
    }

}
