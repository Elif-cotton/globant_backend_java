
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author javer
 */
@Entity
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id sea incremental, autogenerada e incrementa en 1
    private long isbn;
    @ManyToOne     //relación muchos libros tiene un autor
    private Autor autor;
    private String titulo;
    private int anio;
    private int ejemplares;
    private int ejemplaresPrestados;
    private int ejemplaresRestantes;
    private boolean alta;
    @OneToOne
    private Editorial editorial;
    
}
