package prog2.model;

/**
 * Classe que representa un camí asfaltat, que hereta de la classe AccesAsfalt.
 * Aquesta classe modela un tipus específic d'accés asfaltat amb característiques particulars.
 */
public class CamiAsfaltat extends AccesAsfalt {

    /**
     * Constructor de la classe CamiAsfaltat
     * @param nom Nom del camí asfaltat
     * @param estat Estat actual del camí (obert/tancat)
     * @param metresQuadrats Superfície total del camí en metres quadrats
     */
    public CamiAsfaltat(String nom, boolean estat, float metresQuadrats) {
        // Crida al constructor de la classe pare (AccesAsfalt) amb valors fixos:
        // - costReparacio: 0 (sense cost de reparació)
        // - estatAccessibilitat: false (no accessible per defecte)
        super(nom, false, estat, metresQuadrats, 0);
    }

    /**
     * Sobreescriptura del mètode que determina l'accessibilitat del camí
     * @return boolean Sempre retorna false, indicant que aquest camí no és accessible
     */
    @Override
    public boolean isAccessibilitat() {
        return false;  // Els camins asfaltats no són accessibles per defecte
    }

    /**
     * Sobreescriptura del mètode toString per mostrar la informació del camí
     * @return String amb la representació textual del camí asfaltat
     */
    @Override
    public String toString() {
        return "Camí asfaltat => " + super.toString() + "\n";  // Afegeix prefix i crida al toString() del pare
    }
}