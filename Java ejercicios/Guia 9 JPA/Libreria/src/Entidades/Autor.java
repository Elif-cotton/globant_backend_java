
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author javer
 */
@NamedQuery(
        name="Autor.buscarPorId",
        query="SELECT a FROM Autor a WHERE a.id = :id"  //JPQL nombre de la clase para la tabla Autor
)

@Entity
@Table(name="autores")
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id sea incremental, autogenerada e incrementa en 1
    private Integer id;
    
    @Column(name="nombre_autor")
    private String nombre;
    
    @Column(name="alta_libro")
    private boolean alta;

    public Autor() {
    }

    public Autor(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    
}
