package prog2.model;

/**
 * Classe que representa un bungalow, que és un tipus específic d'allotjament
 * que hereta de la classe Casa.
 */
public class Bungalow extends Casa {

    // Atributs específics del bungalow
    private int placesParquing;    // Nombre de places de pàrquing disponibles
    private boolean terrassa;      // Indica si té terrassa (true/false)
    private boolean tv;            // Indica si té televisió (true/false)
    private boolean aireFred;      // Indica si té aire condicionat (true/false)

    /**
     * Constructor de la classe Bungalow
     * @param nom_ Nom del bungalow
     * @param idAllotjament_ Identificador únic del bungalow
     * @param estatAllotjament Estat inicial (obert/tancat)
     * @param estatIluminacio Estat inicial de la il·luminació
     * @param mida Mida del bungalow en metres quadrats
     * @param habitacions Nombre d'habitacions
     * @param placesPersones Capacitat de persones
     * @param placesParquing Nombre de places de pàrquing
     * @param terrassa Si té terrassa
     * @param tv Si té televisió
     * @param aireFred Si té aire condicionat
     */
    public Bungalow(String nom_, String idAllotjament_, boolean estatAllotjament, String estatIluminacio,
                    float mida, int habitacions, int placesPersones, int placesParquing,
                    boolean terrassa, boolean tv, boolean aireFred) {
        // Crida al constructor de la classe pare (Casa) amb valors fixos per a estada mínima (4 i 7)
        super(nom_, idAllotjament_, estatAllotjament, estatIluminacio, 4, 7, mida, habitacions, placesPersones);

        // Inicialització dels atributs propis del bungalow
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    /**
     * Sobreescriptura del mètode Operatiu de la classe pare
     * @return boolean indicant si el bungalow està operatiu
     */
    @Override
    public boolean Operatiu() {
        return super.Operatiu();  // Utilitza la implementació de la classe pare
    }

    // Mètodes Getters i Setters

    /**
     * Obté el nombre de places de pàrquing
     * @return int amb el nombre de places
     */
    public int getPlacesParquing() {
        return this.placesParquing;
    }

    /**
     * Estableix el nombre de places de pàrquing
     * @param placesParquing Nou nombre de places
     */
    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    /**
     * Estableix si té terrassa
     * @param terrassa true si té terrassa, false si no
     */
    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    /**
     * Comprova si té terrassa
     * @return boolean true si té terrassa, false si no
     */
    public boolean isTerrassa() {
        return this.terrassa;
    }

    /**
     * Estableix si té televisió
     * @param tv true si té TV, false si no
     */
    public void setTv(boolean tv) {
        this.tv = tv;
    }

    /**
     * Comprova si té televisió
     * @return boolean true si té TV, false si no
     */
    public boolean isTv() {
        return this.tv;
    }

    /**
     * Comprova si té aire condicionat
     * @return boolean true si té aire condicionat, false si no
     */
    public boolean isAireFred() {
        return this.aireFred;
    }

    /**
     * Estableix si té aire condicionat
     * @param aireFred true si té aire condicionat, false si no
     */
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    /**
     * Sobreescriptura del mètode toString per mostrar tota la informació del bungalow
     * @return String amb tots els detalls del bungalow
     */
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida
                + ", Habitacions = " + this.habitacions + ", placesPersones = " + this.placesPersones
                + ", placesParquing = " + this.placesParquing + ", Terrassa = " + this.terrassa
                + ", tv = " + this.tv + ", aireFred = " + this.aireFred
                + ", estat allotjament: " + getEstatAllotjament() + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}