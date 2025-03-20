package prog2.model;

public class CarreteraTerra extends AccesTerra{
    public CarreteraTerra(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
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
