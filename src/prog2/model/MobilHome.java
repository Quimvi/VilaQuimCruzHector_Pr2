package prog2.model;

/**
 * Classe que representa un MobilHome, que hereta de la classe Casa.
 * Aquesta classe modela un tipus d'allotjament mòbil amb característiques específiques.
 */
public class MobilHome extends Casa {

    // Atribut específic del MobilHome
    private boolean terrassaBarbacoa;  // Indica si disposa d'àrea de barbacoa a la terrassa

    /**
     * Constructor de la classe MobilHome
     * @param nom_ Nom del MobilHome
     * @param idAllotjament_ Identificador únic
     * @param estatAllotjament Estat actual (obert/tancat)
     * @param estatIluminacio Estat de la il·luminació
     * @param mida Mida en metres quadrats
     * @param habitacions Nombre d'habitacions
     * @param placesPersones Capacitat de persones
     * @param terrassaBarbacoa Si disposa de barbacoa a la terrassa
     */
    public MobilHome(String nom_, String idAllotjament_, boolean estatAllotjament,
                     String estatIluminacio, float mida, int habitacions,
                     int placesPersones, boolean terrassaBarbacoa) {
        // Crida al constructor de la classe pare (Casa) amb estades mínimes fixes (3 i 5)
        super(nom_, idAllotjament_, estatAllotjament, estatIluminacio,
                3, 5, mida, habitacions, placesPersones);
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    /**
     * Sobreescriptura del mètode Operatiu
     * @return boolean que indica si el MobilHome està operatiu
     */
    @Override
    public boolean Operatiu() {
        return super.Operatiu(); // Utilitza la implementació de la classe pare
    }

    // Mètodes Getters i Setters

    /**
     * Comprova si té terrassa amb barbacoa
     * @return boolean true si té barbacoa, false si no
     */
    public boolean getTerrassaBarbacoa() {
        return this.terrassaBarbacoa;
    }

    /**
     * Estableix si té terrassa amb barbacoa
     * @param terrassaBarbacoa true per indicar que té barbacoa, false si no
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació del MobilHome
     */
    public String toString() {
        return super.toString() + ", TerrassaBarbacoa = " + this.terrassaBarbacoa + ".\n";

    }
}