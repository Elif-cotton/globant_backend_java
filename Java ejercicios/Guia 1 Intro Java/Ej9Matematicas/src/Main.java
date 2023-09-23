import Entidades.Matematica;
import Servicio.MatematicaServicio;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

            MatematicaServicio ms=new MatematicaServicio();
            Matematica m=new Matematica();

            Random random =new Random();


            double num1 = random.nextDouble();
            double num2=random.nextDouble();
//        num1=num1*20-10;  número entre -10 a 10
//        num2=num2*20-10;
            num1=num1*10;
            num2=num2*10;
            m.setNum1(num1);
            m.setNum2(num2);

            System.out.println("El número 1 es: "+m.getNum1()+" y el número 2 es: "+ m.getNum2());

            System.out.println("");
            System.out.println("El número mayor es: "+MatematicaServicio.devolverMayor(m));

            System.out.println("");
            System.out.println("La potencia de los número es: "+MatematicaServicio.calcularPotencia(m));

            System.out.println("");
            System.out.println("La potencia de los número es: "+MatematicaServicio.calcularRaiz(m));


    }
}