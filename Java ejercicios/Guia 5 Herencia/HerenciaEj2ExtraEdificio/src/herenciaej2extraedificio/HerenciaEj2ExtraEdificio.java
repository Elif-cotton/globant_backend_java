
package herenciaej2extraedificio;

import Entidades.Edificio;
import Entidades.EdificioDeOficinas;
import Entidades.Polideportivo;
import java.util.ArrayList;

/**
 *
 * @author javer
 */
public class HerenciaEj2ExtraEdificio {

   
    public static void main(String[] args) {
       
         ArrayList<Edificio> edificios = new ArrayList<>();

        edificios.add(new Polideportivo("Polideportivo A", "Techado",50, 20, 30));
        edificios.add(new Polideportivo("Polideportivo B", "Abierto",40, 30, 25));

        edificios.add(new EdificioDeOficinas(5, 10, 6, 20, 15, 25));
        edificios.add(new EdificioDeOficinas(8, 12, 8, 30, 20, 40));

        for (Edificio edificio : edificios) {
            System.out.println("Superficie del edificio: " + edificio.calcularSuperficie());
            System.out.println("Volumen del edificio: " + edificio.calcularVolumen());
            
            if (edificio instanceof Polideportivo) {
                Polideportivo poli = (Polideportivo) edificio;
                System.out.println("Tipo de instalación del polideportivo: " +poli.getTipoInstalacion());
            } else if (edificio instanceof EdificioDeOficinas) {
                EdificioDeOficinas edifOficinas = (EdificioDeOficinas) edificio;
                edifOficinas.cantPersonas();
            }
            System.out.println("-------------------------------");
        }
    
        
    }
    
}
