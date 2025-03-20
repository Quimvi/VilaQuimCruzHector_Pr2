package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    public CarreteraAsfalt(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
        super(nom, acces,accessibilitat,metresQuadrats, longitud);
    }
    // s'ha de fer
    public boolean isAccessibilitat(){

    }

    @Override
    public String toString() {
        return super.toString() + "Camí asfaltat ";
    }
}
