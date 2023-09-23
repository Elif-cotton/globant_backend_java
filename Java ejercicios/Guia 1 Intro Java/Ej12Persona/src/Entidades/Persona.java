package Entidades;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private LocalDate FechaNacimiento;

    public Persona() {

    }

    public Persona(String nombre, LocalDate FechaNacimiento) {
        this.nombre = nombre;
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", FechaNacimiento=" + FechaNacimiento + '}';
    }
}
