package prog2.vista;

import java.util.Scanner;
import prog2.vista.IniciadorCamping.OpcionsMenuPrincipal;
import static prog2.vista.IniciadorCamping.descMenuPrincipal;

public class VistaCamping {
    String _nomCamping;

    // Creem un objecte per llegir des del teclat
    Scanner sc=new Scanner(System.in);

    public VistaCamping(String nomCamping) {
        _nomCamping = nomCamping;
    }

    public void gestioCamping(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<IniciadorCamping.OpcionsMenuPrincipal> menu=new Menu<IniciadorCamping.OpcionsMenuPrincipal>("Menu Principal", IniciadorCamping.OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        IniciadorCamping.OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opció
            opcio=menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    System.out.println("Has triat la opció 1");
                    break;

                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    System.out.println("Has triat la opció 2");
                    break;

                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    System.out.println("Has triat la opció 3");
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    System.out.println("Has triat la opció 4");
                    break;

                case LLISTAR_ACCESSOS_TANCATS:
                    System.out.println("Has triat la opció 5");
                    break;

                case LLISTAR_INCIDENCIES:
                    System.out.println("Has triat la opció 6");
                    break;

                case AFEGIR_INCIDENCIA:
                    System.out.println("Has triat la opció 7");
                    break;

                case ELIMINAR_INCIDENCIA:
                    System.out.println("Has triat la opció 8");
                    break;

                case CALCULAR_ACCESSOS_COTXE:
                    System.out.println("Has triat la opció 9");
                    break;

                case CALCULAR_METRES_ASFALT:
                    System.out.println("Has triat la opció 10");
                    break;

                case GUARDAR_CAMPING:
                    System.out.println("Has triat la opció 11");
                    break;

                case RECUPERAR_CAMPING:
                    System.out.println("Has triat la opció 12");
                    break;

                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while(opcio!= IniciadorCamping.OpcionsMenuPrincipal.SORTIR);
    }
}

