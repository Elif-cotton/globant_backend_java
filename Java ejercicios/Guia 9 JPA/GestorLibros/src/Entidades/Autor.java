
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author javer
 */

@Entity
@Table(name="autores")
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id sea incremental, autogenerada e incrementa en 1
    private Integer id;
    
    @Column(name="nombre_autor", unique = true)
    private String nombre;
    
    @Column(name="alta_libro")
    private boolean alta;

    public Autor() {
    }

    public Autor(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }
    
    
}
