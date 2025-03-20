package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class LlistaIncidencies {
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies(){
        this.incidencies = new ArrayList<Incidencia>();
    }

    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

        if (Objects.equals(tipus, "Reparacio") || Objects.equals(tipus, "Neteja") || Objects.equals(tipus, "Tancament")) {
            Incidencia.TipusIncidencia tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
            Incidencia incidencia = new Incidencia(num,allotjament, data, tipusIncidencia);

            if (incidencia.getAllotjament().getEstatAllotjament()){
                this.incidencies.add(incidencia);
            }else {
                throw new ExcepcioCamping("L'allotjament :" + incidencia.getAllotjament().getNom() + " ja té una incidència");

            }

            allotjament.tancarAllotjament(incidencia);
        }else{
            throw new ExcepcioCamping("Aquest tipus d'incidencia no existeix");
        }

    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping{

        if (!in.getAllotjament().getEstatAllotjament()){
            Iterator<Incidencia> itrInci = this.incidencies.iterator();
            while (itrInci.hasNext()) {
                Incidencia incidenciaLlist = itrInci.next();
                if (incidenciaLlist.getNumIncidencia() == in.getNumIncidencia())
                    this.incidencies.remove(incidenciaLlist);
            }
        }else {
            throw new ExcepcioCamping("Aquesta incidència no existeix en incidencies");
        }

    }

    //s'ha de fer
    public String llistarIncidencies() throws ExcepcioCamping{

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
