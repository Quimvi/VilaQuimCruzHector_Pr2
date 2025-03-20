package prog2.model;

public class Casa extends Allotjament{
    // Atributs
    protected String mida;
    protected int habitacions;
    protected int placesPersones;

    // Constructor
    public Casa(String nom_,String idAllotjament,long estadaMinimaALTA_,long estadaMinimaBAIXA_,String mida, int habitacions,int placesPersones){
        super(nom_,idAllotjament,estadaMinimaALTA_,estadaMinimaBAIXA_);
        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);
    }

    // Getters & Setters
    public int getHabitacions() {
        return this.habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

    public int getPlacesPersones() {
        return this.placesPersones;
    }

    public String getMida() {
        return this.mida;
    }

    public void setMida(String mida) {
        this.mida = mida;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}
