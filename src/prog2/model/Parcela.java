package prog2.model;

/**
 * Classe que representa una parcel·la dins del camping, heretant de la classe base Allotjament.
 * Aquesta classe modela els espais destinats a caravanes o tendes amb característiques específiques.
 */
public class Parcela extends Allotjament {

    // Atributs específics de la parcel·la
    private float mida;               // Mida de la parcel·la en metres quadrats
    private boolean connexioElectrica; // Indica si té connexió elèctrica disponible

    /**
     * Constructor de la classe Parcela
     * @param nom_ Nom de la parcel·la
     * @param idAllotjament Identificador únic
     * @param estatAllotjament Estat actual (obert/tancat)
     * @param estatIluminacio Estat de la il·luminació
     * @param mida Mida en metres quadrats
     * @param connexioElectrica Si disposa de connexió elèctrica
     */
    public Parcela(String nom_, String idAllotjament, boolean estatAllotjament,
                   String estatIluminacio, float mida, boolean connexioElectrica) {
        // Crida al constructor de la classe pare (Allotjament) amb estades mínimes fixes (2 i 4)
        super(nom_, idAllotjament, estatAllotjament, estatIluminacio, 2, 4);
        setConnexioElectrica(connexioElectrica);
        setMida(mida);
    }

    /**
     * Determina si la parcel·la està operativa
     * @return boolean true si està oberta, false si està tancada
     */
    public boolean Operatiu() {
        return getEstatAllotjament();
    }

    // Mètodes Getters i Setters

    /**
     * Obté la mida de la parcel·la
     * @return float amb la mida en metres quadrats
     */
    public float getMida() {
        return this.mida;
    }

    /**
     * Estableix la mida de la parcel·la
     * @param metres Nova mida en metres quadrats
     */
    public void setMida(float metres) {
        this.mida = metres;
    }

    /**
     * Estableix si té connexió elèctrica
     * @param connexioElectrica true si té connexió, false si no
     */
    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    /**
     * Comprova si té connexió elèctrica
     * @return boolean true si té connexió, false si no
     */
    public boolean isConnexioElectrica() {
        return this.connexioElectrica;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació de la parcel·la
     */
    public String toString() {
        return "Nom=" + this.nom_ + ", Id=" + this.idAllotjament
                + ", estat allotjament: " + getEstatAllotjament()
                + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA: " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA: " + this.estadaMinimaBAIXA_ + ".";
    }
}