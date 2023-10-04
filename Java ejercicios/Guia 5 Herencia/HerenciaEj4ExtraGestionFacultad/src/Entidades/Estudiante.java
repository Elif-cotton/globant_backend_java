
package Entidades;

/**
 *
 * @author javer
 */
public class Estudiante extends Persona{
     
    private String cursoMatriculado;

    public Estudiante() {
    }

    public Estudiante( String nombre, String apellidos, String numeroIdentificacion, String estadoCivil, String cursoMatriculado) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.cursoMatriculado = cursoMatriculado;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public void matricularEnCurso(String nuevoCurso) {
        cursoMatriculado = nuevoCurso;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre completo: " + nombre + " " + apellidos);
        System.out.println("Identificación: " + numeroIdentificacion);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Curso matriculado: " + cursoMatriculado);
        if (!cursoMatriculado.equals("Ingeniería Informática")) {
            System.out.println("¡Has sido matriculado en otro curso!");
        }
    }
}
