package prog2.model;

/**
 * Classe que representa una incidència registrada en un allotjament del camping.
 * Conté informació sobre el tipus d'incidència, l'allotjament afectat i la data.
 */
public class Incidencia {

    // Atributs de la classe
    private int numIncidencia;           // Número únic d'identificació de la incidència
    private Allotjament allotjament;     // Allotjament afectat per la incidència
    private String data;                 // Data quan es va produir la incidència
    private TipusIncidencia tipusIncidencia;  // Tipus d'incidència

    /**
     * Constructor de la classe Incidencia
     * @param numIncidencia Número d'identificació
     * @param allotjament Allotjament afectat
     * @param data Data de l'incidència
     * @param tipusIncidencia Tipus d'incidència
     */
    public Incidencia(int numIncidencia, Allotjament allotjament, String data, TipusIncidencia tipusIncidencia) {
        setNumIncidencia(numIncidencia);
        setAllotjament(allotjament);
        setData(data);
        setTipusIncidencia(tipusIncidencia);
    }

    // Mètodes Getters i Setters

    /**
     * Obté el número d'incidència
     * @return int amb el número d'incidència
     */
    public int getNumIncidencia() {
        return numIncidencia;
    }

    /**
     * Estableix el número d'incidència
     * @param numIncidencia Nou número d'incidència
     */
    public void setNumIncidencia(int numIncidencia) {
        this.numIncidencia = numIncidencia;
    }

    /**
     * Obté l'allotjament afectat
     * @return Allotjament relacionat amb la incidència
     */
    public Allotjament getAllotjament() {
        return allotjament;
    }

    /**
     * Estableix l'allotjament afectat
     * @param allotjament Nou allotjament relacionat
     */
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    /**
     * Obté la data de l'incidència
     * @return String amb la data
     */
    public String getData() {
        return data;
    }

    /**
     * Estableix la data de l'incidència
     * @param data Nova data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obté el tipus d'incidència
     * @return TipusIncidencia enumerat
     */
    public TipusIncidencia getTipusIncidencia() {
        return tipusIncidencia;
    }

    /**
     * Estableix el tipus d'incidència
     * @param tipusIncidencia Nou tipus d'incidència
     */
    public void setTipusIncidencia(TipusIncidencia tipusIncidencia) {
        this.tipusIncidencia = tipusIncidencia;
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb tota la informació de la incidència
     */
    public String toString() {
        return "Número d'incidència: " + getNumIncidencia()
                + ", Allotjament: " + getAllotjament().getId()
                + ", Data: " + getData()
                + ", Tipus: " + getTipusIncidencia() + "\n";
    }

    /**
     * Determina el nivell d'il·luminació de l'allotjament segons el tipus d'incidència
     * @return String amb el percentatge d'il·luminació
     */
    public String getIluminacioAllotjament() {
        if (TipusIncidencia.Reparacio == tipusIncidencia) {
            return "100%";  // Il·luminació completa per reparacions
        } else if (TipusIncidencia.Neteja == tipusIncidencia) {
            return "50%";   // Il·luminació reduïda per neteja
        } else {
            return "0%";    // Sense il·luminació per tancaments
        }
    }

    /**
     * Enumeració que defineix els tipus d'incidències possibles
     */
    public static enum TipusIncidencia {
        Reparacio,  // Indica una incidència de reparació
        Neteja,     // Indica una incidència de neteja
        Tancament   // Indica un tancament temporal
    }
}