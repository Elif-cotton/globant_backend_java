package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor      //constructor todos los argumentos
@ToString
@Table(name="noticias")
public class Noticia {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String Id;

    private String titulo;
    private String cuerpo;
    private Boolean alta;
    
    @ManyToOne
    @JoinColumn(name = "periodista_id")
    private Periodista creador;
    
    
}
