package prog2.model;

/**
 * Classe que representa una casa com a tipus d'allotjament, heretant de la classe base Allotjament.
 * Aquesta classe afegeix característiques específiques de les cases en un camping.
 */
public class Casa extends Allotjament {

    // Atributs específics de la casa
    protected float mida;           // Mida de la casa en metres quadrats
    protected int habitacions;      // Nombre d'habitacions de la casa
    protected int placesPersones;   // Capacitat màxima de persones

    /**
     * Constructor de la classe Casa
     * @param nom_ Nom de la casa
     * @param idAllotjament Identificador únic de l'allotjament
     * @param estatAllotjament Estat actual (obert/tancat)
     * @param estatIluminacio Estat de la il·luminació
     * @param estadaMinimaALTA_ Estada mínima en temporada alta
     * @param estadaMinimaBAIXA_ Estada mínima en temporada baixa
     * @param mida Mida en metres quadrats
     * @param habitacions Nombre d'habitacions
     * @param placesPersones Capacitat de persones
     */
    public Casa(String nom_, String idAllotjament, boolean estatAllotjament,
                String estatIluminacio, long estadaMinimaALTA_, long estadaMinimaBAIXA_,
                float mida, int habitacions, int placesPersones) {
        // Crida al constructor de la classe pare (Allotjament)
        super(nom_, idAllotjament, estatAllotjament, estatIluminacio,
                estadaMinimaALTA_, estadaMinimaBAIXA_);

        // Inicialització dels atributs propis
        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);
    }

    /**
     * Determina si la casa està operativa
     * @return boolean true si la casa està oberta, false si està tancada
     */
    public boolean Operatiu() {
        return this.estatAllotjament;
    }

    // Mètodes Getters i Setters

    /**
     * Obté el nombre d'habitacions
     * @return int amb el nombre d'habitacions
     */
    public int getHabitacions() {
        return this.habitacions;
    }

    /**
     * Estableix el nombre d'habitacions
     * @param habitacions Nou nombre d'habitacions
     */
    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    /**
     * Estableix la capacitat de persones
     * @param placesPersones Nova capacitat
     */
    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

    /**
     * Obté la capacitat de persones
     * @return int amb la capacitat
     */
    public int getPlacesPersones() {
        return this.placesPersones;
    }

    /**
     * Obté la mida de la casa
     * @return float amb la mida en metres quadrats
     */
    public float getMida() {
        return this.mida;
    }

    /**
     * Estableix la mida de la casa
     * @param mida Nova mida en metres quadrats
     */
    public void setMida(float mida) {
        this.mida = mida;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació de la casa
     */
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament
                + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones
                + ", estat allotjament: " + getEstatAllotjament()
                + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}