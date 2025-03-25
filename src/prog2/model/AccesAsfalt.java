package prog2.model;

public abstract class AccesAsfalt extends Acces{
    protected float m2;
    protected float kg;

    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, float m2, float kg){
        super(nom, accessibilitat, estat);
        setM2(m2);
        setKg(kg);
    }

    public float getM2() {
        return this.m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public float getKg() {
        return this.kg;
    }

    public void setKg(float kg) {
        this.kg = kg;
    }

    public String toString(){
        if (isAccessibilitat())
            return super.toString() + ", Metres quadrats: " + getM2() + ", Pes màxim: " + getKg();
        else
            return super.toString() + ", Metres quadrats: " + getM2();
    }
}

