import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.model.Allotjament;
import prog2.model.Incidencia;

public class IncidenciaTest {

    private Incidencia incidencia;
    private Allotjament allotjament;

    @Before
    public void setUp() {
        // Create a sample Allotjament
        allotjament = new Allotjament("Habitació Doble", "A1", true, "100%", 3, 1);

        // Create a sample Incidencia
        incidencia = new Incidencia(1, allotjament, "2023-06-15", Incidencia.TipusIncidencia.Reparacio);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, incidencia.getNumIncidencia());
        assertEquals(allotjament, incidencia.getAllotjament());
        assertEquals("2023-06-15", incidencia.getData());
        assertEquals(Incidencia.TipusIncidencia.Reparacio, incidencia.getTipusIncidencia());
    }

    @Test
    public void testSetGetNumIncidencia() {
        incidencia.setNumIncidencia(2);
        assertEquals(2, incidencia.getNumIncidencia());
    }

    @Test
    public void testSetGetAllotjament() {
        Allotjament newAllotjament = new Allotjament("Habitació Individual", "A2", true, "100%", 2, 1);
        incidencia.setAllotjament(newAllotjament);
        assertEquals(newAllotjament, incidencia.getAllotjament());
    }

    @Test
    public void testSetGetData() {
        incidencia.setData("2023-06-20");
        assertEquals("2023-06-20", incidencia.getData());
    }

    @Test
    public void testSetGetTipusIncidencia() {
        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Neteja);
        assertEquals(Incidencia.TipusIncidencia.Neteja, incidencia.getTipusIncidencia());

        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Tancament);
        assertEquals(Incidencia.TipusIncidencia.Tancament, incidencia.getTipusIncidencia());
    }

    @Test
    public void testToString() {
        String expected = "Número d'incidència: 1, Allotjament: A1, Data: 2023-06-15, Tipus: Reparacio\n";
        assertEquals(expected, incidencia.toString());
    }

    @Test
    public void testGetIluminacioAllotjament() {
        // Test Reparacio
        assertEquals("100%", incidencia.getIluminacioAllotjament());

        // Test Neteja
        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Neteja);
        assertEquals("50%", incidencia.getIluminacioAllotjament());

        // Test Tancament
        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Tancament);
        assertEquals("0%", incidencia.getIluminacioAllotjament());
    }

    @Test
    public void testTipusIncidenciaEnum() {
        // Verify enum values
        assertEquals(3, Incidencia.TipusIncidencia.values().length);
        assertEquals(Incidencia.TipusIncidencia.Reparacio, Incidencia.TipusIncidencia.valueOf("Reparacio"));
        assertEquals(Incidencia.TipusIncidencia.Neteja, Incidencia.TipusIncidencia.valueOf("Neteja"));
        assertEquals(Incidencia.TipusIncidencia.Tancament, Incidencia.TipusIncidencia.valueOf("Tancament"));
    }
}