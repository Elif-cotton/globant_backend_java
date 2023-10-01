
package Entidad;

import Enumeración.FormaPago;
import java.time.LocalDate;

/**
 *
 * @author javer
 */
public class Cuota {
    
    private int numeroCuota;
    private double montoTotalCuota;
    private boolean pagada;
    private LocalDate fechaVencimiento;
    private FormaPago formaPago;

    public Cuota() {
    }

    public Cuota(int numeroCuota, double montoTotalCuota, LocalDate fechaVencimiento, 
                FormaPago formaPago) {
        this.numeroCuota = numeroCuota;
        this.montoTotalCuota = montoTotalCuota;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMontoTotalCuota() {
        return montoTotalCuota;
    }

    public void setMontoTotalCuota(double montoTotalCuota) {
        this.montoTotalCuota = montoTotalCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void marcarPagada() {
        this.pagada = true;
    }
    
    @Override
    public String toString() {
        return "Cuota{" + "Número Cuota=" + numeroCuota + ", Monto Total Cuota=" + montoTotalCuota +
                ", pagada=" + pagada + ", fecha Vencimiento=" + fechaVencimiento + ", forma Pago=" +
                formaPago + '}';
    }
    
    
}
