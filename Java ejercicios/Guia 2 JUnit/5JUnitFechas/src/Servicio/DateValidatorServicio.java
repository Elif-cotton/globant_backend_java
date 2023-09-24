
package Servicio;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class DateValidatorServicio {
    
     public static boolean esFechaValida(int anio, int mes, int dia) {
         
        if (anio < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setLenient(false);
        calendar.set(Calendar.YEAR, anio);
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.DAY_OF_MONTH, dia);

        try {
            calendar.getTime();   //fecha en forma de objeto 
            return true;             
        } catch (Exception e) {
            return false;
        }
        // bloque try-catch para capturar cualquier excepción que se genere durante la obtención de la fecha.
        //Si se produce una excepción, significa que la fecha es inválida y se devuelve false.
    }
    
    
}
