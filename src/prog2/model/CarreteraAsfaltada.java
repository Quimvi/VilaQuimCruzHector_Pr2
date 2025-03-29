package prog2.model;

/**
 * Classe que representa una carretera asfaltada, que hereta de la classe AccesAsfalt.
 * Aquesta classe modela un tipus d'accés asfaltat amb capacitat per a vehicles pesants.
 */
public class CarreteraAsfaltada extends AccesAsfalt {

    // Atribut específic de la carretera asfaltada
    private float pesMaxim;  // Pes màxim permès en kg que pot suportar la carretera

    /**
     * Constructor de la classe CarreteraAsfaltada
     * @param nom Nom de la carretera
     * @param estat Estat actual (oberta/tancada)
     * @param metresQuadrats Superfície de la carretera en metres quadrats
     * @param pesMaxim Pes màxim que pot suportar la carretera
     */
    public CarreteraAsfaltada(String nom, boolean estat, float metresQuadrats, float pesMaxim) {
        // Crida al constructor de la classe pare (AccesAsfalt) amb:
        // - accessibilitat: true (accessible per defecte)
        // - costReparacio: pesMaxim (el cost de reparació es basa en el pes màxim)
        super(nom, true, estat, metresQuadrats, pesMaxim);
        setPesMaxim(pesMaxim);
    }

    // Mètodes Getters i Setters

    /**
     * Obté el pes màxim que pot suportar la carretera
     * @return float amb el pes màxim en kg
     */
    public float getPesMaxim() {
        return this.pesMaxim;
    }

    /**
     * Estableix el pes màxim que pot suportar la carretera
     * @param pesMaxim Nou pes màxim en kg
     */
    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    /**
     * Sobreescriptura del mètode que determina l'accessibilitat
     * @return boolean Sempre retorna true, indicant que aquesta carretera és accessible
     */
    @Override
    public boolean isAccessibilitat() {
        return true;  // Les carreteres asfaltades són sempre accessibles
    }

    /**
     * Sobreescriptura del mètode toString
     * @return String amb la representació textual de la carretera asfaltada
     */
    @Override
    public String toString() {
        return "Carretera asfaltada => " + super.toString();  // Afegeix prefix i crida al mètode del pare
    }
}