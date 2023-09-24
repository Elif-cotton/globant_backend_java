
package Entidad;


public class PasswordValidator {
    
    private String contrasena;
    private int minlongitud;

    public PasswordValidator() {
        
    }

    public PasswordValidator(String contrasena, int minlongitud) {
        this.contrasena = contrasena;
        this.minlongitud = minlongitud;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getMinlongitud() {
        return minlongitud;
    }

    public void setMinlongitud(int minlongitud) {
        this.minlongitud = minlongitud;
    }
    
    
   
    
}
