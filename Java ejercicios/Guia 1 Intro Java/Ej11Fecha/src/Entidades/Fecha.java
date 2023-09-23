package Entidades;

import java.time.LocalDate;

public class Fecha {

    private LocalDate fechaIngresada;
    private int dia;
    private int mes;
    private int anio;
    private LocalDate FechaActual;

    public Fecha() {

    }

    public Fecha(LocalDate fechaIngresada, int dia, int mes, int anio, LocalDate FechaActual) {
        this.fechaIngresada = fechaIngresada;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.FechaActual = FechaActual;
    }

    public LocalDate getFechaIngresada() {
        return fechaIngresada;
    }

    public void setFechaIngresada(LocalDate fechaIngresada) {
        this.fechaIngresada = fechaIngresada;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LocalDate getFechaActual() {
        return FechaActual;
    }

    public void setFechaActual(LocalDate FechaActual) {
        this.FechaActual = FechaActual;
    }

    @Override
    public String toString() {
        return "Fecha{" + "fechaIngresada=" + fechaIngresada + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", FechaActual=" + FechaActual + '}';
    }

}
