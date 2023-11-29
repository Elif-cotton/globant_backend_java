
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author javer
 */

@Entity
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor      //constructor todos los argumentos
@ToString
@Table(name="administradores")
public class Administrador extends Usuario implements Serializable{
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
}
