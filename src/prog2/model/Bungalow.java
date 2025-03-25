package prog2.model;


public class Bungalow extends Casa{
    // Atributs
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    // Constructor
    public Bungalow(String nom_, String idAllotjament_,boolean estatAllotjament, String estatIluminacio, float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa,boolean tv,boolean aireFred){
        super(nom_,idAllotjament_,estatAllotjament,estatIluminacio,4,7,mida,habitacions,placesPersones);
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    @Override
    public boolean Operatiu() {
        return super.Operatiu();
    }

    // Getters & Setters
    public int getPlacesParquing() {
        return this.placesParquing;
    }

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTerrassa(){
        return this.terrassa;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isTv(){
        return this.tv;
    }

    public boolean isAireFred(){
        return this.aireFred;
    }

    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions
                + ", placesPersones = " + this.placesPersones + ", placesParquing = " + this.placesParquing + ", Terrassa = " + this.terrassa
                + ", tv = " + this.tv + ", aireFred = " + this.aireFred + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}
