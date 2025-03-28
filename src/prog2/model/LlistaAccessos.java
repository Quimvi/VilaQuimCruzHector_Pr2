package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos{
    private ArrayList<Acces> accessos;

    public LlistaAccessos(){
        this.accessos = new ArrayList<Acces>();
    }

    public void afegirAcces(Acces acc) throws ExcepcioCamping{
        Iterator<Acces> itrAcces = this.accessos.iterator();
        while (itrAcces.hasNext()) {
            Acces acces = itrAcces.next();
            if (acc.getNom().equals(acces.getNom())){
                throw new ExcepcioCamping("aquest acces ya existeix");
            }
        }
        accessos.add(acc);
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping{
        boolean trobat = false;
        StringBuffer concatenacioInfo = new StringBuffer();
        Iterator<Acces> itrAcces = this.accessos.iterator();
        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            if (estat && accesllista.getEstat()) {
                concatenacioInfo.append(accesllista.toString()); //mirar que funcioni correctament
                trobat = true;
            } else if (!estat && !accesllista.getEstat()) {
                concatenacioInfo.append(accesllista.toString());
                trobat = true;
            }
    }
        if (!trobat){
            throw new ExcepcioCamping("no hi han allotjaments en aquest estat");
        }
        return concatenacioInfo.toString();
    }


    public void actualitzaEstatAccessos() throws ExcepcioCamping{
        Iterator<Acces> itrAcces = this.accessos.iterator();


        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();

            if (accesllista.getLlistaAllotjament().containsAllotjamentOperatiu()){
                accesllista.obrirAcces();
            }else{
                accesllista.tancarAcces();
            }
            }
    }

    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int resultat = 0;
        Iterator<Acces> itrAcces = this.accessos.iterator();

        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            if (accesllista.getLlistaAllotjament().containsAllotjamentOperatiu()) {
                resultat ++;
            }
        }
        return resultat;
    }

    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping{
        float resultat = 0;
        Iterator<Acces> itrAcces = this.accessos.iterator();

        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            if (accesllista instanceof AccesAsfalt) {
                AccesAsfalt accesAsfalt = (AccesAsfalt) accesllista;
                resultat += accesAsfalt.getM2();
            }
        }
        return resultat;
    }

    public void buidar(){
        Iterator<Acces> itrAcces = this.accessos.iterator();
        Acces acces = itrAcces.next();
        while (itrAcces.hasNext()) {
            this.accessos.remove(acces);
            }

    }


}
