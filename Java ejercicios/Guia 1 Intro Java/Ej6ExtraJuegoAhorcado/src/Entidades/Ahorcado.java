package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Ahorcado {

    private char[] palabra;
    private List<Character> letrasEncontradas = new ArrayList<Character>();
    private int cantEncontradas;
    private int cantJugadas;

    public Ahorcado() {

    }

    public Ahorcado(char[] palabra, int cantEncontradas, int cantJugadas) {
        this.palabra = palabra;
        this.cantEncontradas = cantEncontradas;
        this.cantJugadas = cantJugadas;
    }

    public char[] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public List<Character> getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(List<Character> letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }

    public int getCantEncontradas() {
        return cantEncontradas;
    }

    public void setCantEncontradas(int cantEncontradas) {
        this.cantEncontradas = cantEncontradas;
    }

    public int getCantJugadas() {
        return cantJugadas;
    }

    public void setCantJugadas(int cantJugadas) {
        this.cantJugadas = cantJugadas;
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "palabra=" + palabra + ", letrasEncontradas=" + letrasEncontradas + ", cantEncontradas=" + cantEncontradas + ", cantJugadas=" + cantJugadas + '}';
    }


}
