
package Entidad;

/**
 *
 * @author javer
 */
public class Cine {
    
    private Asiento asientos[][];
    private double precio;
    private Pelicula pelicula;

    public Cine(int filas, int columnas, double precio, Pelicula pelicula) {
        
        asientos=new Asiento[filas][columnas]; //generar array
        this.precio=precio;
        this.pelicula=pelicula;
        rellanaButacas();
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    private void rellanaButacas(){
        
        int fila=asientos.length;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                asientos[i][j]=new Asiento((char)('A'+j),fila); //A=65, 65+0=A, 65+1=B.. j debe llegar a 6
            }
            fila--;
        }
    }
    
    public boolean haySitio(){
        
        boolean haySitio=false;
        int fila=asientos.length;
        for (int i = 0; i < asientos.length && !haySitio; i++) {     //&& !haySitio o break; encuentra sitio sale
            for (int j = 0; j < asientos[0].length && !haySitio; j++) {
                if(!asientos[i][j].ocupado()){
                    haySitio=true;
                }
            }
           
        }
        return haySitio;
    }
    
     public Asiento getAsiento(int fila, char letra){
        return asientos[asientos.length-fila-1][letra-'A'];
    }
     
    //pregunta si un asiento específico está vacío 
    public boolean haySitioButaca(int fila, char letra){
        return getAsiento(fila, letra).ocupado();
    }
    
    
    //le alcanza el dinero para comprar la entrada
    public boolean tieneDinero(Espectador espectador){
        
        return espectador.getDinero() >= precio;
        
    }
    
    //juntar las 3 condiciones para comprar entrada
    public boolean sePuedeSentar(int fila, char letra,Espectador espectador ){
        return tieneDinero(espectador) && pelicula.tieneEdad(espectador);
    }
    
    public void sentar(int fila, char letra,Espectador espectador){
        getAsiento(fila, letra).setEspectador(espectador);
    }
    
    public int getFilas(){
        return asientos.length;
    }
    
    public int getColumnas(){
        return asientos[0].length;
    }
     
    
     public void mostrarCine() {

        System.out.println("Información cine");
        System.out.println("Pelicula reproducida: " + pelicula);
        System.out.println("Precio entrada: " + precio);
        System.out.println("");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                System.out.println(asientos[i][j]);
            }
            System.out.println("");
        }
    }
}
