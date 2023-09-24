
package Entidad;


public class DiscountCalculator {
    
    private double precio;
    private double tasaDescuento;

    public DiscountCalculator() {
        
    }

    public DiscountCalculator(double precio, double tasaDescuento) {
        this.precio = precio;
        this.tasaDescuento = tasaDescuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return tasaDescuento;
    }

    public void setDescuento(double tasaDescuento) {
        if (tasaDescuento<0 || tasaDescuento>100){
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }else{
        this.tasaDescuento = tasaDescuento;
        }
    }

    @Override
    public String toString() {
        return "DiscountCalculator{" + "precio=" + precio + ", descuento=" + tasaDescuento + '}';
    }
    
    
    
    
    
}
