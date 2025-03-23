package prog2.model;

public abstract class AccesTerra extends Acces{
    protected float longitud;

    public AccesTerra(String nom, boolean accessibilitat, boolean estat, float longitud){
        super(nom, accessibilitat,estat);
        setLongitud(longitud);
    }
    public abstract boolean isAccessibilitat();

    public float getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitudTerra) {
        this.longitud = longitudTerra;
    }

    //acabar soc un bago
    public String toString(){
        return super.toString() + " longitud: " + getLongitud();//+ ja ho fare;
    }
}


