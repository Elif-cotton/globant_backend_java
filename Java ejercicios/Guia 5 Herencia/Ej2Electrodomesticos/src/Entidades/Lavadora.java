package Entidades;

import java.util.Scanner;

public class Lavadora extends Electrodomestico{
    private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private int carga;

    public Lavadora() {
    }

    public Lavadora(int carga, double precio, String color, char consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        System.out.println("CREAR LAVADORA");
        super.crearElectrodomestico();

        System.out.print("Ingrese la carga: ");
        setCarga(leer.nextInt());

    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (getCarga() > 30) {
            precioFinal += 500;
        }

        return precioFinal;
    }

}
