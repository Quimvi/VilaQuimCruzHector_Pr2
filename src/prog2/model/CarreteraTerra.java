package prog2.model;

/**
 * Classe que representa una carretera de terra, que hereta de la classe AccesTerra.
 * Aquesta classe modela un tipus d'accés no pavimentat amb característiques específiques.
 */
public class CarreteraTerra extends AccesTerra {

    // Atribut específic de la carretera de terra
    private float amplada;  // Amplada de la carretera en metres

    /**
     * Constructor de la classe CarreteraTerra
     * @param nom Nom de la carretera
     * @param estat Estat actual (oberta/tancada)
     * @param longitud Longitud de la carretera en metres
     * @param amplada Amplada de la carretera en metres
     */
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        // Crida al constructor de la classe pare (AccesTerra) amb:
        // - accessibilitat: true (accessible per defecte)
        // - costReparacio: amplada (el cost de reparació es basa en l'amplada)
        super(nom, true, estat, longitud, amplada);
        setAmplada(amplada);
    }

    // Mètodes Getters i Setters

    /**
     * Obté l'amplada de la carretera
     * @return float amb l'amplada en metres
     */
    public float getAmplada() {
        return this.amplada;
    }

    /**
     * Estableix l'amplada de la carretera
     * @param amplada Nova amplada en metres
     */
    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    /**
     * Sobreescriptura del mètode que determina l'accessibilitat
     * @return boolean Sempre retorna true, indicant que aquesta carretera és accessible
     */
    @Override
    public boolean isAccessibilitat() {
        return true;  // Les carreteres de terra són sempre accessibles
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb la representació textual de la carretera de terra
     */
    @Override
    public String toString() {
        return "Carretera de terra => " + super.toString();
    }
}