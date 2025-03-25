package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float metresCuadrats, float amplada){
        super(nom,true, estat, metresCuadrats, amplada);
        setAmplada(amplada);
    }

    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat(){
        return true;
    }

    @Override
    public String toString() {
        return "Camí asfaltat => " + super.toString();
    }
}