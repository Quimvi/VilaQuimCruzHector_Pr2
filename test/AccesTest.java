package prog2.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.vista.ExcepcioCamping;
import java.time.LocalDate;

public class AccesTest {

    // Concrete subclass for testing the abstract Acces class
    private class TestAcces extends Acces {
        public TestAcces(String nom, boolean accessibilitat, boolean estat) {
            super(nom, accessibilitat, estat);
        }
    }

    private Acces acces;
    private Allotjament allotjament1;
    private Allotjament allotjament2;

    @Before
    public void setUp() {
        acces = new TestAcces("Test Access", true, false);
        // Create Allotjament objects with proper parameters
        allotjament1 = new Allotjament("Habitació Doble", "A1", true, "100%", 3, 1);
        allotjament2 = new Allotjament("Habitació Individual", "A2", true, "100%", 2, 1);
    }

    @Test
    public void testConstructor() {
        assertEquals("Test Access", acces.getNom());
        assertTrue(acces.getAccessibilitat());
        assertFalse(acces.getEstat());
        assertNotNull(acces.getLlistaAllotjament());
        assertEquals(0, acces.getLlistaAllotjament().getAllotjaments().size());
    }

    @Test
    public void testSetGetNom() {
        acces.setNom("New Name");
        assertEquals("New Name", acces.getNom());
    }

    @Test
    public void testSetGetAccessibilitat() {
        acces.setAccessibilitat(false);
        assertFalse(acces.getAccessibilitat());
        assertFalse(acces.isAccessibilitat());

        acces.setAccessibilitat(true);
        assertTrue(acces.getAccessibilitat());
        assertTrue(acces.isAccessibilitat());
    }

    @Test
    public void testSetGetEstat() {
        acces.setEstat(true);
        assertTrue(acces.getEstat());

        acces.setEstat(false);
        assertFalse(acces.getEstat());
    }

    @Test
    public void testObrirTancarAcces() {
        acces.obrirAcces();
        assertTrue(acces.getEstat());

        acces.tancarAcces();
        assertFalse(acces.getEstat());
    }

    @Test
    public void testAfegirAllotjament() throws ExcepcioCamping {
        assertEquals(0, acces.getLlistaAllotjament().getAllotjaments().size());

        acces.afegirAllotjament(allotjament1);
        assertEquals(1, acces.getLlistaAllotjament().getAllotjaments().size());
        assertTrue(acces.getLlistaAllotjament().contains(allotjament1));

        acces.afegirAllotjament(allotjament2);
        assertEquals(2, acces.getLlistaAllotjament().getAllotjaments().size());
        assertTrue(acces.getLlistaAllotjament().contains(allotjament2));
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirAllotjamentDuplicat() throws ExcepcioCamping {
        acces.afegirAllotjament(allotjament1);
        // Try to add the same accommodation again
        acces.afegirAllotjament(allotjament1);
    }

    @Test
    public void testSetLlistaAllotjament() throws ExcepcioCamping {
        LlistaAllotjaments novaLlista = new LlistaAllotjaments();
        novaLlista.afegirAllotjament(allotjament1);
        novaLlista.afegirAllotjament(allotjament2);

        acces.setLlistaAllotjament(novaLlista);

        assertEquals(2, acces.getLlistaAllotjament().getAllotjaments().size());
        assertTrue(acces.getLlistaAllotjament().contains(allotjament1));
        assertTrue(acces.getLlistaAllotjament().contains(allotjament2));
    }

    @Test
    public void testEmptyLlistaAllotjament() {
        assertNotNull(acces.getLlistaAllotjament());
        assertEquals(0, acces.getLlistaAllotjament().getAllotjaments().size());
    }

    @Test
    public void testBuidarLlistaAllotjament() throws ExcepcioCamping {
        acces.afegirAllotjament(allotjament1);
        acces.afegirAllotjament(allotjament2);
        assertEquals(2, acces.getLlistaAllotjament().getAllotjaments().size());

        acces.getLlistaAllotjament().buidar();
        assertEquals(0, acces.getLlistaAllotjament().getAllotjaments().size());
    }

    @Test
    public void testAllotjamentStateAfterAdding() throws ExcepcioCamping {
        // Verify initial state
        assertTrue(allotjament1.getEstatAllotjament());
        assertEquals("100%", allotjament1.getElectricitat());

        // Add to access and verify state remains unchanged
        acces.afegirAllotjament(allotjament1);
        assertTrue(allotjament1.getEstatAllotjament());
        assertEquals("100%", allotjament1.getElectricitat());
    }

    @Test
    public void testAllotjamentProperties() {
        assertEquals("Habitació Doble", allotjament1.getNom());
        assertEquals("A1", allotjament1.getId());
        assertTrue(allotjament1.getEstatAllotjament());
        assertEquals("100%", allotjament1.getElectricitat());
        assertEquals(3, allotjament1.getEstadaMinima(Allotjament.Temp.ALTA));
        assertEquals(1, allotjament1.getEstadaMinima(Allotjament.Temp.BAIXA));
    }

    @Test
    public void testTemporadaCalculation() {
        // Test high season date
        LocalDate highSeasonDate = LocalDate.of(2023, 6, 15);
        assertEquals(Allotjament.Temp.ALTA, allotjament1.getTemporada(highSeasonDate));

        // Test low season date
        LocalDate lowSeasonDate = LocalDate.of(2023, 10, 15);
        assertEquals(Allotjament.Temp.BAIXA, allotjament1.getTemporada(lowSeasonDate));
    }
}