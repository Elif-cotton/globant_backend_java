
package entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author javer
 */

@Entity
@ToString
@AllArgsConstructor 
@Getter
@Setter
@Table(name="administradores")
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Usuario implements Serializable{
    
   
}
