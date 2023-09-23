package Entidades;

import java.util.Arrays;

public class Arreglo {

    private double[] arregloA;
    private double[] arregloB;

    public Arreglo() {

    }

    public Arreglo(double[] arregloA, double[] arregloB) {
        this.arregloA = arregloA;
        this.arregloB = arregloB;
    }

    public double[] getArregloA() {
        return arregloA;
    }

    public void setArregloA(double[] arregloA) {
        this.arregloA = arregloA;
    }

    public double[] getArregloB() {
        return arregloB;
    }

    public void setArregloB(double[] arregloB) {
        this.arregloB = arregloB;
    }

    @Override
    public String toString() {
        return "Arreglo{" + "arregloA=" + Arrays.toString(arregloA) + ", arregloB=" + Arrays.toString(arregloB) + '}';
    }
}
