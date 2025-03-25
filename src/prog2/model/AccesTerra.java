package prog2.model;

public abstract class AccesTerra extends Acces{
    protected float longitud;
    protected float amplada;

    public AccesTerra(String nom, boolean accessibilitat, boolean estat, float longitud, float amplada){
        super(nom, accessibilitat, estat);
        setLongitud(longitud);
        setAmplada(amplada);
    }

    public float getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitudTerra) {
        this.longitud = longitudTerra;
    }

    public float getAmplada() {
        return this.amplada;
    }

    public void setAmplada(float ampladaTerra) {
        this.amplada = ampladaTerra;
    }

    public String toString(){
        if (isAccessibilitat())
            return super.toString() + ", Longitud: " + getLongitud() + ", Amplada: " + getAmplada();
        else
            return super.toString() + ", Longitud: " + getLongitud();
    }
}


