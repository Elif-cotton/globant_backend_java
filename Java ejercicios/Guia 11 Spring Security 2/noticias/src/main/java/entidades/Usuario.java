package entidades;

import enumeraciones.Rol;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor      //constructor todos los argumentos
@ToString
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String nombre;
    private String password;
    private String email;
    private Date fechaAlta;
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Rol rol;


}
