package prog2.model;
import java.time.LocalDate;
import java.util.Objects;

public class Allotjament implements InAllotjament{
    // Atributs
    protected String nom_;
    protected String idAllotjament;
    protected boolean estatAllotjament;
    protected String estatIluminacio;
    protected long estadaMinimaALTA_;
    protected long estadaMinimaBAIXA_;

    // Constructor
    public Allotjament(String nom_, String idAllotjament, boolean estatAllotjament, String estatIluminacio, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        setNom(nom_);
        setId(idAllotjament);
        setEstatAllotjament(estatAllotjament);
        setElectricitat(estatIluminacio);
        setEstadaMinima(estadaMinimaALTA_, estadaMinimaBAIXA_);
        obrirAllotjament();
    }

    // Getters & Setters
    public String getNom() {
        return this.nom_;
    }

    public void setNom(String nom_) {
        this.nom_ = nom_;
    }

    public String getId() {
        return this.idAllotjament;
    }

    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    public String getElectricitat(){
        return this.estatIluminacio;
    }

    public void setElectricitat(String estatIluminacio){
        this.estatIluminacio = estatIluminacio;
    }

    public boolean getEstatAllotjament(){
        return this.estatAllotjament;
    }

    public void setEstatAllotjament(boolean estatAllotjament) {
        this.estatAllotjament = estatAllotjament;
    }

    public long getEstadaMinima(Temp temporada) {
        if (temporada == Temp.ALTA)
            return this.estadaMinimaALTA_;
        else
            return this.estadaMinimaBAIXA_;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    // Mètode per obtenir en quina temporada estem
    // Del 21 de març al 20 de setembre (temporada alta) i del 21 de setembre al 20 de març (temporada baixa)
    // no posa que s'agi de posar en la implementacio
    public Temp getTemporada(LocalDate data){
        Temp temporada;
        LocalDate date1 = LocalDate.of(data.getYear(),3,21);
        LocalDate date2 = LocalDate.of(data.getYear(),9,20);
        if (date1.isBefore(data) && date2.isAfter(data))
            temporada = Temp.ALTA;
        else
            temporada = Temp.BAIXA;

        return temporada;
    }

    public void tancarAllotjament(Incidencia in) {
        setEstatAllotjament(false);
        estatIluminacio = in.getIluminacioAllotjament();
    }

    public void obrirAllotjament() {
        setEstatAllotjament(true);
        estatIluminacio = "100%";
    }

    public String toString() {
        return "Nom=" + this.nom_ + ", Id=" + this.idAllotjament + ", estat allotjament: " + getEstatAllotjament() + ", estat electric: " + getElectricitat()
                + ", estada mínima en temp ALTA: " + this.estadaMinimaALTA_ + ", estada mínima en temp BAIXA: " + this.estadaMinimaBAIXA_ + "." + "\n";
    }
}