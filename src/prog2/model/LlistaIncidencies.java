package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Classe que gestiona una llista d'incidències del camping, implementant la interfície InLlistaIncidencies.
 * Permet afegir, eliminar i consultar incidències dels allotjaments.
 */
public class LlistaIncidencies implements InLlistaIncidencies, Serializable {

    // Llista estàtica que emmagatzema totes les incidències
    public static ArrayList<Incidencia> incidencies;

    /**
     * Constructor que inicialitza la llista d'incidències
     */
    public LlistaIncidencies() {
        incidencies = new ArrayList<Incidencia>();
    }

    /**
     * Afegeix una nova incidència a la llista
     * @param num Número d'incidència
     * @param tipus Tipus d'incidència (Reparacio, Neteja o Tancament)
     * @param allotjament Allotjament afectat
     * @param data Data de l'incidència
     * @throws ExcepcioCamping Si l'incidència no és vàlida o l'allotjament ja té una incidència
     */
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        // Verifica que el tipus d'incidència sigui vàlid
        if (Objects.equals(tipus, "Reparacio") || Objects.equals(tipus, "Neteja") || Objects.equals(tipus, "Tancament")) {
            Incidencia.TipusIncidencia tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
            Incidencia incidencia = new Incidencia(num, allotjament, data, tipusIncidencia);

            // Comprova que l'allotjament estigui operatiu
            if (incidencia.getAllotjament().getEstatAllotjament()) {
                allotjament.tancarAllotjament(incidencia);
                incidencies.add(incidencia);
            } else {
                throw new ExcepcioCamping("L'allotjament: " + incidencia.getAllotjament().getNom() + " ja té una incidència");
            }
        } else {
            throw new ExcepcioCamping("Aquest tipus d'incidència no existeix");
        }
    }

    /**
     * Elimina una incidència existent
     * @param in Incidència a eliminar
     * @throws ExcepcioCamping Si l'incidència no existeix
     */
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        Iterator<Incidencia> itrIn = incidencies.iterator();
        boolean trobat = false;

        while (itrIn.hasNext() && !trobat) {
            Incidencia incidenciaLlist = itrIn.next();
            if (incidenciaLlist.getNumIncidencia() == in.getNumIncidencia()) {
                trobat = true;
                // Reobrir l'allotjament associat
                incidenciaLlist.getAllotjament().obrirAllotjament();
                incidencies.remove(incidenciaLlist);
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("Aquesta incidència no existeix");
        }
    }

    /**
     * Llista totes les incidències registrades
     * @return String amb la informació de totes les incidències
     * @throws ExcepcioCamping Si no hi ha incidències
     */
    public String llistarIncidencies() throws ExcepcioCamping {
        boolean hiha = false;
        StringBuffer concatenacioInfo = new StringBuffer();
        Iterator<Incidencia> itrIn = incidencies.iterator();

        while (itrIn.hasNext()) {
            hiha = true;
            Incidencia incidenciaLlist = itrIn.next();
            concatenacioInfo.append(incidenciaLlist.toString());
        }

        if(!hiha) {
            throw new ExcepcioCamping("No hi ha incidències");
        }
        return concatenacioInfo.toString();
    }

    /**
     * Obté una incidència pel seu número
     * @param num Número d'incidència
     * @return L'incidència trobada
     * @throws ExcepcioCamping Si no es troba l'incidència
     */
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Iterator<Incidencia> itrInci = incidencies.iterator();

        while (itrInci.hasNext()) {
            Incidencia incidenciaLlist = itrInci.next();
            if (incidenciaLlist.getNumIncidencia() == num) {
                return incidenciaLlist;
            }
        }
        throw new ExcepcioCamping("Aquest número d'incidència no existeix");
    }
}