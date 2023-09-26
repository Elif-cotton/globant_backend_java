package Entidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    public AlumnoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorSinArgs() {

        Alumno a = new Alumno();

        assertNotNull(a.getNotas()); //verificar obj es no nulo
        assertEquals(0, a.getNotas().size());
    }

    @Test
    public void testConstructorConArgs() {

        String nombre = "Ricardo";
        List<Integer> notas = Arrays.asList(1, 2, 3, 4, 5, 6);

        Alumno a = new Alumno(nombre, notas);
        assertEquals(nombre, a.getNombre());
        assertEquals(notas, a.getNotas());
    }


}