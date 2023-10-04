
package Entidades;

/**
 *
 * @author javer
 */
public class Polideportivo extends Edificio{
    
    private String nombre;
    private String tipoInstalacion;

    public Polideportivo() {
    }

    public Polideportivo(String nombre, String tipoInstalacion, double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }
    
    
    @Override
    public double calcularSuperficie() {
       return 2 * (ancho * largo + ancho * alto + largo * alto);
    }

    @Override
    public double calcularVolumen() {
        return ancho * alto * largo;
    }
    
    
    
}
