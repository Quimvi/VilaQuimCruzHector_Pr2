package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class LlistaIncidencies implements InLlistaIncidencies{
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies(){
        this.incidencies = new ArrayList<Incidencia>();
    }

    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

        if (Objects.equals(tipus, "Reparacio") || Objects.equals(tipus, "Neteja") || Objects.equals(tipus, "Tancament")) {
            Incidencia.TipusIncidencia tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
            Incidencia incidencia = new Incidencia(num,allotjament, data, tipusIncidencia);

            if (incidencia.getAllotjament().getEstatAllotjament()){
                allotjament.tancarAllotjament(incidencia);
                this.incidencies.add(incidencia);
            }else {
                throw new ExcepcioCamping("L'allotjament :" + incidencia.getAllotjament().getNom() + " ja té una incidència");
            }

        }else{
            throw new ExcepcioCamping("Aquest tipus d'incidencia no existeix");
        }

    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping{
        Iterator<Incidencia> itrIn = this.incidencies.iterator();
        boolean trobat = false;
        while (itrIn.hasNext() && !trobat) {
            Incidencia incidenciaLlist = itrIn.next();
            if (incidenciaLlist.getNumIncidencia() == in.getNumIncidencia()) {
                trobat = true;
                this.incidencies.remove(in);
            }
        }
        if (!trobat) {
            throw new ExcepcioCamping("no es troba en la llista");
        }
    }

    //s'ha de fer
    public String llistarIncidencies() throws ExcepcioCamping{
        boolean hiha = false;
        StringBuffer concatenacioInfo = new StringBuffer();
        Iterator<Incidencia> itrIn = this.incidencies.iterator();

        while (itrIn.hasNext()) {
            hiha = true;
            Incidencia incidenciaLlist = itrIn.next();
            concatenacioInfo.append(incidenciaLlist.toString()); //mirar que funcioni correctament
        }
        if(!hiha){
            throw new ExcepcioCamping("no hi han incidencies");
        }
        return concatenacioInfo.toString();
    }

    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Iterator<Incidencia> itrInci = this.incidencies.iterator();
        while (itrInci.hasNext()) {
            Incidencia incidenciaLlist = itrInci.next();
            if (incidenciaLlist.getNumIncidencia() == num ) {
                return incidenciaLlist;
            }
        }
        throw new ExcepcioCamping("Aquest num d'incidencia no existeix");
    }

}
