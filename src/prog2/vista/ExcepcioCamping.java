package prog2.vista;

/**
 * Classe que representa una excepció personalitzada per al sistema de gestió del camping.
 * Hereta de RuntimeException per no requerir captura obligatòria.
 */
public class ExcepcioCamping extends RuntimeException {

    /**
     * Constructor que crea una nova excepció amb un missatge específic
     * @param message Missatge descriptiu de l'error
     */
    public ExcepcioCamping(String message) {
        super(message);  // Crida al constructor de la classe pare (RuntimeException)
    }
}