package entidades;

import enumeraciones.Rol;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor //constructor todos los argumentos
@ToString
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected String id;

    protected String nombre;
    protected String password;
    protected String email;
    protected LocalDate fechaAlta;
    protected Boolean activo;

    @Enumerated(EnumType.STRING)
    protected Rol rol;


}
