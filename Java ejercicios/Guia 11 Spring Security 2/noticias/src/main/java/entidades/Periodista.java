
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="periodistas")
public class Periodista extends Usuario implements Serializable{
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private ArrayList<Noticia> misNoticias;

    private Integer sueldoMensual;
}
