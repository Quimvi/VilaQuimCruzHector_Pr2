import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.model.Acces;
import prog2.model.Allotjament;
import prog2.model.Camping;
import prog2.vista.ExcepcioCamping;
import java.io.*;

public class CampingTest {

    private Camping camping;
    private Allotjament allotjament1;
    private Acces acces1;

    @Before
    public void setUp() {
        camping = new Camping("Camping de Test");
        camping.inicialitzaDadesCamping();

        try {
            allotjament1 = camping.getLlistaAllotjaments().getAllotjament("ALL1");
        } catch (ExcepcioCamping e) {
            fail("Error in setup: " + e.getMessage());
        }
    }

    @Test
    public void testConstructor() {
        assertEquals("Camping de Test", camping.getNomCamping());
        assertNotNull(camping.getLlistaAllotjaments());
        assertNotNull(camping.getLlistaAccessos());
        assertNotNull(camping.getLlistaIncidencies());
    }

    @Test
    public void testSetGetNomCamping() {
        camping.setNomCamping("Nou Camping");
        assertEquals("Nou Camping", camping.getNomCamping());
    }

    @Test
    public void testLlistarAllotjaments() {
        try {
            String result = camping.llistarAllotjaments("Tots");
            assertNotNull(result);
            assertTrue(result.contains("Parcel·la Nord"));

            result = camping.llistarAllotjaments("Operatiu");
            assertNotNull(result);

            result = camping.llistarAllotjaments("No operatiu");
            assertNotNull(result);
        } catch (ExcepcioCamping e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAllotjamentsInvalidEstat() throws ExcepcioCamping {
        camping.llistarAllotjaments("Invalid");
    }

    @Test
    public void testLlistarAccessos() {
        try {
            String result = camping.llistarAccessos("Obert");
            assertNotNull(result);

            result = camping.llistarAccessos("Tancat");
            assertNotNull(result);
        } catch (ExcepcioCamping e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAccessosInvalidEstat() throws ExcepcioCamping {
        camping.llistarAccessos("Invalid");
    }

    @Test
    public void testLlistarIncidencies() {
        try {
            String result = camping.llistarIncidencies();
            assertNotNull(result);
        } catch (ExcepcioCamping e) {
        }
    }

    @Test
    public void testAfegirEliminarIncidencia() {
        try {
            camping.afegirIncidencia(1, "Reparacio", "ALL1", "2023-06-15");

            String incidents = camping.llistarIncidencies();
            assertTrue(incidents.contains("ALL1"));

            assertFalse(allotjament1.getEstatAllotjament());

            camping.eliminarIncidencia(1);

            assertTrue(allotjament1.getEstatAllotjament());

        } catch (ExcepcioCamping e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirIncidenciaInvalidAllotjament() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Reparacio", "INVALID", "2023-06-15");
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirIncidenciaInvalidTipus() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Invalid", "ALL1", "2023-06-15");
    }

    @Test
    public void testCalculaAccessosAccessibles() {
        int accessibleAccessos = camping.calculaAccessosAccessibles();
        assertTrue(accessibleAccessos > 0);
    }

    @Test
    public void testCalculaMetresQuadratsAsfalt() {
        float metresAsfalt = camping.calculaMetresQuadratsAsfalt();
        assertTrue(metresAsfalt > 0);
    }

    @Test
    public void testSaveAndLoad() {
        String testFile = "test_camping.dat";

        try {
            camping.save(testFile);

            Camping loadedCamping = Camping.load(testFile);

            assertEquals(camping.getNomCamping(), loadedCamping.getNomCamping());
            assertEquals(camping.getLlistaAllotjaments().getAllotjaments().size(),
                    loadedCamping.getLlistaAllotjaments().getAllotjaments().size());

            new File(testFile).delete();

        } catch (ExcepcioCamping e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLoadInvalidFile() throws ExcepcioCamping {
        Camping.load("nonexistent_file.dat");
    }

    @Test
    public void testInicialitzaDadesCamping() {
        assertEquals(12, camping.calculaAccessosAccessibles());
        assertEquals(6, camping.getLlistaAllotjaments().getAllotjaments().size());

        try {
            Allotjament all = camping.getLlistaAllotjaments().getAllotjament("ALL1");
            assertEquals("Parcel·la Nord", all.getNom());

        } catch (ExcepcioCamping e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}