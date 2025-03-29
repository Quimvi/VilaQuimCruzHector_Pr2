package prog2.model;

/**
 * Classe que representa un camí de terra, que hereta de la classe AccesTerra.
 * Aquesta classe modela un tipus específic d'accés no pavimentat amb característiques particulars.
 */
public class CamiTerra extends AccesTerra {

    /**
     * Constructor de la classe CamiTerra
     * @param nom Nom del camí de terra
     * @param estat Estat actual del camí (obert/tancat)
     * @param longitud Longitud del camí en metres
     */
    public CamiTerra(String nom, boolean estat, float longitud) {
        // Crida al constructor de la classe pare (AccesTerra) amb valors fixos:
        // - accessibilitat: false (no accessible per defecte)
        // - costReparacio: 0 (sense cost de reparació)
        super(nom, false, estat, longitud, 0);
    }

    /**
     * Sobreescriptura del mètode que determina l'accessibilitat del camí
     * @return boolean Sempre retorna false, indicant que aquest camí no és accessible
     *                (els camins de terra no són accessibles per defecte)
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    /**
     * Sobreescriptura del mètode toString per mostrar la informació del camí
     * @return String amb la representació textual del camí de terra
     *         Format: "Camí Terra => " seguit de la informació de la classe pare
     */
    @Override
    public String toString() {
        return "Camí Terra => " + super.toString();
    }
}