
package Entidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author javer
 */
public class Simulador {
    
    List<String> nombres;
    List<String> apellidos;

    public Simulador(List<String> nombres, List<String> apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public List<String> generarDNI(int cantidad) {
         List<String> dnis = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String dni;
            do {
                dni = String.valueOf(10000000 + random.nextInt(90000000));
            } while (dnis.contains(dni));
            dnis.add(dni);
        }
        return dnis;
    
    }

    public List<Alumno> generarAlumnos(int cantidad) {
        List<String> dnis = generarDNI(cantidad);
        List<Alumno> alumnos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String nombre = nombres.get(random.nextInt(nombres.size())) + " " + apellidos.get(random.nextInt(apellidos.size()));
            String dni = dnis.get(i);
            Alumno alumno = new Alumno(nombre, dni);
            alumnos.add(alumno);
        }
        return alumnos;
    }

    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public void votacion(List<Alumno> alumnos) {
        Set<Alumno> votados = new HashSet<>();
        Random random = new Random();
        for (Alumno alumno : alumnos) {
            Voto voto = new Voto(alumno);
            for (int i = 0; i < 3; i++) {
                Alumno alumnoVotado;
                do {
                    alumnoVotado = alumnos.get(random.nextInt(alumnos.size()));
                } while (votados.contains(alumnoVotado) || alumno.getDNI().equals(alumnoVotado.getDNI()));
                voto.agregarVoto(alumnoVotado);
                votados.add(alumnoVotado);
            }
        }
    }

    public void mostrarResultados(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombreCompleto() + " - Votos: " + alumno.getCantidadVotos());
            System.out.println("Votos recibidos:");
            for (Voto voto :  alumno.votosRecibidos) {
                System.out.println("- " + voto.alumnoQueVota.getNombreCompleto());
            }
            System.out.println();
        }
    }

    public void recuentoVotos(List<Alumno> alumnos) {
        
        for (Alumno alumno : alumnos) {
            for (Voto voto : alumno.votosRecibidos) {
                alumno.setCantidadVotos(alumno.getCantidadVotos()+ voto.alumnosVotados.size());
                //alumno.cantidadVotos += voto.alumnosVotados.size();
            }
        }
    }

    public void seleccionarFacilitadores(List<Alumno> alumnos) {
        Collections.sort(alumnos, (a1, a2) -> Integer.compare(a2.getCantidadVotos(), a1.getCantidadVotos()));
        System.out.println("Facilitadores:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + alumnos.get(i).getNombreCompleto());
        }
        System.out.println("\nFacilitadores Suplentes:");
        for (int i = 5; i < 10; i++) {
            System.out.println((i - 4) + ". " + alumnos.get(i).getNombreCompleto());
        }
    }
}
