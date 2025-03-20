package prog2.model;

public class AccesAsfalt extends Acces{
    protected int metresQuadratsAsfalt;
    protected int longitudAsfalt;

    public AccesAsfalt(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
        super(nom, acces, accessibilitat);
        setMetresQuadrats(metresQuadrats);
        setLongitud(longitud);
    }

    public int getLongitud() {
        return this.longitudAsfalt;
    }

    public int getMetresQuadrats() {
        return metresQuadratsAsfalt;
    }

    public void setLongitud(int longitudAsfalt) {
        this.longitudAsfalt = longitudAsfalt;
    }

    public void setMetresQuadrats(int metresQuadratsAsfalt) {
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    //acabar soc un bago
    public String toString(){
        return super.toString() //+ ja ho fare;
    }
}
