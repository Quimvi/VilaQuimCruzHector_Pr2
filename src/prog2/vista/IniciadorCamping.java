package prog2.vista;

import prog2.model.Camping;

/**
 *
 * @author lauraigual
 */
public class IniciadorCamping {
    //Inicialitzo dades camping
    static Camping campingGreen = new Camping("");

    // Declarem les opcions per a referir-se a les opcions del menú.
    static public enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_INCIDENCIES,
        AFEGIR_INCIDENCIA,
        ELIMINAR_INCIDENCIA,
        CALCULAR_ACCESSOS_COTXE,
        CALCULAR_METRES_ASFALT,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR
    }

    // Declarem descripcions personalitzades per a les opcions del menú principal
    static public String[] descMenuPrincipal={
        " 1. Llista tots els allotjaments",
        " 2. Llistar els allotjaments operatius",
        " 3. Llistar els allotjaments no operatius",
        " 4. Llistar els accessos oberts",
        " 5. Llistar els accessos tancats",
        " 6. Llistar totes les incidències",
        " 7. Afegir una incidència",
        " 8. Eliminar una incidència",
        " 9. Calcular nombre d'accessos amb cotxe",
        "10. Calcular nombre d'metres asfaltats",
        "11. Guardar el camping",
        "12. Recuperar un camping",
        "13. Sortir"
    };

    public static void main(String[] args) {
        // Definim el nom del càmping
        String nomCamping = "Green";
        campingGreen.setNomCamping(nomCamping);

        // Creem un objecte de la vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(nomCamping);
     
        // Inicialitzem l'execució de la vista
        vistaCamping.gestioCamping(vistaCamping.sc);
    }
}
