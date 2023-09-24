package Servicio;

import Entidades.Nif;

import java.util.Scanner;

public class NifServicio {
    Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    public Nif crearNif(){
        Nif n= new Nif();

        System.out.println("Ingrese el DNI: ");
        n.setDNI(leer.nextLong());

        // Calcular la letra del NIF

        char[] letras = new char[]{
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F',
                'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
                'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
        int resto=(int) n.getDNI()%23;

        if (resto>=0 || resto<=20){
            n.setLetra(letras[resto]);

        }

        return n;
    }

    public void mostrar(Nif n){
        //que nos permita mostrar el NIF (ocho dígitos, un guion y la letra
//en mayúscula; por ejemplo: 00395469-F).
        System.out.println("NIF: "+ n.getDNI()+ "-"+n.getLetra());
        System.out.println("");
        //otra forma
        System.out.println(
                String.format("%d-%c", n.getDNI(), n.getLetra())
        );
        System.out.println("");
    }
}
