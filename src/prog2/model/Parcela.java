package prog2.model;

public class Parcela extends Allotjament{
    // Atributs
    private float metres;
    private boolean connexioElectrica;

    // Constructor
    public Parcela(String nom_,String idAllotjament, float metres,boolean connexioElectrica){
        super(nom_,idAllotjament,2,4);
        setConnexioElectrica(connexioElectrica);
        setMida(metres);
    }

    // Funcionament correcte si connexioElectrica = true
    @Override
    public boolean correcteFuncionament(){
        return this.connexioElectrica;
    }

    // Getters & Setters
    public float getMida() {
        return this.metres;
    }

    public void setMida(float metres) {
        this.metres = metres;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    public boolean isConnexioElectrica(){
        return this.connexioElectrica;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom=" + this.nom_ + ", Id=" + this.idAllotjament + ", estada mínima en temp ALTA: " + this.estadaMinimaALTA_ + ", estada mínima en temp BAIXA: " + this.estadaMinimaBAIXA_ + ".";
    }
}
