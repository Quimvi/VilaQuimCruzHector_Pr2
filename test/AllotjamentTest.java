package prog2.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import prog2.model.Incidencia.TipusIncidencia;

public class AllotjamentTest {

    private Allotjament allotjament;
    private Incidencia incidenciaReparacio;
    private Incidencia incidenciaNeteja;
    private Incidencia incidenciaTancament;

    @Before
    public void setUp() {
        // Create a sample Allotjament
        allotjament = new Allotjament("Habitació Doble", "A1", true, "100%", 3, 1);

        // Create different types of incidents
        incidenciaReparacio = new Incidencia(1, allotjament, "2023-06-15", TipusIncidencia.Reparacio);
        incidenciaNeteja = new Incidencia(2, allotjament, "2023-06-16", TipusIncidencia.Neteja);
        incidenciaTancament = new Incidencia(3, allotjament, "2023-06-17", TipusIncidencia.Tancament);
    }

    @Test
    public void testConstructor() {
        assertEquals("Habitació Doble", allotjament.getNom());
        assertEquals("A1", allotjament.getId());
        assertTrue(allotjament.getEstatAllotjament());
        assertEquals("100%", allotjament.getElectricitat());
        assertEquals(3, allotjament.getEstadaMinima(Allotjament.Temp.ALTA));
        assertEquals(1, allotjament.getEstadaMinima(Allotjament.Temp.BAIXA));
    }

    @Test
    public void testSetGetNom() {
        allotjament.setNom("Nou Nom");
        assertEquals("Nou Nom", allotjament.getNom());
    }

    @Test
    public void testSetGetId() {
        allotjament.setId("B2");
        assertEquals("B2", allotjament.getId());
    }

    @Test
    public void testSetGetElectricitat() {
        allotjament.setElectricitat("75%");
        assertEquals("75%", allotjament.getElectricitat());
    }

    @Test
    public void testSetGetEstatAllotjament() {
        allotjament.setEstatAllotjament(false);
        assertFalse(allotjament.getEstatAllotjament());

        allotjament.setEstatAllotjament(true);
        assertTrue(allotjament.getEstatAllotjament());
    }

    @Test
    public void testSetEstadaMinima() {
        allotjament.setEstadaMinima(5, 2);
        assertEquals(5, allotjament.getEstadaMinima(Allotjament.Temp.ALTA));
        assertEquals(2, allotjament.getEstadaMinima(Allotjament.Temp.BAIXA));
    }

    @Test
    public void testGetTemporada() {
        // Test high season (March 21 - September 20)
        LocalDate highSeasonDate = LocalDate.of(2023, 6, 15);
        assertEquals(Allotjament.Temp.ALTA, allotjament.getTemporada(highSeasonDate));

        // Test low season
        LocalDate lowSeasonDate = LocalDate.of(2023, 10, 15);
        assertEquals(Allotjament.Temp.BAIXA, allotjament.getTemporada(lowSeasonDate));

        // Test boundary cases
        LocalDate startHighSeason = LocalDate.of(2023, 3, 21);
        assertEquals(Allotjament.Temp.ALTA, allotjament.getTemporada(startHighSeason));

        LocalDate endHighSeason = LocalDate.of(2023, 9, 20);
        assertEquals(Allotjament.Temp.ALTA, allotjament.getTemporada(endHighSeason));

        LocalDate beforeHighSeason = LocalDate.of(2023, 3, 20);
        assertEquals(Allotjament.Temp.BAIXA, allotjament.getTemporada(beforeHighSeason));

        LocalDate afterHighSeason = LocalDate.of(2023, 9, 21);
        assertEquals(Allotjament.Temp.BAIXA, allotjament.getTemporada(afterHighSeason));
    }

    @Test
    public void testTancarAllotjamentWithDifferentIncidents() {
        // Test with repair incident (should set illumination to 100%)
        allotjament.tancarAllotjament(incidenciaReparacio);
        assertFalse(allotjament.getEstatAllotjament());
        assertEquals("100%", allotjament.getElectricitat());

        // Re-open for next test
        allotjament.obrirAllotjament();

        // Test with cleaning incident (should set illumination to 50%)
        allotjament.tancarAllotjament(incidenciaNeteja);
        assertFalse(allotjament.getEstatAllotjament());
        assertEquals("50%", allotjament.getElectricitat());

        // Re-open for next test
        allotjament.obrirAllotjament();

        // Test with closure incident (should set illumination to 0%)
        allotjament.tancarAllotjament(incidenciaTancament);
        assertFalse(allotjament.getEstatAllotjament());
        assertEquals("0%", allotjament.getElectricitat());
    }

    @Test
    public void testObrirAllotjament() {
        // First close it with different incidents
        allotjament.tancarAllotjament(incidenciaNeteja);
        assertFalse(allotjament.getEstatAllotjament());
        assertEquals("50%", allotjament.getElectricitat());

        // Then open it (should set to 100%)
        allotjament.obrirAllotjament();
        assertTrue(allotjament.getEstatAllotjament());
        assertEquals("100%", allotjament.getElectricitat());
    }

    @Test
    public void testToString() {
        String expected = "Nom=Habitació Doble, Id=A1, estat allotjament: true, estat electric: 100%, " +
                "estada mínima en temp ALTA: 3, estada mínima en temp BAIXA: 1.\n";
        assertEquals(expected, allotjament.toString());
    }

    @Test
    public void testIncidenciaLightLevels() {
        assertEquals("100%", incidenciaReparacio.getIluminacioAllotjament());
        assertEquals("50%", incidenciaNeteja.getIluminacioAllotjament());
        assertEquals("0%", incidenciaTancament.getIluminacioAllotjament());
    }
}