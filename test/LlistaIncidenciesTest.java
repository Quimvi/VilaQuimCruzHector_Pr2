import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.model.Allotjament;
import prog2.model.Incidencia;
import prog2.model.LlistaIncidencies;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaIncidenciesTest {

    private LlistaIncidencies llistaIncidencies;
    private Allotjament allotjament;
    private Incidencia incidenciaReparacio;
    private Incidencia incidenciaNeteja;

    @Before
    public void setUp() {
        // Reset static list before each test
        LlistaIncidencies.incidencies = new ArrayList<>();
        llistaIncidencies = new LlistaIncidencies();

        // Create test accommodation
        allotjament = new Allotjament("Habitació Doble", "ALL1", true, "100%", 3, 1);

        // Create test incidents
        incidenciaReparacio = new Incidencia(1, allotjament, "2023-06-15",
                Incidencia.TipusIncidencia.Reparacio);
        incidenciaNeteja = new Incidencia(2, allotjament, "2023-06-16",
                Incidencia.TipusIncidencia.Neteja);
    }

    @Test
    public void testConstructor() {
        assertNotNull(llistaIncidencies);
        assertEquals(0, LlistaIncidencies.incidencies.size());
    }

    @Test
    public void testAfegirIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2023-06-15");
        assertEquals(1, LlistaIncidencies.incidencies.size());

        // Verify accommodation was closed
        assertFalse(allotjament.getEstatAllotjament());
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirIncidenciaTipusInvalid() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Invalid", allotjament, "2023-06-15");
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirIncidenciaAllotjamentNoOperatiu() throws ExcepcioCamping {
        // Close accommodation first
        allotjament.tancarAllotjament(incidenciaReparacio);
        llistaIncidencies.afegirIncidencia(2, "Neteja", allotjament, "2023-06-16");
    }

    @Test
    public void testEliminarIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2023-06-15");
        assertEquals(1, LlistaIncidencies.incidencies.size());

        Incidencia toRemove = llistaIncidencies.getIncidencia(1);
        llistaIncidencies.eliminarIncidencia(toRemove);

        assertEquals(0, LlistaIncidencies.incidencies.size());
        // Verify accommodation was reopened
        assertTrue(allotjament.getEstatAllotjament());
    }

    @Test(expected = ExcepcioCamping.class)
    public void testEliminarIncidenciaNoExistent() throws ExcepcioCamping {
        llistaIncidencies.eliminarIncidencia(incidenciaReparacio);
    }

    @Test
    public void testLlistarIncidencies() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2023-06-15");

        String result = llistaIncidencies.llistarIncidencies();
        assertTrue(result.contains("Reparacio"));
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarIncidenciesBuida() throws ExcepcioCamping {
        llistaIncidencies.llistarIncidencies();
    }

    @Test
    public void testGetIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2023-06-15");

        Incidencia found = llistaIncidencies.getIncidencia(1);
        assertEquals(1, found.getNumIncidencia());
        assertEquals(allotjament, found.getAllotjament());
    }

    @Test(expected = ExcepcioCamping.class)
    public void testGetIncidenciaNoExistent() throws ExcepcioCamping {
        llistaIncidencies.getIncidencia(999);
    }

    @Test
    public void testMultipleOperations() throws ExcepcioCamping {
        // Add incident
        llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2023-06-15");
        assertEquals(1, LlistaIncidencies.incidencies.size());
        assertFalse(allotjament.getEstatAllotjament());

        // List incidents
        String list = llistaIncidencies.llistarIncidencies();
        assertTrue(list.contains("Reparacio"));

        // Get incident
        Incidencia inc = llistaIncidencies.getIncidencia(1);
        assertEquals(1, inc.getNumIncidencia());

        // Remove incident
        llistaIncidencies.eliminarIncidencia(inc);
        assertEquals(0, LlistaIncidencies.incidencies.size());
        assertTrue(allotjament.getEstatAllotjament());
    }
}