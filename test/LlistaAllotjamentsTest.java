import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.vista.ExcepcioCamping;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llista;
    private Allotjament allotjament1;
    private Allotjament allotjament2;
    private Allotjament allotjament3;

    @Before
    public void setUp() {
        llista = new LlistaAllotjaments();
        allotjament1 = new Allotjament("Habitació Doble", "ALL1", true, "100%", 3, 1);
        allotjament2 = new Allotjament("Habitació Individual", "ALL2", false, "50%", 2, 1);
        allotjament3 = new Allotjament("Suite", "ALL3", true, "100%", 4, 2);

    }

    @Test
    public void testConstructor() {
        assertNotNull(llista);
        assertEquals(0, llista.getAllotjaments().size());
    }

    @Test
    public void testAfegirAllotjament() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1);
        assertEquals(1, llista.getAllotjaments().size());
        assertTrue(llista.getAllotjaments().contains(allotjament1));
    }

    @Test(expected = ExcepcioCamping.class)
    public void testAfegirAllotjamentDuplicat() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1);
        llista.afegirAllotjament(allotjament1); // Should throw exception
    }

    @Test
    public void testBuidar() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1);
        llista.afegirAllotjament(allotjament2);
        assertEquals(2, llista.getAllotjaments().size());

        llista.buidar();
        assertEquals(0, llista.getAllotjaments().size());
    }

    @Test
    public void testLlistarAllotjaments() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1); // Operatiu
        llista.afegirAllotjament(allotjament2); // No operatiu
        llista.afegirAllotjament(allotjament3); // Operatiu

        // Test llistar tots
        String tots = llista.llistarAllotjaments("Tots");
        System.out.println(tots);
        assertTrue(tots.equals("*  Nom: Habitació Doble, Id: ALL1, Estat allotjament: true, Estat electric: 100%, Estada mínima en temp ALTA: 3, Estada mínima en temp BAIXA: 1*  Nom: Habitació Individual, Id: ALL2, Estat allotjament: false, Estat electric: 50%, Estada mínima en temp ALTA: 2, Estada mínima en temp BAIXA: 1*  Nom: Suite, Id: ALL3, Estat allotjament: true, Estat electric: 100%, Estada mínima en temp ALTA: 4, Estada mínima en temp BAIXA: 2"));


        // Test llistar operatius
        String operatius = llista.llistarAllotjaments("Operatiu");
        assertTrue(operatius.equals("*  Nom: Habitació Doble, Id: ALL1, Estat allotjament: true, Estat electric: 100%, Estada mínima en temp ALTA: 3, Estada mínima en temp BAIXA: 1*  Nom: Suite, Id: ALL3, Estat allotjament: true, Estat electric: 100%, Estada mínima en temp ALTA: 4, Estada mínima en temp BAIXA: 2"));

        // Test llistar no operatius
        String noOperatius = llista.llistarAllotjaments("No operatiu");
        assertTrue(noOperatius.equals("*  Nom: Habitació Individual, Id: ALL2, Estat allotjament: false, Estat electric: 50%, Estada mínima en temp ALTA: 2, Estada mínima en temp BAIXA: 1"));
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAllotjamentsOperatiusSenseResultats() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament2); // Only non-operational
        llista.llistarAllotjaments("Operatiu"); // Should throw exception
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAllotjamentsNoOperatiusSenseResultats() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1); // Only operational
        llista.llistarAllotjaments("No operatiu"); // Should throw exception
    }

    @Test(expected = ExcepcioCamping.class)
    public void testLlistarAllotjamentsEstatInvalid() throws ExcepcioCamping {
        llista.llistarAllotjaments("Invalid");
    }

    @Test
    public void testContainsAllotjamentOperatiu() throws ExcepcioCamping {
        assertFalse(llista.containsAllotjamentOperatiu());

        llista.afegirAllotjament(allotjament2); // Non-operational
        assertFalse(llista.containsAllotjamentOperatiu());

        llista.afegirAllotjament(allotjament1); // Operational
        assertTrue(llista.containsAllotjamentOperatiu());
    }

    @Test
    public void testContains() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1);

        assertTrue(llista.contains(allotjament1));
        assertFalse(llista.contains(allotjament2));
    }

    @Test
    public void testGetAllotjament() throws ExcepcioCamping {
        llista.afegirAllotjament(allotjament1);
        llista.afegirAllotjament(allotjament2);

        assertEquals(allotjament1, llista.getAllotjament("ALL1"));
        assertEquals(allotjament2, llista.getAllotjament("ALL2"));
    }

    @Test(expected = ExcepcioCamping.class)
    public void testGetAllotjamentNoExistent() throws ExcepcioCamping {
        llista.getAllotjament("INVALID");
    }
}