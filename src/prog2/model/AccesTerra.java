package prog2.model;

public class AccesTerra extends Acces{
    protected int metresQuadratsTerra;
    protected int longitudTerra;

    public AccesTerra(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
        super(nom, acces, accessibilitat);
        setMetresQuadrats(metresQuadrats);
        setLongitud(longitud);
    }

    public int getLongitud() {
        return this.longitudTerra;
    }

    public int getMetresQuadrats() {
        return metresQuadratsTerra;
    }

    public void setLongitud(int longitudTerra) {
        this.longitudTerra = longitudTerra;
    }

    public void setMetresQuadrats(int metresQuadratsTerra) {
        this.metresQuadratsTerra = metresQuadratsTerra;
    }

    //acabar soc un bago
    public String toString(){
        return super.toString() //+ ja ho fare;
    }
}


