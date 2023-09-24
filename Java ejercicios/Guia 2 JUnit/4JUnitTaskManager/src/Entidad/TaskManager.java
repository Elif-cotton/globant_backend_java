
package Entidad;

import java.time.LocalDate;


public class TaskManager {
    
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;

    public TaskManager() {
        
    }

    public TaskManager(String descripcion, LocalDate fechaInicio, LocalDate fechaTermino) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    @Override
    public String toString() {
        return "TaskManager{" + "descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + '}';
    }

    
    
}
