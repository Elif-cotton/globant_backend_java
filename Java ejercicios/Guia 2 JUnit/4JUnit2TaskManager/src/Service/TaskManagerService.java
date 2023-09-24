
package Service;

import java.util.ArrayList;
import java.util.List;


public class TaskManagerService {
    
    private List<String> tasks= new ArrayList<>();
    
    
    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
