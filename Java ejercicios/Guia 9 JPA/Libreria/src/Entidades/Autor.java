
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author javer
 */
@Entity
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id sea incremental, autogenerada e incrementa en 1
    private long id;
    private String nombre;
    private boolean alta;
}
