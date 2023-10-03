
package herenciaej1animal;

import Entities.Animal;
import Entities.Cat;
import Entities.Dog;
import Entities.Horse;

/**
 *
 * @author javer
 */
public class HerenciaEj1Animal {

    public static void main(String[] args) {
        
        System.out.println("Dog:");
        //dog object declaration
        Animal dog=new Dog("Stich","meat",15,"Doberman");
        
        dog.feed();
        
        //declaration of another object dog
        Dog dog1=new Dog("Teddy", "croquettes",10,"Chihuahua");
        dog1.feed();
        
        //cat object declaration
        System.out.println("Cat:");
        Animal cat=new Cat("Pelusa", "cookies",15,"Siames");
        cat.feed();
        
        //horse object declaration
        System.out.println("Horse");
        Animal horse=new Horse("Spark", "grass",25,"Fino");
        horse.feed();
    }
    
}
