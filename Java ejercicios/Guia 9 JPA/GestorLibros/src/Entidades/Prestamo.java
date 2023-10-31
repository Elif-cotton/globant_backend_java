
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author javer
 */
@Entity
@Table(name="prestamo_libros")
public class Prestamo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id sea incremental, autogenerada e incrementa en 1
    private Integer id;
     
    @Column(name="fecha_prestamo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPrestamo;
    
    @Column(name="fecha_devolucion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDevolucion;
     
    @ManyToOne
    @JoinColumn(name="id_libro")  //nombre de la columna a relaciona esta tabla con la tabla libro
    private Libro Libro;  //múltiples préstamos pueden estar relacionados con un solo libro, pero un préstamo en particular se relaciona con un solo libro.
    
    @ManyToOne   //muchos prestamos a un cliente 
    @JoinColumn(name="id_cliente")  //nombre de la columna a relaciona esta tabla con la tabla prestamo
    private Cliente cliente;  
    
    @Column(name="alta")
    private boolean alta;

    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro Libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.Libro = Libro;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return Libro;
    }

    public void setLibro(Libro Libro) {
        this.Libro = Libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevoclucion=" + 
                fechaDevolucion + ", Libro=" + Libro + ", cliente=" + cliente + '}';
    }
        
}
