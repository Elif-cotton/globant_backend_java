package Servicio;

import Entidades.Alumno;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServicioTest {

    public AlumnoServicioTest() {
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
    public void testCrearAlumno() {
        String input = "Juan\n7\n8\n9\n"; //La entrada contiene el nombre "Juan" y tres notas: 7, 8 y 9. Cada valor está separado por un salto de línea (\n).
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes()); //captura de entrada estándar" para simular una entrada de usuario
        System.setIn(in);

        AlumnoServicio as = new AlumnoServicio();
        Alumno a = as.crearAlumno();
        assertEquals("Juan", a.getNombre());
        assertEquals(Arrays.asList(7, 8, 9), a.getNotas());
    }

    @Test
    public void testFabricaAlumnos() {
        String input = "Juan\n7\n8\n9\ns\nPedro\n6\n5\n4\nn\n";  //s representa si otro alumno n no más alumnos
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        AlumnoServicio as = new AlumnoServicio();
        as.fabricaAlumnos();
        List<Alumno> alumnos = as.getAlumnos();
        assertEquals(2, alumnos.size());

        Alumno a1 = alumnos.get(0);
        assertEquals("Juan", a1.getNombre());
        assertEquals(Arrays.asList(7, 8, 9), a1.getNotas());

        Alumno a2 = alumnos.get(1);
        assertEquals("Pedro", a2.getNombre());
        assertEquals(Arrays.asList(6, 5, 4), a2.getNotas());
    }

    @Test
    public void testObtenerAlumnoPorNombre() {
        Alumno a1 = new Alumno("Juan", Arrays.asList(7, 8, 9));
        Alumno a2 = new Alumno("Pedro", Arrays.asList(6, 5, 4));
        AlumnoServicio as = new AlumnoServicio();
        as.getAlumnos().addAll(Arrays.asList(a1, a2));

        assertEquals(a1, as.obtenerAlumnoPorNombre("Juan"));
        assertEquals(a2, as.obtenerAlumnoPorNombre("Pedro"));
        assertNull(as.obtenerAlumnoPorNombre("María"));
    }

}