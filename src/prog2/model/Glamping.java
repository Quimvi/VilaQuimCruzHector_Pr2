package prog2.model;

public class Glamping extends Casa{
    // Atributs
    private String material;
    private boolean casaMascota;

    // Constructor
    public Glamping(String nom_, String idAllotjament_,String mida, int habitacions, int placesPersones,String material,boolean casaMascota ){
        super(nom_,idAllotjament_,3,5,mida,habitacions,placesPersones);
        setMaterial(material);
        setCasaMascota(casaMascota);
    }

    // Funcionament correcte si casaMascota = true
    @Override
    public boolean correcteFuncionament(){
        return this.casaMascota;
    }

    // Getters & Setters
    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean getCasaMascota(){
        return this.casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones + ", Material = " + this.material + ", casaMascota = " + this.casaMascota
                + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_ + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}
