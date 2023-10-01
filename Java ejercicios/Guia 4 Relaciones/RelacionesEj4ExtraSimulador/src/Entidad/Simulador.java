
package Entidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author javer
 */
public class Simulador {

    public Simulador() {
    }
    
    public static List<String> generarNombresAleatorios(int cantidad) {
        List<String> nombres = new ArrayList<>(Arrays.asList(
            "Juan", "María", "Carlos", "Luis", "Ana", "Pedro", "Laura", "Diego", "Sofía", "Andrés"
        ));
        
        List<String> apellidos = new ArrayList<>(Arrays.asList(
            "García", "Martínez", "López", "Rodríguez", "Pérez", "González", "Hernández", "Flores", 
                "Sánchez", "Ramírez"
            
        ));
        
        List<String> combinaciones = new ArrayList<>();
        
        for (int i = 0; i < cantidad; i++) {
            String nombre = nombres.get((int) (Math.random() * nombres.size()));
            String apellido = apellidos.get((int) (Math.random() * apellidos.size()));
            combinaciones.add(nombre + " " + apellido);
        }
        
        return combinaciones;
    }
    
    public static List<String> generarDNIs(int cantidad) {
        Set<String> dnis = new HashSet<>(); // Usamos un HashSet para evitar duplicados
        List<String> dnisList = new ArrayList<>();

        while (dnis.size() < cantidad) {
            String dni = String.valueOf(10000000 + (int) (Math.random() * 90000000));
            dnis.add(dni);
        }

        dnisList.addAll(dnis);
        return dnisList;
    }
    
    public static List<Alumno> crearAlumnos(List<String> nombres, List<String> dnis, int cantidad) {
        List<Alumno> alumnos = new ArrayList<>();
        
        for (int i = 0; i < cantidad; i++) {
            Alumno alumno = new Alumno(nombres.get(i), dnis.get(i));
            alumnos.add(alumno);
        }
        System.out.println(alumnos);
        return alumnos;
    }
    
    public static void imprimirListadoAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
     
    public static void votacion(List<Alumno> alumnos) {
        HashSet<Integer> votosRealizados = new HashSet<>();
        
        for (Alumno votante : alumnos) {
            Set<Integer> votos = new HashSet<>();
            
            while (votos.size() < 3) {
                int indiceVoto = (int) (Math.random() * alumnos.size());
                
                if (indiceVoto != alumnos.indexOf(votante) && !votosRealizados.contains(indiceVoto)) {
                    votos.add(indiceVoto);
                    votosRealizados.add(indiceVoto);
                }
            }
            
            for (int indiceVoto : votos) {
                votante.incrementarVotos();
                alumnos.get(indiceVoto).incrementarVotos();
            }
        }
    }
    
    public static void mostrarResultados(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
    
    public static void recuentoVotos(List<Alumno> alumnos) {
        List<Alumno> facilitadores = new ArrayList<>();
        List<Alumno> facilitadoresSuplentes = new ArrayList<>();

        // Ordenar la lista de alumnos por cantidad de votos de mayor a menor
         Collections.sort(alumnos, Comparator.comparingDouble(Alumno::getCantidadVotos));

        // Elegir los 5 facilitadores y los 5 facilitadores suplentes
        for (int i = 0; i < alumnos.size() && (facilitadores.size() < 5 || facilitadoresSuplentes.size() < 5); i++) {
            Alumno alumno = alumnos.get(i);
            
            if (facilitadores.size() < 5) {
                facilitadores.add(alumno);
            } else if (facilitadoresSuplentes.size() < 5) {
                facilitadoresSuplentes.add(alumno);
            }
        }

        // Mostrar los facilitadores y los facilitadores suplentes
        System.out.println("\nFacilitadores:");
        for (int i = 0; i < facilitadores.size(); i++) {
            System.out.println("Facilitador " + (i + 1) + ": " + facilitadores.get(i).getNombreCompleto() + 
                    " - Votos: " + facilitadores.get(i).getCantidadVotos());
        }

        System.out.println("\nFacilitadores Suplentes:");
        for (int i = 0; i < facilitadoresSuplentes.size(); i++) {
            System.out.println("Facilitador Suplente " + (i + 1) + ": " + facilitadoresSuplentes.get(i).getNombreCompleto() +
                    " - Votos: " + facilitadoresSuplentes.get(i).getCantidadVotos());
        }
    }
            
            
}
