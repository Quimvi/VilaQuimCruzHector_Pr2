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
        INICIAR_DADES,
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
        "Inicialitzar dades del camping",
        "Llista tots els allotjaments",
        "Llistar els allotjaments operatius",
        "Llistar els allotjaments no operatius",
        "Llistar els accessos oberts",
        "Llistar els accessos tancats",
        "Llistar totes les incidències",
        "Afegir una incidència",
        "Eliminar una incidència",
        "Calcular nombre d'accessos amb cotxe",
        "Calcular nombre d'metres asfaltats",
        "Guardar el camping",
        "Recuperar un camping",
        "Sortir"
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
