package prog2.model;



public class BungalowPremium extends Casa{
    // Atributs
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom_, String idAllotjament_,boolean estatAllotjament,String estatIluminacio, float mida,int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa,boolean tv,boolean aireFred, boolean serveisExtra,String codiWifi){
        super(nom_,idAllotjament_,estatAllotjament,estatIluminacio,4,7,mida,habitacions,placesPersones);
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
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

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public boolean isServeisExtra(){
        return this.serveisExtra;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    public String getCodiWifi() {
        return this.codiWifi;
    }

    // String amb tota la informació de l'allotjament
    public String toString() {
        return "Nom = " + this.nom_ + ", Id = " + this.idAllotjament + ", Mida = " + this.mida + ", Habitacions = " + this.habitacions + ", placesPersones = " + this.placesPersones
                + ", placesParquing = " + this.placesParquing + ", Terrassa = " + this.terrassa + ", tv = " + this.tv + ", aireFred = " + this.aireFred
                + ", serveisExtra = " + this.serveisExtra + ", codiWifi = " + this.codiWifi + ", estada mínima en temp ALTA = " + this.estadaMinimaALTA_
                + ", estada mínima en temp BAIXA = " + this.estadaMinimaBAIXA_;
    }
}