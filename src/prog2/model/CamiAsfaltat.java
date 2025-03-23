package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {

    public CamiAsfaltat(String nom, boolean estat, float metresCuadrats){
        super(nom,false, estat,metresCuadrats);
    }
    // s'ha de fer
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Camí asfaltat ";
    }
}
