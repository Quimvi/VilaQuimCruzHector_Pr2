package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que gestiona una llista d'allotjaments del camping, implementant la interfície InLlistaAllotjaments.
 * Permet afegir, eliminar, buscar i llistar els allotjaments del camping.
 */
public class LlistaAllotjaments implements InLlistaAllotjaments {

    // Llista interna per emmagatzemar els allotjaments
    private final ArrayList<Allotjament> allotjaments;

    /**
     * Constructor que inicialitza la llista d'allotjaments
     */
    public LlistaAllotjaments() {
        this.allotjaments = new ArrayList<Allotjament>();
    }

    /**
     * Obté la llista completa d'allotjaments
     * @return ArrayList amb tots els allotjaments
     */
    public ArrayList<Allotjament> getAllotjaments() {
        return allotjaments;
    }

    /**
     * Afegeix un nou allotjament a la llista
     * @param allotjament Allotjament a afegir
     * @throws ExcepcioCamping Si l'allotjament ja existeix
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        // Verifica que no existeixi un allotjament amb el mateix nom i ID
        Iterator<Allotjament> itrAllot = allotjaments.iterator();
        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) &&
                    allotjamentLlist.getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Aquest allotjament ja es troba en allotjaments");
            }
        }
        allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments
     */
    public void buidar() {
        this.allotjaments.clear();
    }

    /**
     * Llista els allotjaments segons l'estat especificat
     * @param estat Estat dels allotjaments a llistar ("Operatiu", "No operatiu" o "Tots")
     * @return String amb la informació dels allotjaments
     * @throws ExcepcioCamping Si no hi ha allotjaments en l'estat sol·licitat
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        boolean trobat = false;
        StringBuffer concatenacioInfo = new StringBuffer();
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (estat.equals("Operatiu") && allotjamentLlist.getEstatAllotjament()) {
                concatenacioInfo.append(allotjamentLlist.toString());
                trobat = true;
            } else if (estat.equals("No operatiu") && !allotjamentLlist.getEstatAllotjament()) {
                concatenacioInfo.append(allotjamentLlist.toString());
                trobat = true;
            } else if (estat.equals("Tots")) {
                concatenacioInfo.append(allotjamentLlist.toString());
                trobat = true;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("No hi ha allotjaments en aquest estat");
        }
        return concatenacioInfo.toString();
    }

    /**
     * Comprova si hi ha allotjaments operatius a la llista
     * @return true si hi ha allotjaments operatius, false en cas contrari
     */
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getEstatAllotjament())
                return true;
        }
        return false;
    }

    /**
     * Comprova si un allotjament existeix a la llista
     * @param allotjament Allotjament a buscar
     * @return true si l'allotjament existeix, false en cas contrari
     */
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) &&
                    allotjamentLlist.getId().equals(allotjament.getId()))
                return true;
        }
        return false;
    }

    /**
     * Obté un allotjament pel seu ID
     * @param id Identificador de l'allotjament
     * @return L'allotjament trobat
     * @throws ExcepcioCamping Si no es troba l'allotjament
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getId().equals(id)) {
                return allotjamentLlist;
            }
        }
        throw new ExcepcioCamping("Aquest allotjament no es troba en allotjaments");
    }
}