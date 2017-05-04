package agence.model;

/**
 * Représente le lien entre un Vol et la Compagnie aérienne
 * 
 * @author Seme
 */
public class CompagnieAerienneVol
{

    /**
     * Identifiant technique du lien
     */
    private int id;
    /**
     * Compagnie aérienne
     */
    private CompagnieAerienne compagnieAerienne;
    /**
     * Vol
     */
    private Vol vol;
    /**
     * Numéro affecté au vol par cette compagnie aérienne
     */
    private String numero;

    /**
     * Ce vol est-il ouvert ou fermé à la réservation ?
     */
    private boolean ouvert;

    /**
     * Constructeur
     * 
     * @param numero
     *            Numéro du vol attribué par la compagnie
     * @param ouvert
     *            Est-il ouvert à la réservation ?
     */
    public CompagnieAerienneVol(String numero, boolean ouvert)
    {
        this.numero = numero;
        this.ouvert = ouvert;

    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the compagnieAerienne
     */
    public CompagnieAerienne getCompagnieAerienne()
    {
        return compagnieAerienne;
    }

    /**
     * @param compagnieAerienne
     *            the compagnieAerienne to set
     */
    public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne)
    {
        this.compagnieAerienne = compagnieAerienne;
    }

    /**
     * @return the vol
     */
    public Vol getVol()
    {
        return vol;
    }

    /**
     * @param vol
     *            the vol to set
     */
    public void setVol(Vol vol)
    {
        this.vol = vol;
    }

    /**
     * @return the numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * @param numero
     *            the numero to set
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * @return the ouvert
     */
    public boolean isOuvert()
    {
        return ouvert;
    }

    /**
     * @param ouvert
     *            the ouvert to set
     */
    public void setOuvert(boolean ouvert)
    {
        this.ouvert = ouvert;
    }

    @Override
    public String toString()
    {
        return "CompagnieAerienneVol [id=" + id + ", compagnieAerienne="
                + compagnieAerienne + ", vol=" + vol + ", numero=" + numero
                + ", ouvert=" + ouvert + "]";
    }

}
