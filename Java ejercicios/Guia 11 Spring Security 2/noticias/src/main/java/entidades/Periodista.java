package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author javer
 */

@Entity
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor      //constructor todos los argumentos
@ToString
@DiscriminatorValue("PERIODISTA")
public class Periodista extends Usuario implements Serializable{
        
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private ArrayList<Noticia> misNoticias;

    private Integer sueldoMensual;
}
