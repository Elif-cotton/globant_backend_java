package Entidades;

import java.util.Scanner;

public class Electrodomestico {
    private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");

    protected double precio;
    protected String color; // disponibles: blanco, negro, rojo, azul y gris
    protected Character consumoEnergetico; // letras entre A y F
    protected int peso;

    private static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};

    public Electrodomestico() {
        this.precio = 1000.0;
        this.color = "blanco";
        this.consumoEnergetico = 'F';
        this.peso = 1;
    }

    public Electrodomestico(
            double precio,
            String color,
            char consumoEnergetico,
            int peso
    ) {
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.precio = precio;
        this.peso = peso;
        this.precio = 1000;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return 'F';
        }
    }

    private String comprobarColor(String color) {
        color = color.toLowerCase();
        for (String colorDisponible : COLORES_DISPONIBLES) {
            if (colorDisponible.equals(color)) {
                return colorDisponible;
            }
        }
        return "blanco";
    }

    protected void crearElectrodomestico() {
        System.out.print("Ingrese el color: ");
        setColor(leer.next());

        System.out.print("Ingrese el consumo energetico: ");
        setConsumoEnergetico(leer.next().charAt(0));

        System.out.print("Ingrese el peso: ");
        setPeso(leer.nextInt());

    }

    public double precioFinal() {

        double precioFinal = getPrecio();

        switch (getConsumoEnergetico()) {
            case 'A':
                precioFinal += 1000.0;
                break;
            case 'B':
                precioFinal += 800.0;
                break;
            case 'C':
                precioFinal += 600.0;
                break;
            case 'D':
                precioFinal += 500.0;
                break;
            case 'E':
                precioFinal += 300.0;
                break;
            case 'F':
            default:
                precioFinal += 100.0;
                break;
        }

        if (getPeso() >= 1 && getPeso() <= 19) {
            precioFinal += 100.0;
        } else if (getPeso() >= 20 && getPeso() <= 49) {
            precioFinal += 500.0;
        } else if (getPeso() >= 50 && getPeso() <= 79) {
            precioFinal += 800.0;
        } else if (getPeso() >= 80) {
            precioFinal += 1000.0;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Electrodomestico{"
                + "precio=" + precio
                + ", color=" + color
                + ", consumoEnergetico=" + consumoEnergetico
                + ", peso=" + peso + '}';
    }
}
