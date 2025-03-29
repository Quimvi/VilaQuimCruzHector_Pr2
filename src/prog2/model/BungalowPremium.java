package prog2.model;

/**
 * Classe que representa un Bungalow Premium, que hereta de la classe Casa
 * i afegeix característiques exclusives per a allotjaments de categoria premium.
 */
public class BungalowPremium extends Casa {

    // Atributs específics del Bungalow Premium
    private int placesParquing;    // Nombre de places de pàrquing exclusives
    private boolean terrassa;      // Indica si disposa de terrassa privada
    private boolean tv;            // Indica si inclou televisió de pantalla plana
    private boolean aireFred;      // Indica si té aire condicionat de última generació
    private boolean serveisExtra;  // Indica si inclou serveis addicionals (netejia diària, etc.)
    private String codiWifi;       // Codi d'accés a la xarxa WiFi premium

    /**
     * Constructor de la classe BungalowPremium
     * @param nom_ Nom del bungalow premium
     * @param idAllotjament_ Identificador únic de l'allotjament
     * @param estatAllotjament Estat actual (obert/tancat)
     * @param estatIluminacio Nivell d'il·luminació actual
     * @param mida Metratge quadrat del bungalow
     * @param habitacions Nombre d'habitacions
     * @param placesPersones Capacitat màxima d'hostes
     * @param placesParquing Places de pàrquing privades
     * @param terrassa Si disposa de terrassa
     * @param tv Si inclou televisió
     * @param aireFred Si té aire condicionat
     * @param serveisExtra Si inclou serveis addicionals
     * @param codiWifi Codi d'accés WiFi exclusiu
     */
    public BungalowPremium(String nom_, String idAllotjament_, boolean estatAllotjament,
                           String estatIluminacio, float mida, int habitacions,
                           int placesPersones, int placesParquing, boolean terrassa,
                           boolean tv, boolean aireFred, boolean serveisExtra,
                           String codiWifi) {
        // Crida al constructor de la classe pare (Casa) amb estades mínimes fixes (4 i 7)
        super(nom_, idAllotjament_, estatAllotjament, estatIluminacio, 4, 7,
                mida, habitacions, placesPersones);

        // Inicialització dels atributs propis
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    /**
     * Sobreescriptura del mètode Operatiu
     * @return boolean que indica si el bungalow està operatiu
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
     * Estableix si inclou serveis extra
     * @param serveisExtra true si inclou serveis addicionals, false si no
     */
    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    /**
     * Comprova si inclou serveis extra
     * @return boolean true si inclou serveis addicionals, false si no
     */
    public boolean isServeisExtra() {
        return this.serveisExtra;
    }

    /**
     * Estableix el codi d'accés WiFi
     * @param codiWifi Nou codi d'accés
     */
    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    /**
     * Obté el codi d'accés WiFi
     * @return String amb el codi WiFi
     */
    public String getCodiWifi() {
        return this.codiWifi;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació del bungalow premium
     */
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament
                + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones
                + ", placesParquing = " + this.placesParquing
                + ", Terrassa = " + this.terrassa
                + ", tv = " + this.tv + ", aireFred = " + this.aireFred
                + ", serveisExtra = " + this.serveisExtra
                + ", codiWifi = " + this.codiWifi
                + ", estat allotjament: " + getEstatAllotjament()
                + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}