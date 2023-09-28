package Servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodigoPostalServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    HashMap<String, String> codigoList=new HashMap();
    int contador=0;
    private static final int NUM_CIUDADES = 10;

    public void agregarCiudad(){

        if(contador<NUM_CIUDADES){
            System.out.print("Ingrese el código postal de la ciudad: ");
            String codigo = leer.next();
            System.out.print("Ingrese la ciudad: ");
            String ciudad = leer.next();

            codigoList.put(codigo, ciudad);
            contador++;
        }else {
            System.out.println("Ya ha ingresado el máximo de 10 códigos y ciudades.");
        }
    }

    public HashMap getPostales() {
        return codigoList;
    }

    public CodigoPostalServicio(){

        codigoList.put("0100011962","Seúl");  //korea Sur
        codigoList.put("1493715119","Incheon");
        codigoList.put("4600049528","Busan");
        codigoList.put("6300263644","Jeju-do");
        codigoList.put("100000102629","Pekín"); //China
        codigoList.put("200000202183","Shanghái");
        codigoList.put("210000239455","Jiangsu");
        codigoList.put("28001","Madrid"); //España
        codigoList.put("08001","Barcelona");
        codigoList.put("46001","Valencia");

    }

    public void mostrarCiudad(){

        if (codigoList.isEmpty()) {
            System.out.println("No hay Códigos Postales.");
        } else {
            System.out.println("Los Códigos Postales y las ciudades son: ");
            for (Map.Entry<String, String> entry : codigoList.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println( "Código: " + entry.getKey()
                        + " \t Ciudad:" + entry.getValue());
            }
        }
    }

    public void buscarPorCodigoPostal(String codigo){

        if(codigoList.containsKey(codigo)){
            System.out.println("Ciudad: " + codigoList.get(codigo));

        }else{
            System.out.println("El código no existe");
        }
    }

    public void agregarCiudad(String codigo, String ciudad){

        if(codigoList.containsKey(codigo)){
            System.out.println("El código ya existe");
        }else{
            codigoList.put(codigo,ciudad);
            System.out.println("El código y la ciudad fueron agregados de forma existosa");
        }
    }

    public void eliminarCiudad(String ciudad) {

        String claveAEliminar = null;
        for (Map.Entry<String, String> entry : codigoList.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(ciudad)) {
                claveAEliminar = entry.getKey();
            }
        }

        if (claveAEliminar != null) {
            codigoList.remove(claveAEliminar);
            System.out.println(ciudad + " se ha eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar, ciudad no encontrada.");
        }
    }
}
