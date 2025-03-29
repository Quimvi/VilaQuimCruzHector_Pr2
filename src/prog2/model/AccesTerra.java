package prog2.model;

public abstract class AccesTerra extends Acces {
    // Atributs específics per a accessos de terra
    protected float longitud;  // Longitud de l'accés en metres
    protected float amplada;   // Amplada de l'accés en metres

    /**
     * Constructor d'Accés de Terra
     * @param nom Nom identificatiu de l'accés
     * @param accessibilitat Indica si permet vehicles (true) o només vianants (false)
     * @param estat Estat d'obertura (true = obert, false = tancat)
     * @param longitud Longitud de l'accés en metres
     * @param amplada Amplada de l'accés en metres
     */
    public AccesTerra(String nom, boolean accessibilitat, boolean estat, float longitud, float amplada) {
        super(nom, accessibilitat, estat);  // Crida al constructor de la classe pare (Acces)
        setLongitud(longitud);  // Assigna la longitud
        setAmplada(amplada);    // Assigna l'amplada
    }

    // Mètodes accessors per a longitud

    /**
     * @return float Longitud actual de l'accés
     */
    public float getLongitud() {
        return this.longitud;
    }

    /**
     * Estableix la longitud de l'accés
     * @param longitudTerra Nova longitud en metres
     */
    public void setLongitud(float longitudTerra) {
        this.longitud = longitudTerra;
    }

    // Mètodes accessors per a amplada

    /**
     * @return float Amplada actual de l'accés
     */
    public float getAmplada() {
        return this.amplada;
    }

    /**
     * Estableix l'amplada de l'accés
     * @param ampladaTerra Nova amplada en metres
     */
    public void setAmplada(float ampladaTerra) {
        this.amplada = ampladaTerra;
    }

    /**
     * Sobreescriptura del mètode toString()
     * @return String Informació completa de l'accés formatada
     */
    public String toString() {
        if (isAccessibilitat()) {
            // Si permet vehicles, mostra tota la informació
            return super.toString() + ", Longitud: " + getLongitud() + ", Amplada: " + getAmplada();
        } else {
            // Si només permet vianants, mostra només la longitud
            return super.toString() + ", Longitud: " + getLongitud();
        }
    }
}