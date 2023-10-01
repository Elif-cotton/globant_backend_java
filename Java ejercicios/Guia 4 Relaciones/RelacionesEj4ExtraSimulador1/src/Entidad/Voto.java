
package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javer
 */
public class Voto {
    
    Alumno alumnoQueVota;
    List<Alumno> alumnosVotados;

    public Voto(Alumno alumnoQueVota) {
        this.alumnoQueVota = alumnoQueVota;
        this.alumnosVotados = new ArrayList<>();
    }

    public boolean agregarVoto(Alumno alumnoVotado) {
       
        if (alumnosVotados.size() < 3 && !alumnoQueVota.getDNI().equals( alumnoVotado.getDNI())
                && !alumnosVotados.contains(alumnoVotado)) {
            alumnosVotados.add(alumnoVotado);
            alumnoVotado.votosRecibidos.add(this);
            alumnoVotado.incrementarVotos();
            return true;
        }
        return false;
    
    }
    
}
