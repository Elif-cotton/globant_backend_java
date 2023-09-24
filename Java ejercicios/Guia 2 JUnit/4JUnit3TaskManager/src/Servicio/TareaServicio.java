
package Servicio;

import Entidad.Tarea;
import java.util.ArrayList;


public class TareaServicio {
    
    private ArrayList <Tarea> tareaList=new ArrayList();

    public TareaServicio() {
        
    }
    
    public TareaServicio(ArrayList <Tarea> tareaList) {
        this.tareaList=tareaList;
    }
    
    public void agregarTarea(Tarea tarea){
        
        tareaList.add(tarea);
    }
    
    public void eliminarTarea(Tarea tarea){
        
        tareaList.remove(tarea);
    }
    
    public ArrayList<Tarea> mostrarTareas(){
        return tareaList;
    }
}
