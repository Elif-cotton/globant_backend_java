
package Service;


public class PasswordValidatorService {
    
    public boolean esValido(String contrasena){
        
        return tieneMinLongitud(contrasena) && 
               tieneEspecialCaracter(contrasena) &&
               tieneLetrasMayuscula(contrasena);
    }
    
    private boolean tieneMinLongitud(String contrasena){
        int minLongitud=8;
        return contrasena.length()>=minLongitud;
    }
    
    private boolean tieneEspecialCaracter(String contrasena) {
        
        String especialCaracter = "!@#$%^&*()_-+=<>?/{}~";
        
        for (char c : contrasena.toCharArray()) {
            if (especialCaracter.contains(String.valueOf(c))) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean tieneLetrasMayuscula(String contrasena) {
        
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
