package entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Usuario implements Serializable{
    
   
}
