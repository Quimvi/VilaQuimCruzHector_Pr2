package prog2.model;

public abstract class AccesAsfalt extends Acces{
    protected float m2;

    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, float m2){
        super(nom, accessibilitat,estat);
        setM2(m2);
    }
    public abstract boolean isAccessibilitat();

    public float getM2() {
        return this.m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    //acabar soc un bago
    public String toString(){
        return super.toString() + " metres cuadrats: " + getM2();
    }
}

