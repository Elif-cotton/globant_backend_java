
package Entidad;


public class DateValidator {
    
    private int anio;
    private int mes; 
    private int dia;

    public DateValidator() {
        
    }

    public DateValidator(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "DateValidator{" + "anio=" + anio + ", mes=" + mes + ", dia=" + dia + '}';
    }
    
    
}
