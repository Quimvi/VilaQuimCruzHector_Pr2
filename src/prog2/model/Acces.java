package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Acces implements InAcces {
    // Atributs de classe
    protected String nom; // Nom de l'accés
    protected boolean accessibilitat; // true: accessible per cotxe i a peu, false: només a peu
    protected boolean estat; // true: obert, false: tancat
    protected LlistaAllotjaments llistaAllotjament = new LlistaAllotjaments(); // Llista d'allotjaments associats

    // Constructor
    public Acces(String nom, boolean accessibilitat, boolean estat) {
        setNom(nom); // Assigna el nom
        setAccessibilitat(accessibilitat); // Assigna l'accessibilitat
        setEstat(estat); // Assigna l'estat inicial
    }

    // Setters i Getters

    public void setNom(String nom) {
        this.nom = nom; // Estableix el nom de l'accés
    }

    public String getNom() {
        return this.nom; // Retorna el nom de l'accés
    }

    public LlistaAllotjaments getLlistaAllotjament() {
        return llistaAllotjament; // Retorna la llista d'allotjaments
    }

    public void setLlistaAllotjament(LlistaAllotjaments llistaAllotjament) {
        this.llistaAllotjament = llistaAllotjament; // Assigna una nova llista d'allotjaments
    }

    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat = accessibilitat; // Defineix el tipus d'accessibilitat
    }

    public boolean getAccessibilitat() {
        return this.accessibilitat; // Consulta l'accessibilitat
    }

    // Mètodes funcionals

    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjament.afegirAllotjament(allotjament); // Afegeix un allotjament a la llista
    }

    public void tancarAcces() {
        setEstat(false); // Tanca l'accés (estat = false)
    }

    public boolean getEstat() {
        return this.estat; // Consulta l'estat (obert/tancat)
    }

    public void setEstat(boolean estat) {
        this.estat = estat; // Canvia l'estat d'obertura
    }

    public void obrirAcces() {
        setEstat(true); // Obre l'accés (estat = true)
    }

    public boolean isAccessibilitat() {
        return getAccessibilitat(); // Mètode redundant que consulta l'accessibilitat
    }
}