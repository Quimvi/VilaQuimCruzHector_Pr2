package prog2.vista;

import java.util.Scanner;

import prog2.model.Allotjament;
import prog2.model.LlistaAccessos;
import prog2.model.LlistaAllotjaments;
import prog2.model.LlistaIncidencies;
import prog2.model.Camping;
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
            Camping camping = new Camping(_nomCamping);
            camping.inicialitzaDadesCamping();
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    System.out.println("Has triat la opció 1");
                    camping.getLlistaAllotjaments().llistarAllotjaments("Tots");
                    break;

                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    System.out.println("Has triat la opció 2");
                    camping.getLlistaAllotjaments().llistarAllotjaments("Operatiu");
                    break;

                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    System.out.println("Has triat la opció 3");
                    camping.getLlistaAllotjaments().llistarAllotjaments("No operatiu");
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    System.out.println("Has triat la opció 4");
                    camping.getLlistaAccessos().llistarAccessos(true);
                    break;

                case LLISTAR_ACCESSOS_TANCATS:
                    System.out.println("Has triat la opció 5");
                    camping.getLlistaAccessos().llistarAccessos(false);
                    break;

                case LLISTAR_INCIDENCIES:
                    System.out.println("Has triat la opció 6");
                    camping.getLlistaIncidencies().llistarIncidencies();
                    break;

                case AFEGIR_INCIDENCIA:
                    int num;
                    String tipus, data;

                    System.out.println("Has triat la opció 7");
                    System.out.println("Número d'incidència? ");
                    num=sc.nextInt();
                    System.out.println("Tipus d'incidència? ");
                    tipus=sc.next();
                    System.out.println("Data de l'incidència? ");
                    data=sc.next();

                    String id;
                    camping.getLlistaAllotjaments().llistarAllotjaments("Operatiu");
                    System.out.println("Digues la Id de l'allotjament -> ");
                    id=sc.next();

                    camping.getLlistaIncidencies().afegirIncidencia(num, tipus, LlistaAllotjaments.getAllotjament(id), data);
                    System.out.println("Incidència afegida");
                    break;

                case ELIMINAR_INCIDENCIA:
                    int num2;

                    System.out.println("Has triat la opció 8");
                    camping.getLlistaIncidencies().llistarIncidencies();
                    System.out.println("Digues el número de l'incidència -> ");
                    num2=sc.nextInt();

                    camping.getLlistaIncidencies().eliminarIncidencia(camping.getLlistaIncidencies().getIncidencia(num2));
                    System.out.println("Incidència eliminada");
                    break;

                case CALCULAR_ACCESSOS_COTXE:
                    System.out.println("Has triat la opció 9");
                    System.out.println("Accessos accessibles: " + camping.getLlistaAccessos().calculaAccessosAccessibles());
                    break;

                case CALCULAR_METRES_ASFALT:
                    System.out.println("Has triat la opció 10");
                    System.out.println("Metres quadrats asfaltats: " + camping.getLlistaAccessos().calculaMetresQuadratsAsfalt());
                    break;

                case GUARDAR_CAMPING:
                    String camiDesti;

                    System.out.println("Has triat la opció 11");
                    System.out.println("Ruta del fitxer de destinació? ");
                    camiDesti=sc.next();

                    Camping a = IniciadorCamping.campingGreen;
                    a.save(camiDesti);
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

