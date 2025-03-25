package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {

    public CamiAsfaltat(String nom, boolean estat, float metresQuadrats){
        super(nom,false, estat, metresQuadrats, 0);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }

    @Override
    public String toString() {
        return "Camí asfaltat => " + super.toString();
    }
}