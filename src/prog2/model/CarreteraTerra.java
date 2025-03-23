package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float metresCuadrats, float amplada){
        super(nom,true, estat,metresCuadrats);
        setAmplada(amplada);
    }
    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(float pesMaxim) {
        this.amplada = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat(){
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Camí asfaltat ";
    }
}
