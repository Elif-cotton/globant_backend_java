
package Entidad;

import java.time.LocalDate;


public class Tarea {
    
    private int id;
    private String descripcion;
    private LocalDate fecha;

    public Tarea() {
        
    }

    public Tarea(int id, String descripcion, LocalDate fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
    
    
}
