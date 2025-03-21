package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments {

    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments(){
        this.allotjaments = new ArrayList<Allotjament>();
    }

    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        Iterator<Allotjament> itrAllot = this.allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) && allotjamentLlist.getId().equals(allotjament.getNom())) {
                throw new ExcepcioCamping("Aquest allotjament ja es troba en allotjaments");
            }
            this.allotjaments.add(allotjament);

        }
    }

    public void buidar(){
        int i = 0;
        int e;
        while (i < this.allotjaments.size()){
            e = allotjaments.size() - 1;
            this.allotjaments.remove(e);
            }
        }

        // s'ha de fer
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
    /*
    El mètode llistarAllotjaments de la classe LlistaAllotjaments rep un String estat que podrà ser "Operatiu", "No Operatiu" i "Tots".
    Aquesta informació s'ha de traslladar a un boolean estatBoolean per tal que al recòrrer la llista d'Allotjaments es pugui saber quins s'han de seleccionar per concatenar la seva informació al String de return.
    Podeu fer servir una condició com:

    if(allotjament.isOperatiu()==estatB || estat.equals("Tots")) {...}
     */
    }

    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itrAllot = this.allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getEstatAllotjament())
                return true;
        }
        return false;
    }

    public boolean contains(Allotjament allotjament){
        Iterator<Allotjament> itrAllot = this.allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) && allotjamentLlist.getId().equals(allotjament.getNom()))
                return true;
        }
        return false;
    }

    public Allotjament getAllotjament(String nom) throws ExcepcioCamping{
        Iterator<Allotjament> itrAllot = this.allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(nom)) {
                return allotjamentLlist;
            }
        }
        throw new ExcepcioCamping("Aquest allotjament no es troba en allotjaments");
    }
}

