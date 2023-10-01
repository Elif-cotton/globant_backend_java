
package Entidad;

import Enumeración.FormaPago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javer
 */
public class Poliza {
    
    private String numeroPoliza;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadCuotas;
    private FormaPago formaPago;
    private double montoTotalAsegurado; //
    private boolean incluyeGranizo;     //
    private double montoMaximoGranizo;  //
    private String tipoCobertura;       //
    private Vehiculo vehiculo;
    private Cliente cliente;
    private List<Cuota> cuotas;

    public Poliza() {
    }

    public Poliza(String numeroPoliza, LocalDate fechaInicio, LocalDate fechaFin, int cantidadCuotas,
                  FormaPago formaPago, double montoTotalAsegurado, boolean incluyeGranizo,
                  double montoMaximoGranizo, String tipoCobertura, Vehiculo vehiculo, Cliente cliente) {
        this.numeroPoliza = numeroPoliza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadCuotas = cantidadCuotas;
        this.formaPago = formaPago;
        this.montoTotalAsegurado = montoTotalAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaximoGranizo = montoMaximoGranizo;
        this.tipoCobertura = tipoCobertura;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.cuotas = new ArrayList<>();
       
        generarCuotas();
    }

    
    private void generarCuotas() {
        
        double montoCuota = montoTotalAsegurado / cantidadCuotas;
        
        LocalDate fechaVencimiento = fechaInicio.plusMonths(1);
        for (int i = 1; i <= cantidadCuotas; i++) {
            cuotas.add(new Cuota(i, montoCuota, fechaVencimiento, formaPago));
            fechaVencimiento = fechaVencimiento.plusMonths(1);
        }
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getMontoTotalAsegurado() {
        return montoTotalAsegurado;
    }

    public void setMontoTotalAsegurado(double montoTotalAsegurado) {
        this.montoTotalAsegurado = montoTotalAsegurado;
    }

    public boolean isIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public double getMontoMaximoGranizo() {
        return montoMaximoGranizo;
    }

    public void setMontoMaximoGranizo(double montoMaximoGranizo) {
        this.montoMaximoGranizo = montoMaximoGranizo;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
    
    public void marcarCuotaPagada(int numeroCuota) {
        Cuota cuota = cuotas.get(numeroCuota - 1);
        cuota.marcarPagada();
    }

    public boolean cuotasPagadasATiempo() {
        for (Cuota cuota : cuotas) {
            if (!cuota.isPagada() && cuota.getFechaVencimiento().isBefore(LocalDate.now())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Poliza{" + "numeroPoliza=" + numeroPoliza + ", fechaInicio=" + fechaInicio + 
                ", fechaFin=" + fechaFin + ", cantidadCuotas=" + cantidadCuotas + ", formaPago=" +
                formaPago + ", montoTotalAsegurado=" + montoTotalAsegurado + ", incluyeGranizo=" +
                incluyeGranizo + ", montoMaximoGranizo=" + montoMaximoGranizo + ", tipoCobertura=" +
                tipoCobertura + ", cuotas=" + cuotas + '}';
    }
    
    
    
}
