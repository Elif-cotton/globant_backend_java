package Servicio;

import Entidades.Cuenta;

import java.util.Scanner;

public class CuentaServicio {
    Scanner leer=new Scanner(System.in);

    public Cuenta ingresarDatos(){

        Cuenta c1=new Cuenta();

        System.out.println("Ingrese el número de la cuenta: ");
        c1.setNumeroCuenta(leer.nextInt());

        System.out.println("Ingrese el DNI del cliente: ");
        c1.setDniCliente(leer.nextLong());

        System.out.println("Ingrese el saldo actual del cliente: ");
        c1.setSaldoActual(leer.nextInt());

        return c1;
    }

    //método ingresar
    public void ingresar(Cuenta c1){
        System.out.println("Escriba el monto de dinero que va a ingresar: ");
        //Scanner leer=new Scanner (System.in);
        Double monto= leer.nextDouble();
        c1.setSaldoActual((int) (c1.getSaldoActual()+monto));

        System.out.println("Saldo total ingresado "+c1.getSaldoActual());
    }

    // Método retirar(double retiro)
    public void retirar(Cuenta c1) {
        System.out.println("Escriba el monto de dinero que va a retirar: ");
        //Scanner leer=new Scanner (System.in);
        Double retiro= leer.nextDouble();
        if (retiro <= c1.getSaldoActual()) {
            c1.setSaldoActual((int)(c1.getSaldoActual()-retiro));
            System.out.println("Saldo actual despúes del retiro de dinero: "+c1.getSaldoActual());
        } else {
            c1.setSaldoActual(0);
        }
    }

    // Método extraccionRapida()
    public void extraccionRapida(Cuenta c1) {
        double limiteExtraccion = c1.getSaldoActual() * 0.2;
        if (limiteExtraccion <= c1.getSaldoActual()) {
            c1.setSaldoActual((int)(c1.getSaldoActual()-limiteExtraccion));
            System.out.println("Retiro exitoso");
            System.out.println("Saldo despúes de la extracción rápida: "+c1.getSaldoActual());
        } else {
            c1.setSaldoActual(0);
            System.out.println("No es posible retirar más del 20% del sueldo mediante extracción rápida");
        }
    }

    // Método consultarSaldo()
    public int consultarSaldo(Cuenta c1) {
        return c1.getSaldoActual();
    }

    // Método consultarDatos()
    public void consultarDatos(Cuenta c1) {
        System.out.println("Número de cuenta: " + c1.getNumeroCuenta());
        System.out.println("DNI del cliente: " + c1.getDniCliente());
        System.out.println("Saldo actual: " + c1.getSaldoActual());
    }
}
