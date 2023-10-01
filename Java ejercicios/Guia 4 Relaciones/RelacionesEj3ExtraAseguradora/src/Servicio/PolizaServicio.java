
package Servicio;

import Entidad.Cliente;
import Entidad.Cuota;
import Entidad.Poliza;
import Entidad.Vehiculo;
import Enumeración.FormaPago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class PolizaServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    private List<Poliza> polizas = new ArrayList<>();

    public void crearPoliza(Cliente cliente, Vehiculo vehiculo) {
        
        System.out.println("Ingrese el número de póliza:");
        String numeroPoliza = leer.next();
        System.out.println("Ingrese la cantidad de cuotas:");
        int cantidadCuotas = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingrese el monto total asegurado:");
        double montoTotalAsegurado = leer.nextDouble();
        leer.nextLine();
        System.out.println("Incluye granizo (true/false):");
        boolean incluyeGranizo = leer.nextBoolean();
        leer.nextLine();
        System.out.println("Ingrese el monto máximo por granizo:");
        double montoMaximoGranizo = leer.nextDouble();
        leer.nextLine();
        System.out.println("Ingrese el tipo de cobertura:");
        String tipoCobertura = leer.nextLine();

        FormaPago formaPago = elegirFormaPago(leer);

        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusYears(1);
        
        Poliza poliza = new Poliza(numeroPoliza, fechaInicio, fechaFin, cantidadCuotas,
                formaPago, montoTotalAsegurado, incluyeGranizo, montoMaximoGranizo,
                tipoCobertura, cliente, vehiculo);
        
        generarCuotas(poliza);

        polizas.add(poliza);

        System.out.println("Póliza creada con éxito.");
    }
    
    private FormaPago elegirFormaPago(Scanner leer) {
        System.out.println("Seleccione la forma de pago:");
        for (FormaPago formaPago : FormaPago.values()) {
            System.out.println(formaPago.ordinal() + ". " + formaPago);
        }
        int opcion = leer.nextInt();
        leer.nextLine();
        return FormaPago.values()[opcion];
    }
    
    private void generarCuotas(Poliza poliza) {
        double montoTotalCuota = poliza.getMontoTotalAsegurado() / poliza.getCantidadCuotas();
        LocalDate fechaVencimiento = poliza.getFechaInicio().plusMonths(1);

        for (int i = 1; i <= poliza.getCantidadCuotas(); i++) {
            
            Cuota cuota = new Cuota(i, montoTotalCuota, false, fechaVencimiento, poliza.getFormaPago());
            poliza.agregarCuota(cuota);
            fechaVencimiento = fechaVencimiento.plusMonths(1);
        }
    }
    
    public void marcarCuotaPagada(Poliza poliza, int numeroCuota) {
        if (numeroCuota >= 1 && numeroCuota <= poliza.getCantidadCuotas()) {
            Cuota cuota = poliza.getCuotas().get(numeroCuota - 1);
            cuota.setPagada(true);
            System.out.println("Cuota marcada como pagada.");
        } else {
            System.out.println("Número de cuota inválido.");
        }
    }

    public boolean cuotasPagadasATiempo(Poliza poliza) {
        for (Cuota cuota : poliza.getCuotas()) {
            if (!cuota.isPagada() && cuota.getFechaVencimiento().isBefore(LocalDate.now())) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrarInformacionPoliza(Poliza poliza) {
        System.out.println("Información de la Póliza");
        System.out.println("Número de póliza: " + poliza.getNumeroPoliza());
        System.out.println("Cliente: " + poliza.getCliente().getNombre()+ " " + poliza.getCliente().getApellido());
        System.out.println("Vehículo: " + poliza.getVehiculo().getMarca() + " " + poliza.getVehiculo().getModelo());
        System.out.println("Monto total asegurado: " + poliza.getMontoTotalAsegurado());
        System.out.println("Forma de pago: " + poliza.getFormaPago());
        
        if (poliza.cuotasPagadasATiempo()) {
            System.out.println("Cuotas pagadas a tiempo: Sí");
        } else {
            System.out.println("Cuotas pagadas a tiempo: No");
        }
        
        System.out.println("Detalle de Cuotas:");
        for (Cuota cuota : poliza.getCuotas()) {
            String estadoPagada = cuota.isPagada() ? "Pagada" : "Pendiente";
            System.out.println("Cuota " + cuota.getNumeroCuota() + ": " + estadoPagada +
                               " - Fecha de vencimiento: " + cuota.getFechaVencimiento() +
                               " - Monto: " +  cuota.getMontoTotalCuota() +
                               " - Forma de pago: " + cuota.getFormaPago());
        }
    }
}
