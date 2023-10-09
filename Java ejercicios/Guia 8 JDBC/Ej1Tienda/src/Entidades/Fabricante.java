
package Entidades;

/**
 *
 * @author javer
 */
public class Fabricante {
    
    private int codigo;
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(String nombre) {
       // this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "código=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
