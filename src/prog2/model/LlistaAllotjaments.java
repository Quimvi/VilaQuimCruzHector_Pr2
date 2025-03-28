package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LlistaAllotjaments implements InAllotjament {

    private static ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments(){
        allotjaments = new ArrayList<Allotjament>();
    }

    public ArrayList<Allotjament> getAllotjaments(){
        return allotjaments;
    }

    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) && allotjamentLlist.getId().equals(allotjament.getNom())) {
                throw new ExcepcioCamping("Aquest allotjament ja es troba en allotjaments");
            }
            allotjaments.add(allotjament);

        }
    }

    public void buidar(){
        int i = 0;
        int e;
        while (i < allotjaments.size()){
            e = allotjaments.size() - 1;
            allotjaments.remove(e);
            }
        }

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
        if (!trobat){
            throw new ExcepcioCamping("No hi han allotjaments en aquest estat");
        }
        return concatenacioInfo.toString();
    }

    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getEstatAllotjament())
                return true;
        }
        return false;
    }

    public boolean contains(Allotjament allotjament){
        Iterator<Allotjament> itrAllot = allotjaments.iterator();

        while (itrAllot.hasNext()) {
            Allotjament allotjamentLlist = itrAllot.next();
            if (allotjamentLlist.getNom().equals(allotjament.getNom()) && allotjamentLlist.getId().equals(allotjament.getNom()))
                return true;
        }
        return false;
    }

    public Allotjament getAllotjament(String id) throws ExcepcioCamping{
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

