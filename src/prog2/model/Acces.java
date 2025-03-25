package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;


public abstract class Acces implements InAcces{

    protected String nom;
    protected boolean accessibilitat; // true cotxe i caminant, false caminant
    protected boolean estat;
    protected LlistaAllotjaments llistaAllotjament;


    public Acces(String nom, boolean accessibilitat, boolean estat){
        setNom(nom);
        setAccessibilitat(accessibilitat);
        setEstat(estat);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public LlistaAllotjaments getLlistaAllotjament() {
        return llistaAllotjament;
    }

    public void setLlistaAllotjament (LlistaAllotjaments llistaAllotjament){
        this.llistaAllotjament = llistaAllotjament;
    }

    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat = accessibilitat;
    }

    public boolean getAccessibilitat(){
        return this.accessibilitat;
    }

    public void afegirAllotjament(Allotjament allotjament){
        llistaAllotjament.afegirAllotjament(allotjament);
    }

    public void tancarAcces(){
        setEstat(false);
    }

    public boolean getEstat(){
        return this.estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public void obrirAcces(){
        setEstat(true);
    }

    public boolean isAccessibilitat() {
        return getAccessibilitat();
    }
}