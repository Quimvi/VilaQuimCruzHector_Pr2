package prog2.model;

public class CamiAsfalt extends AccesAsfalt{

    public CamiAsfalt(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
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
