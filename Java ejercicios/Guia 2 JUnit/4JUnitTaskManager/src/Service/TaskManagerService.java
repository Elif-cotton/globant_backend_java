
package Service;

import Entidad.TaskManager;
import java.time.LocalDate;
import java.util.ArrayList;


public class TaskManagerService {
    
    private static ArrayList <TaskManager> taskManagerList = new ArrayList <>();
    
    public static void agregarTarea(String descripcion, LocalDate fechaInicio, LocalDate fechaTermino){
        
        taskManagerList.add(new TaskManager(descripcion,fechaInicio,fechaTermino));
    }
    
    public static ArrayList<TaskManager> getTaskManagerList(){
        return taskManagerList;
    } 
            
    public static void obtenerTareas(){
        
        for (Object t: taskManagerList){
            System.out.println(t);
        }
        
    }
    
    public static void eliminarTarea(LocalDate fechaIngresada){
        
        boolean flag=true;
        
        for (int i = 0; i < taskManagerList.size(); i++){
            TaskManager task= taskManagerList.get(i);
            if(task.getFechaInicio()==fechaIngresada){
                taskManagerList.remove(i);
                System.out.println("Se ha eliminado correctamente");
                flag=false;
                break;
            }    
        } 
        if(flag)
            System.out.println("No se encontró la fecha de esa tarea");
        
    }
}
