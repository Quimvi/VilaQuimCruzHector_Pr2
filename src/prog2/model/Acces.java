package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;


public class Acces {
    protected String nom;
    protected boolean acces;
    protected boolean accessibilitat; // true cotxe i caminant, false caminant
    protected ArrayList<Allotjament> llistaAllotjament;


    public Acces(String nom, boolean acces, boolean accessibilitat){
        setNom(nom);
        obrirAcces();
        setAccessibilitat(accessibilitat);
        this.llistaAllotjament = new ArrayList<Allotjament>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public ArrayList<Allotjament> getLlistaAllotjament() {
        return llistaAllotjament;
    }

    public void setLlistaAllotjament (ArrayList<Allotjament> llistaAllotjament){
        this.llistaAllotjament = llistaAllotjament;
    }

    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat = accessibilitat;
    }

    public void afegirAllotjament(Allotjament allotjament){
        llistaAllotjament.add(allotjament);
    }

    public void tancarAcces(){
        this.acces = false;
    }

    public boolean getAcces(){
        return this.acces;
    }
    public void obrirAcces(){
        this.acces = true;
    }

    public boolean isAccessibilitat(){
        return this.accessibilitat;
    }

 // acabar
    public String toString() {
        return ; // son un bago
    }
}
