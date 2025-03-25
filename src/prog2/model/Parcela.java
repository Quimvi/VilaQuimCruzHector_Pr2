package prog2.model;

public class Parcela extends Allotjament{
    // Atributs
    private float mida;
    private boolean connexioElectrica;

    // Constructor
    public Parcela(String nom_,String idAllotjament, boolean estatAllotjament,String estatIluminacio, float mida,boolean connexioElectrica){
        super(nom_,idAllotjament,estatAllotjament,estatIluminacio,2,4);
        setConnexioElectrica(connexioElectrica);
        setMida(mida);
    }

    public boolean Operatiu() {
        return getEstatAllotjament();
    }

    // Getters & Setters
    public float getMida() {
        return this.mida;
    }

    public void setMida(float metres) {
        this.mida = metres;
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
