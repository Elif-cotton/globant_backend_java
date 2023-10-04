
package Entidades;

import Enumeracion.TipoGimnasio;

/**
 *
 * @author javer
 */
public class HotelCuatro extends Hotel {
   
    private TipoGimnasio tipoGimnasio;
    private String nombreRestaurante;
    private int capacidadRestaurante;

    public HotelCuatro() {
    }

    public HotelCuatro(TipoGimnasio tipoGimnasio, String nombreRestaurante, int capacidadRestaurante,
            int cantidadHabitaciones, int numeroCamas, int cantidadPisos, double precioHabitacion, 
            String nombre, String direccion, String localidad, String gerente) {
        super(cantidadHabitaciones, numeroCamas, cantidadPisos, precioHabitacion, nombre, direccion, 
                localidad, gerente);
        this.tipoGimnasio = tipoGimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public int getCapacidadRestaurante() {
        return capacidadRestaurante;
    }

    public void setCapacidadRestaurante(int capacidadRestaurante) {
        this.capacidadRestaurante = capacidadRestaurante;
    }
   
    
    public void setTipoGimnasio(TipoGimnasio tipoGimnasio) {
        if (tipoGimnasio == TipoGimnasio.A || tipoGimnasio == TipoGimnasio.B) {
            this.tipoGimnasio = tipoGimnasio;
            System.out.println("El tipo de gimnasio ingresado es correcto.");
        } else {
            System.out.println("Este tipo de gimnasio no existe. Solo se permiten los tipos A y B.");
        }
    }
    
    public double calcularPrecioHabitacion() {
        
        double precioHabitacion = 50; // Precio base

        // Valor agregado por el restaurante
        if (capacidadRestaurante < 30) {
            precioHabitacion += 10;
        } else if (capacidadRestaurante >= 30 && capacidadRestaurante <= 50) {
            precioHabitacion += 30;
        } else {
            precioHabitacion += 50;
        }

        // Valor agregado por el gimnasio
        if (tipoGimnasio == TipoGimnasio.A) {
            precioHabitacion += 50;
        } else if (tipoGimnasio == TipoGimnasio.B) {
            precioHabitacion += 30;
        }

        // No se agrega valor por limosinas en HotelCuatro
        
        return precioHabitacion;
    }

    @Override
    public String toString() {
        return "HotelCuatro{" + "tipo Gimnasio=" + tipoGimnasio + ", nombre Restaurante=" + nombreRestaurante +
                ", capacidad Restaurante=" + capacidadRestaurante + '}';
    }
    
    
}
