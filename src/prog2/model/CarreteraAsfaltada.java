package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {
    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, float metresCuadrats, float pesMaxim){
        super(nom,true, estat, metresCuadrats, pesMaxim);
        setPesMaxim(pesMaxim);
    }

    public float getPesMaxim() {
        return this.pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
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