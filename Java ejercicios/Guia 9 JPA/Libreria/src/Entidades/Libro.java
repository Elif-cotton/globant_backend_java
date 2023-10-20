
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author javer
 */
@Entity
@Table(name="libros")
public class Libro implements Serializable {
    
    @Id
    private long isbn;
    
    @Column(name="titulo_libro")
    private String titulo;
    @Column(name="año_publicación")
    private Integer anio;
    @Column(name="número_ejemplares")
    private Integer ejemplares;
    @Column(name="libros_prestados")
    private Integer ejemplaresPrestados;
    @Column(name="ejemplares_restantes")
    private Integer ejemplaresRestantes;
    @Column(name="alta")
    private boolean alta;
    
    @ManyToOne     //relación muchos libros tiene un autor
    @JoinColumn(name="id_autor")  //nombre de la columna a relaciona esta tabla con la tabla autor
    private Autor autor;
     
    @ManyToOne
    @JoinColumn(name="id_editorial")  //nombre de la columna a relaciona esta tabla con la tabla editorial
    private Editorial editorial;

    public Libro() {
    }

    public Libro(long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    
}
