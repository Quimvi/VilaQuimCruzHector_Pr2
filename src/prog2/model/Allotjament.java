package prog2.model;
import java.time.LocalDate;

public class Allotjament implements InAllotjament{
    // Atributs
    protected String nom_;
    protected String idAllotjament;
    protected boolean estatAllotjament;
    protected String electricitat;
    protected long estadaMinimaALTA_;
    protected long estadaMinimaBAIXA_;

    // Constructor
    public Allotjament(String nom_, String idAllotjament,long estadaMinimaALTA_,long estadaMinimaBAIXA_){
        setNom(nom_);
        setId(idAllotjament);
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
        return this.electricitat;
    }

    public void setElectricitat(String electricitat){
        this.electricitat = electricitat;
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

    public void tancarAllotjament(Incidencia in){}

    public void obrirAllotjament(){}

    public boolean correcteFuncionament(){
        return true;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom=" + this.nom_ + ", Id=" + this.idAllotjament + ", estada mínima en temp ALTA: " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA: " + this.estadaMinimaBAIXA_ + ".";
    }
}
