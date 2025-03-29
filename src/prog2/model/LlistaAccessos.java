package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que gestiona una llista d'accessos al camping, implementant la interfície InLlistaAccessos.
 * Permet afegir, llistar i gestionar els accessos del camping.
 */
public class LlistaAccessos implements InLlistaAccessos {

    // Llista interna per emmagatzemar els accessos
    private final ArrayList<Acces> accessos;

    /**
     * Constructor que inicialitza la llista d'accessos
     */
    public LlistaAccessos() {
        this.accessos = new ArrayList<Acces>();
    }

    /**
     * Afegeix un nou accés a la llista
     * @param acc Accés a afegir
     * @throws ExcepcioCamping Si l'accés ja existeix
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        // Verifica que no existeixi un accés amb el mateix nom
        Iterator<Acces> itrAcces = this.accessos.iterator();
        while (itrAcces.hasNext()) {
            Acces acces = itrAcces.next();
            if (acc.getNom().equals(acces.getNom())) {
                throw new ExcepcioCamping("Aquest accés ja existeix");
            }
        }
        accessos.add(acc);
    }

    /**
     * Llista els accessos segons el seu estat (oberts o tancats)
     * @param estat true per accessos oberts, false per tancats
     * @return String amb la informació dels accessos
     * @throws ExcepcioCamping Si no hi ha accessos en l'estat sol·licitat
     */
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        boolean trobat = false;
        StringBuffer concatenacioInfo = new StringBuffer();

        // Recorre tots els accessos i filtra per estat
        Iterator<Acces> itrAcces = this.accessos.iterator();
        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            if (estat && accesllista.getEstat()) {
                concatenacioInfo.append(accesllista.toString());
                trobat = true;
            } else if (!estat && !accesllista.getEstat()) {
                concatenacioInfo.append(accesllista.toString());
                trobat = true;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("No hi ha accessos en aquest estat");
        }
        return concatenacioInfo.toString();
    }

    /**
     * Actualitza l'estat dels accessos en funció dels allotjaments operatius
     * @throws ExcepcioCamping Si hi ha algun error en l'actualització
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> itrAcces = this.accessos.iterator();

        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            // Obre o tanca l'accés segons si té allotjaments operatius
            if (accesllista.getLlistaAllotjament().containsAllotjamentOperatiu()) {
                accesllista.obrirAcces();
            } else {
                accesllista.tancarAcces();
            }
        }
    }

    /**
     * Calcula el nombre d'accessos accessibles (amb allotjaments operatius)
     * @return Nombre d'accessos accessibles
     * @throws ExcepcioCamping Si hi ha algun error en el càlcul
     */
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int resultat = 0;
        Iterator<Acces> itrAcces = this.accessos.iterator();

        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            if (accesllista.getLlistaAllotjament().containsAllotjamentOperatiu()) {
                resultat++;
            }
        }
        return resultat;
    }

    /**
     * Calcula els metres quadrats totals d'asfalt dels accessos
     * @return Metres quadrats d'asfalt totals
     * @throws ExcepcioCamping Si hi ha algun error en el càlcul
     */
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float resultat = 0;
        Iterator<Acces> itrAcces = this.accessos.iterator();

        while (itrAcces.hasNext()) {
            Acces accesllista = itrAcces.next();
            // Suma només els metres dels accessos asfaltats
            if (accesllista instanceof AccesAsfalt) {
                AccesAsfalt accesAsfalt = (AccesAsfalt) accesllista;
                resultat += accesAsfalt.getM2();
            }
        }
        return resultat;
    }

    /**
     * Buida la llista d'accessos
     */
    public void buidar() {
        this.accessos.clear();
    }
}