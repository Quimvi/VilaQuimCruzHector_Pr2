package prog2.model;

public class MobileHome extends Casa{
    // Atribut
    private boolean terrassaBarbacoa;

    // Constructor
    public MobileHome(String nom_, String idAllotjament_, String mida,int habitacions, int placesPersones,boolean terrassaBarbacoa){
        super(nom_, idAllotjament_, 3,5, mida,habitacions,placesPersones);
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    // Funcionament correcte si terrassaBarbacoa = true
    @Override
    public boolean correcteFuncionament(){
        return this.terrassaBarbacoa;
    }

    // Getters & Setters
    public boolean getTerrassaBarbacoa(){
        return this.terrassaBarbacoa;
    }
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions + ", placesPersones = " + this.placesPersones
                + ", terrassaBarbacoa = " + this.terrassaBarbacoa + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_ + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}
