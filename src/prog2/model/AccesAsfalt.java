package prog2.model;

public abstract class AccesAsfalt extends Acces {
    // Atributs addicionals específics d'accés asfaltat
    protected float m2;     // Metres quadrats d'asfalt
    protected float kg;     // Pes màxim permès (en kg)

    /**
     * Constructor d'Accés Asfaltat
     * @param nom Nom de l'accés
     * @param accessibilitat Si permet vehicles (true) o només vianants (false)
     * @param estat Si està obert (true) o tancat (false)
     * @param m2 Metres quadrats d'asfalt
     * @param kg Pes màxim permès en kilograms
     */
    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, float m2, float kg) {
        super(nom, accessibilitat, estat);  // Crida al constructor de la classe pare (Acces)
        setM2(m2);    // Assigna els metres quadrats
        setKg(kg);     // Assigna el pes màxim
    }

    // Mètodes accessors

    /**
     * @return float Metres quadrats d'asfalt
     */
    public float getM2() {
        return this.m2;
    }

    /**
     * Assigna els metres quadrats d'asfalt
     * @param m2 Metres quadrats
     */
    public void setM2(float m2) {
        this.m2 = m2;
    }

    /**
     * @return float Pes màxim permès en kg
     */
    public float getKg() {
        return this.kg;
    }

    /**
     * Assigna el pes màxim permès
     * @param kg Pes en kilograms
     */
    public void setKg(float kg) {
        this.kg = kg;
    }

    /**
     * Representació textual de l'accés asfaltat
     * @return String amb la informació formatejada
     */
    @Override
    public String toString() {
        if (isAccessibilitat()) {  // Si permet vehicles
            return super.toString() + ", Metres quadrats: " + getM2() + ", Pes màxim: " + getKg();
        } else {  // Si només permet vianants
            return super.toString() + ", Metres quadrats: " + getM2() ;
        }
    }
}