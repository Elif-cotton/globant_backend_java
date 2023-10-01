
package Entidad;

/**
 *
 * @author javer
 */
public class Pelicula {
    
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;

    public Pelicula() {
    }

    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }


    public int getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }


    public String getDirector() {
        return director;
    }

    
    @Override
    public String toString() {
        return "'" + titulo + "' del director " + director + ", con una duración de " 
                + duracion + " minutos y la edad mínima es de " + edadMinima + " años";
    }
}
