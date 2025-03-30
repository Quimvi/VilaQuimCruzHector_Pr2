import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaAccessosTest {

    private LlistaAccessos llistaAccessos;
    private Acces acces1;
    private Acces acces2;
    private Allotjament allotjament1;
    private Allotjament allotjament2;

    @Before
    public void setUp() {
        llistaAccessos = new LlistaAccessos();

        // Create test accessos (using concrete subclasses)
        acces1 = new CamiAsfaltat("A1", true, 100.0f);
        acces2 = new CamiTerra("A2", false, 200.0f);

        // Create test allotjaments
        allotjament1 = new Allotjament("Habitació Doble", "ALL1", true, "100%", 3, 1);
        allotjament2 = new Allotjament("Habitació Individual", "ALL2", false, "50%", 2, 1);
    }

    @Test
    public void testConstructor() {
        assertNotNull(llistaAccessos);
        assertEquals(0, llistaAccessos.calculaAccessosAccessibles());
    }

    @Test
    public void testAfegirAcces() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces1);
        assertEquals(1, llistaAccessos.getAccessos().size());

        llistaAccessos.afegirAcces(acces2);
        assertEquals(2, llistaAccessos.getAccessos().size());
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirAccesDuplicat() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces1);
        llistaAccessos.afegirAcces(acces1); // Should throw exception
    }

    @Test
    public void testLlistarAccessos() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces1); // Obert
        llistaAccessos.afegirAcces(acces2); // Tancat

        // Test llistar accessos oberts
        String oberts = llistaAccessos.llistarAccessos(true);

        // Test llistar accessos tancats
        String tancats = llistaAccessos.llistarAccessos(false);
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAccessosObertsSenseResultats() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces2); // Only closed access
        llistaAccessos.llistarAccessos(true); // Should throw exception
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAccessosTancatsSenseResultats() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces1); // Only open access
        llistaAccessos.llistarAccessos(false); // Should throw exception
    }

    @Test
    public void testActualitzaEstatAccessos() throws ExcepcioCamping {
        // Add accommodations to access
        acces1.afegirAllotjament(allotjament1); // Operatiu
        acces1.afegirAllotjament(allotjament2); // No operatiu

        llistaAccessos.afegirAcces(acces1);
        llistaAccessos.afegirAcces(acces2);

        // Initially both are in their default states
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());

        // Update states
        llistaAccessos.actualitzaEstatAccessos();

        // acces1 should remain open (has at least one operational accommodation)
        assertTrue(acces1.getEstat());

        // acces2 should remain closed (has no accommodations)
        assertFalse(acces2.getEstat());
    }

    @Test
    public void testCalculaAccessosAccessibles() throws ExcepcioCamping {
        // Setup access with operational accommodation
        acces1.afegirAllotjament(allotjament1);
        llistaAccessos.afegirAcces(acces1);

        // Setup access with non-operational accommodation
        acces2.afegirAllotjament(allotjament2);
        llistaAccessos.afegirAcces(acces2);

        assertEquals(1, llistaAccessos.calculaAccessosAccessibles());
    }

    @Test
    public void testCalculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        // Add asphalted access (CamiAsfaltat)
        llistaAccessos.afegirAcces(acces1); // 100.0f m2

        // Add non-asphalted access (CamiTerra)
        llistaAccessos.afegirAcces(acces2); // Not counted

        assertEquals(100.0f, llistaAccessos.calculaMetresQuadratsAsfalt(), 0.001);
    }

    @Test
    public void testBuidar() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(acces1);
        llistaAccessos.afegirAcces(acces2);
        assertEquals(2, llistaAccessos.getAccessos().size());

        llistaAccessos.buidar();
        assertEquals(0, llistaAccessos.getAccessos().size());
    }
}