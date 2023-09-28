package Entidades;

public class Libro {
    private String tituloLibro;
    private String autor;
    private int numeroLibros;
    private int librosPrestados;

    public Libro() {

    }

    public Libro(String tituloLibro, String autor, int numeroLibros, int librosPrestados) {
        this.tituloLibro = tituloLibro;
        this.autor = autor;
        this.numeroLibros = numeroLibros;
        this.librosPrestados = librosPrestados;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroLibros() {
        return numeroLibros;
    }

    public void setNumeroLibros(int numeroLibros) {
        this.numeroLibros = numeroLibros;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Libro{" + "Título Libro=" + tituloLibro + ", autor=" + autor + ", número de libros=" + numeroLibros + ", libros prestados=" + librosPrestados + '}';
    }

    public boolean prestamo() {
        if (librosPrestados < numeroLibros) {
            librosPrestados++;
            return true;
        } else {
            return false;
        }
    }

    public boolean devolucion() {
        if (librosPrestados > 0) {
            librosPrestados--;
            return true;
        } else {
            return false;
        }
    }
}
