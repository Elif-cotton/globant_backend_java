package gm.contactos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data                 //métodos getter & setter se crean de forma automática
@NoArgsConstructor     //constructor vacío
@AllArgsConstructor      //constructor todos los argumentos
@ToString
@Table(name="contactos")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContacto;
    String nombre;
    String celular;
    String email;

}
