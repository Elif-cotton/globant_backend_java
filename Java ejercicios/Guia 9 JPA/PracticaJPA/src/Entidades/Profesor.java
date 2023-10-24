
package Entidades;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author javer
 */

@NamedQueries({
@NamedQuery(
        name="Profesor.buscarTodos",
        query="SELECT p FROM Profesor p"
),
@NamedQuery(
        name="Profesor.buscarPorId",
        query="SELECT p FROM Profesor p WHERE p.id = :id"
)
})
@Entity
@Table(name="profesores")
public class Profesor extends Persona implements Serializable{
    
   @OneToMany(mappedBy="profesor")
    private Set<Curso> cursos;

    public Profesor() {
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
     
}
