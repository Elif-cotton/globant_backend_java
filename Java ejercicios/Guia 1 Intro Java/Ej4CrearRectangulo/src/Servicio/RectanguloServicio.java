package Servicio;

import Entidades.Rectangulo;

import java.util.Scanner;

public class RectanguloServicio {
    Scanner leer=new Scanner(System.in);

    public Rectangulo crearRectangulo(){

        Rectangulo r1=new Rectangulo();

        System.out.println("Ingrese la base del rectángulo: ");
        r1.setBase(leer.nextDouble());

        System.out.println("Ingrese la altura del rectángulo: ");
        r1.setAltura(leer.nextDouble());

        return r1;
    }

    public Double Superficie(Rectangulo r1){
        return (r1.getBase()*r1.getAltura());

    }

    public Double Perimetro(Rectangulo r1){
        return (r1.getBase()+r1.getAltura())*2;

    }

    // Método para dibujar el rectángulo mediante asteriscos
    public void dibujarRectangulo(Rectangulo r1) {
        for (int i = 0; i < r1.getAltura(); i++) {
            for (int j = 0; j < r1.getBase(); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
