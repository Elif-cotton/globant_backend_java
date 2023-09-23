package Servicio;

import Entidades.Movil;

import java.util.Scanner;

public class MovilServicio {
    Scanner leer=new Scanner(System.in).useDelimiter("\n");

    public Movil cargarCelular(){
        Movil m=new Movil();

        System.out.println("Ingrese la marca del móvil: ");
        m.setMarca(leer.nextLine());

        System.out.println("Ingrese el precio del móvil: ");
        m.setPrecio(leer.nextDouble());

        leer.nextLine();

        System.out.println("Ingrese el modelo del móvil: ");
        m.setModelo(leer.nextLine());

        System.out.println("Ingrese la memoriaRam del móvil: ");
        m.setMemoriaRam(leer.nextDouble());

        System.out.println("Ingrese el almacenamiento del móvil: ");
        m.setAlmacenamiento(leer.nextInt());

        return m;
    }

    public void ingresarCodigo(Movil m) {

        int[] codigo = m.getCodigo();

        for (int i = 0; i < codigo.length; i++) {
            boolean codigoValido = false;

            while (!codigoValido) {
                System.out.println("Ingrese el dígito " + (i + 1) + " del código del móvil: ");
                int digito = leer.nextInt();

                if (digito >= 0 && digito <= 9) {
                    codigo[i] = digito;
                    codigoValido = true;
                } else {
                    System.out.println("Dígito inválido. Ingrese un número del 0 al 9.");
                }
            }
        }
    }
}
