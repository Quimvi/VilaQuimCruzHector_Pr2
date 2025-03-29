package prog2.model;

/**
 * Classe que representa un Glamping (acampada de luxe), que hereta de la classe Casa.
 * Aquesta classe afegeix característiques específiques dels allotjaments tipus glamping.
 */
public class Glamping extends Casa {

    // Atributs específics del Glamping
    private String material;      // Material principal de construcció del glamping
    private boolean casaMascota; // Indica si permet l'accés a mascotes

    /**
     * Constructor de la classe Glamping
     * @param nom_ Nom del glamping
     * @param idAllotjament_ Identificador únic
     * @param estatAllotjament Estat actual (obert/tancat)
     * @param estatIluminacio Estat de la il·luminació
     * @param mida Mida en metres quadrats
     * @param habitacions Nombre d'habitacions
     * @param placesPersones Capacitat de persones
     * @param material Material de construcció
     * @param casaMascota Si permet mascotes
     */
    public Glamping(String nom_, String idAllotjament_, boolean estatAllotjament,
                    String estatIluminacio, float mida, int habitacions,
                    int placesPersones, String material, boolean casaMascota) {
        // Crida al constructor de la classe pare (Casa) amb estades mínimes fixes (3 i 5)
        super(nom_, idAllotjament_, estatAllotjament, estatIluminacio,
                3, 5, mida, habitacions, placesPersones);

        // Inicialització dels atributs propis
        setMaterial(material);
        setCasaMascota(casaMascota);
    }

    /**
     * Sobreescriptura del mètode Operatiu
     * @return boolean que indica si el glamping està operatiu
     */
    @Override
    public boolean Operatiu() {
        return super.Operatiu(); // Utilitza la implementació de la classe pare
    }

    // Mètodes Getters i Setters

    /**
     * Obté el material de construcció
     * @return String amb el material
     */
    public String getMaterial() {
        return this.material;
    }

    /**
     * Estableix el material de construcció
     * @param material Nou material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Comprova si permet mascotes
     * @return boolean true si permet mascotes, false si no
     */
    public boolean getCasaMascota() {
        return this.casaMascota;
    }

    /**
     * Estableix si permet mascotes
     * @param casaMascota true per permetre mascotes, false per no permetre-les
     */
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació del glamping
     */
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament
                + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones
                + ", Material = " + this.material
                + ", casaMascota = " + this.casaMascota
                + ", estat allotjament: " + getEstatAllotjament()
                + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}