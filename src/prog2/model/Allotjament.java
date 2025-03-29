package prog2.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe que representa un allotjament en un sistema de gestió turística.
 * Implementa la interfície InAllotjament.
 */
public class Allotjament implements InAllotjament{

    // Atributs de la classe
    protected String nom_;                  // Nom de l'allotjament
    protected String idAllotjament;         // Identificador únic de l'allotjament
    protected boolean estatAllotjament;     // Estat (obert/tancat) de l'allotjament
    protected String estatIluminacio;       // Nivell d'il·luminació de l'allotjament
    protected long estadaMinimaALTA_;       // Estada mínima en temporada alta
    protected long estadaMinimaBAIXA_;      // Estada mínima en temporada baixa

    /**
     * Constructor de la classe Allotjament
     * @param nom_ Nom de l'allotjament
     * @param idAllotjament Identificador de l'allotjament
     * @param estatAllotjament Estat inicial (obert/tancat)
     * @param estatIluminacio Estat inicial de la il·luminació
     * @param estadaMinimaALTA_ Estada mínima en temporada alta
     * @param estadaMinimaBAIXA_ Estada mínima en temporada baixa
     */
    public Allotjament(String nom_, String idAllotjament, boolean estatAllotjament, String estatIluminacio, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        setNom(nom_);
        setId(idAllotjament);
        setEstatAllotjament(estatAllotjament);
        setElectricitat(estatIluminacio);
        setEstadaMinima(estadaMinimaALTA_, estadaMinimaBAIXA_);
        obrirAllotjament(); // Obre l'allotjament per defecte
    }

    // Mètodes Getters i Setters

    /**
     * Obté el nom de l'allotjament
     * @return String amb el nom
     */
    public String getNom() {
        return this.nom_;
    }

    /**
     * Estableix el nom de l'allotjament
     * @param nom_ Nou nom per a l'allotjament
     */
    public void setNom(String nom_) {
        this.nom_ = nom_;
    }

    /**
     * Obté l'identificador de l'allotjament
     * @return String amb l'ID
     */
    public String getId() {
        return this.idAllotjament;
    }

    /**
     * Estableix l'identificador de l'allotjament
     * @param idAllotjament Nou ID per a l'allotjament
     */
    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    /**
     * Obté l'estat de la il·luminació
     * @return String amb l'estat de la il·luminació
     */
    public String getElectricitat(){
        return this.estatIluminacio;
    }

    /**
     * Estableix l'estat de la il·luminació
     * @param estatIluminacio Nou estat de la il·luminació
     */
    public void setElectricitat(String estatIluminacio){
        this.estatIluminacio = estatIluminacio;
    }

    /**
     * Obté l'estat de l'allotjament (obert/tancat)
     * @return boolean true si està obert, false si està tancat
     */
    public boolean getEstatAllotjament(){
        return this.estatAllotjament;
    }

    /**
     * Estableix l'estat de l'allotjament
     * @param estatAllotjament Nou estat de l'allotjament
     */
    public void setEstatAllotjament(boolean estatAllotjament) {
        this.estatAllotjament = estatAllotjament;
    }

    /**
     * Obté l'estada mínima segons la temporada
     * @param temporada Temporada actual (ALTA o BAIXA)
     * @return long amb els dies d'estada mínima
     */
    public long getEstadaMinima(Temp temporada) {
        if (temporada == Temp.ALTA)
            return this.estadaMinimaALTA_;
        else
            return this.estadaMinimaBAIXA_;
    }

    /**
     * Estableix les estades mínimes per a ambdues temporades
     * @param estadaMinimaALTA_ Estada mínima en temporada alta
     * @param estadaMinimaBAIXA_ Estada mínima en temporada baixa
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    /**
     * Determina la temporada (ALTA o BAIXA) segons la data
     * Temporada alta: del 21 de març al 20 de setembre
     * Temporada baixa: de la resta de l'any
     * @param data Data a verificar
     * @return Temp (ALTA o BAIXA)
     */
    public Temp getTemporada(LocalDate data){
        Temp temporada;
        LocalDate date1 = LocalDate.of(data.getYear(),3,21);  // 21 de març
        LocalDate date2 = LocalDate.of(data.getYear(),9,20);   // 20 de setembre

        if (date1.isBefore(data) && date2.isAfter(data))
            temporada = Temp.ALTA;
        else
            temporada = Temp.BAIXA;

        return temporada;
    }

    /**
     * Tanca l'allotjament i registra una incidència
     * @param in Incidència que causa el tancament
     */
    public void tancarAllotjament(Incidencia in) {
        setEstatAllotjament(false);
        estatIluminacio = in.getIluminacioAllotjament();
    }

    /**
     * Obre l'allotjament i posa la il·luminació al 100%
     */
    public void obrirAllotjament() {
        setEstatAllotjament(true);
        estatIluminacio = "100%";
    }

    /**
     * Retorna una representació en String de l'allotjament
     * @return String amb tota la informació de l'allotjament
     */
    public String toString() {
        return "Nom=" + this.nom_ + ", Id=" + this.idAllotjament + ", estat allotjament: " + getEstatAllotjament() + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA: " + this.estadaMinimaALTA_ + ", estada mínima en temp BAIXA: " + this.estadaMinimaBAIXA_ + "." + "\n";
    }
}