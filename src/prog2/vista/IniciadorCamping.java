package prog2.vista;

import prog2.model.Camping;

/**
 * Classe inicialitzadora del sistema de gestió del camping.
 * Configura les dades inicials i llança la interfície d'usuari.
 * @author lauraigual
 */
public class IniciadorCamping {

    // Instància del camping que es gestionarà
    static Camping campingGreen = new Camping("");

    /**
     * Enumeració que defineix les opcions del menú principal
     */
    static public enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,              // Llistar tots els allotjaments
        LLISTAR_ALLOTJAMENTS_OPERATIUS,     // Llistar allotjaments operatius
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,  // Llistar allotjaments no operatius
        LLISTAR_ACCESSOS_OBERTS,            // Llistar accessos oberts
        LLISTAR_ACCESSOS_TANCATS,           // Llistar accessos tancats
        LLISTAR_INCIDENCIES,                // Llistar totes les incidències
        AFEGIR_INCIDENCIA,                  // Afegir una nova incidència
        ELIMINAR_INCIDENCIA,                // Eliminar una incidència existent
        CALCULAR_ACCESSOS_COTXE,            // Calcular accessos per cotxe
        CALCULAR_METRES_ASFALT,             // Calcular metres d'asfalt
        GUARDAR_CAMPING,                    // Guardar estat del camping
        RECUPERAR_CAMPING,                  // Recuperar camping guardat
        SORTIR                              // Sortir de l'aplicació
    }

    /**
     * Descripcions de les opcions del menú principal
     */
    static public String[] descMenuPrincipal = {
            "Llista tots els allotjaments",            // Descripció LLISTAR_ALLOTJAMENTS
            "Llistar els allotjaments operatius",      // Descripció LLISTAR_ALLOTJAMENTS_OPERATIUS
            "Llistar els allotjaments no operatius",   // Descripció LLISTAR_ALLOTJAMENTS_NO_OPERATIUS
            "Llistar els accessos oberts",             // Descripció LLISTAR_ACCESSOS_OBERTS
            "Llistar els accessos tancats",            // Descripció LLISTAR_ACCESSOS_TANCATS
            "Llistar totes les incidències",           // Descripció LLISTAR_INCIDENCIES
            "Afegir una incidència",                   // Descripció AFEGIR_INCIDENCIA
            "Eliminar una incidència",                 // Descripció ELIMINAR_INCIDENCIA
            "Calcular nombre d'accessos totals",       // Descripció CALCULAR_ACCESSOS_COTXE
            "Calcular nombre d'metres asfaltats",      // Descripció CALCULAR_METRES_ASFALT
            "Guardar el camping",                      // Descripció GUARDAR_CAMPING
            "Recuperar un camping",                    // Descripció RECUPERAR_CAMPING
            "Sortir"                                   // Descripció SORTIR
    };

    /**
     * Mètode principal que inicia l'aplicació
     * @param args Arguments de la línia de comandes (no s'utilitzen)
     */
    public static void main(String[] args) {
        // Definim el nom del camping
        String nomCamping = "Green";
        campingGreen.setNomCamping(nomCamping);

        // Creem la vista del camping amb el nom definit
        VistaCamping vistaCamping = new VistaCamping(nomCamping);

        // Iniciem la gestió del camping a través de la vista
        vistaCamping.gestioCamping(vistaCamping.sc);
    }
}