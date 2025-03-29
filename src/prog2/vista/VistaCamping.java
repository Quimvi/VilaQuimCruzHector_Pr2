package prog2.vista;

import java.util.Scanner;
import prog2.model.Allotjament;
import prog2.model.LlistaAccessos;
import prog2.model.LlistaAllotjaments;
import prog2.model.LlistaIncidencies;
import prog2.model.Camping;
import prog2.vista.IniciadorCamping.OpcionsMenuPrincipal;
import static prog2.vista.IniciadorCamping.campingGreen;
import static prog2.vista.IniciadorCamping.descMenuPrincipal;

/**
 * Classe que gestiona la interfície d'usuari del sistema de gestió del camping.
 * Mostra el menú principal i gestiona totes les operacions disponibles.
 */
public class VistaCamping {
    String _nomCamping;  // Nom del camping que es gestiona

    // Objecte per llegir l'entrada de l'usuari des del teclat
    Scanner sc = new Scanner(System.in);

    /**
     * Constructor que rep el nom del camping
     * @param nomCamping Nom del camping que es mostrarà a la interfície
     */
    public VistaCamping(String nomCamping) {
        _nomCamping = nomCamping;
    }

    /**
     * Mètode principal que gestiona el fluxe de l'aplicació
     * @param sc Scanner per llegir l'entrada de l'usuari
     */
    public void gestioCamping(Scanner sc) {
        // Inicialitza les dades del camping amb valors per defecte
        campingGreen.inicialitzaDadesCamping();

        // Configura el menú principal amb les opcions disponibles
        Menu<IniciadorCamping.OpcionsMenuPrincipal> menu = new Menu<IniciadorCamping.OpcionsMenuPrincipal>("Menu Principal", IniciadorCamping.OpcionsMenuPrincipal.values());

        // Assigna les descripcions a cada opció del menú
        menu.setDescripcions(descMenuPrincipal);

        // Variable per controlar l'opció seleccionada per l'usuari
        IniciadorCamping.OpcionsMenuPrincipal opcio = null;

        // Bucle principal de l'aplicació
        do {
            // Mostra el menú d'opcions
            menu.mostrarMenu();

            // Llegeix l'opció seleccionada per l'usuari
            opcio = menu.getOpcio(sc);

            // Gestiona l'opció seleccionada
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    try {
                        System.out.println("Has triat la opció 1");
                        System.out.println(campingGreen.llistarAllotjaments("Tots"));
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    try {
                        System.out.println("Has triat la opció 2");
                        System.out.println(campingGreen.llistarAllotjaments("Operatiu"));
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    try {
                        System.out.println("Has triat la opció 3");
                        System.out.println(campingGreen.llistarAllotjaments("No operatiu"));
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        System.out.println("Has triat la opció 4");
                        System.out.println(campingGreen.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_TANCATS:
                    try {
                        System.out.println("Has triat la opció 5");
                        System.out.println(campingGreen.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case LLISTAR_INCIDENCIES:
                    try {
                        System.out.println("Has triat la opció 6");
                        System.out.println(campingGreen.llistarIncidencies());
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case AFEGIR_INCIDENCIA:
                    try {
                        int num;
                        String tipus, data;

                        System.out.println("Has triat la opció 7");
                        System.out.println("Número d'incidència? ");
                        num = sc.nextInt();
                        System.out.println("Tipus d'incidència? (Reparacio, Neteja, Tancament) ");
                        tipus = sc.next();
                        System.out.println("Data de l'incidència? (dd/mm/yyyy)");
                        data = sc.next();

                        String id;
                        campingGreen.llistarAllotjaments("Operatiu");
                        System.out.println("Digues la Id de l'allotjament -> ");
                        id = sc.next();

                        campingGreen.afegirIncidencia(num, tipus, id, data);
                        System.out.println("Incidència afegida");
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case ELIMINAR_INCIDENCIA:
                    try {
                        int num2;

                        System.out.println("Has triat la opció 8");
                        campingGreen.llistarIncidencies();
                        System.out.println("Digues el número de l'incidència -> ");
                        num2 = sc.nextInt();

                        campingGreen.eliminarIncidencia(num2);
                        System.out.println("Incidència eliminada");
                    } catch (ExcepcioCamping ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case CALCULAR_ACCESSOS_COTXE:
                    System.out.println("Has triat la opció 9");
                    System.out.println("Accessos accessibles: " + campingGreen.calculaAccessosAccessibles());
                    break;

                case CALCULAR_METRES_ASFALT:
                    System.out.println("Has triat la opció 10");
                    System.out.println("Metres quadrats asfaltats: " + campingGreen.calculaMetresQuadratsAsfalt());
                    break;

                case GUARDAR_CAMPING:
                    String camiDesti;

                    System.out.println("Has triat la opció 11");
                    System.out.println("Ruta del fitxer de destinació? ");
                    camiDesti = sc.next();

                    campingGreen.save(camiDesti);
                    break;

                case RECUPERAR_CAMPING:
                    String camiOrigen;

                    System.out.println("Has triat la opció 12");
                    System.out.println("Ruta del fitxer de origen? ");
                    camiOrigen = sc.next();

                    Camping.load(camiOrigen);
                    break;

                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while(opcio != IniciadorCamping.OpcionsMenuPrincipal.SORTIR);
    }
}