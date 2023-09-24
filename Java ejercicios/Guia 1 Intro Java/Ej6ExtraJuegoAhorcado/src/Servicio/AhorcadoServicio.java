package Servicio;

import Entidades.Ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AhorcadoServicio {

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    private List<Character> letrasEncontradas = new ArrayList<Character>();

    public Ahorcado crearJuego() {
        Ahorcado ahorcado = new Ahorcado();

        System.out.println("Crear juego: Ahorcado");

        System.out.print("Ingrese la palabra a buscar: ");
        ahorcado.setPalabra(leer.nextLine().toCharArray());

        System.out.print("Ingrese la cantidad de jugadas máximas: ");
        ahorcado.setCantJugadas(leer.nextInt());

        ahorcado.setCantEncontradas(0);

        return ahorcado;

    }

    public int longitud(Ahorcado ahorcado) {

        int longitud = ahorcado.getPalabra().length;

        return longitud;
    }


    public boolean buscar(char letra) {

        Ahorcado ahorcado = new Ahorcado();

        int cantJugadas = ahorcado.getCantJugadas();
        char[] palabra = ahorcado.getPalabra();

        boolean estaPresente = false;
        boolean seEncontroAnteriormente = false;

        for (char ch : palabra) {
            if (ch == letra) {
                estaPresente = true;
                break;
            }
        }

        for (Character ch : letrasEncontradas) {
            if (ch.charValue() == letra) {
                seEncontroAnteriormente = true;
            }
        }

        if (!seEncontroAnteriormente && estaPresente) {
            letrasEncontradas.add(letra);
        }


        if (estaPresente) {
            System.out.println("Mensaje: La letra pertenece a la palabra");
        } else {
            System.out.println("Mensaje: La letra no pertenece a la palabra");
            cantJugadas--;
        }

        return seEncontroAnteriormente;
    }

    public boolean encontradas(char letra) {
        Ahorcado ahorcado = new Ahorcado();

        boolean seEncontroAnteriormente = buscar(letra);
        int cantEncontradas = 0;
        int cantJugadas = ahorcado.getCantJugadas();

        for (char ch : ahorcado.getPalabra()) {
            if (ch == letra && !seEncontroAnteriormente) {
                cantEncontradas++;

            }
        }

        System.out.println(String.format(
                "Número de letras (encontradas, faltantes): (%d,%d)",
                cantEncontradas, ahorcado.getPalabra().length - ahorcado.getCantEncontradas())
        );

        cantJugadas--;

        return seEncontroAnteriormente;

    }

    public void intentos(Ahorcado ahorcado) {
        if (ahorcado.getCantJugadas() > 0) {
            System.out.println("Número de oportunidades restantes: " + ahorcado.getCantJugadas());
        } else {
            System.out.println("Mensaje: Lo sentimos, no hay más oportunidades");
        }
    }


    public void juego(Ahorcado ahorcado) {
        char letra;

        while ((ahorcado.getCantJugadas() > 0)) {
            System.out.println("Ingrese una letra: ");
            letra = leer.next().toLowerCase().charAt(0);

            longitud(ahorcado);
            encontradas(letra);
            intentos(ahorcado);

            System.out.println("--------------------------");

            if ((ahorcado.getPalabra().length - ahorcado.getCantEncontradas()) == 0) {
                System.out.println("Se han ingreado todas las letras de la palabra.");
                System.out.println("Adivine la palabra!");
                break;
            }
        }

    }
}