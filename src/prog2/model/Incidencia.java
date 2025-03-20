package prog2.model;

public class Incidencia {
    private int numIncidencia;
    private Allotjament allotjament;
    private String data;
    private TipusIncidencia tipusIncidencia;


    public Incidencia(int numIncidencia,Allotjament allotjament,String data,TipusIncidencia tipusIncidencia ){
        setNumIncidencia(numIncidencia);
        setAllotjament(allotjament);
        setData(data);
        setTipusIncidencia(tipusIncidencia);
    }
    public int getNumIncidencia() {
        return numIncidencia;
    }

    public void setNumIncidencia(int numIncidencia) {
        this.numIncidencia = numIncidencia;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipusIncidencia getTipusIncidencia() {
        return tipusIncidencia;
    }

    public void setTipusIncidencia(TipusIncidencia tipusIncidencia) {
        this.tipusIncidencia = tipusIncidencia;
    }

    // s'ha de fer
    public String toString(){

    }

    public String getIluminacioAllotjament() {
        if (TipusIncidencia.Reparacio == tipusIncidencia){
            return "100%";
        } else if (TipusIncidencia.Neteja == tipusIncidencia) {
            return "50%";
        }else {
            return "0%";
        }
    }



public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };
}
