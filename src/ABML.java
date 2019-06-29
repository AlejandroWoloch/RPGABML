import java.util.ArrayList;
import java.util.List;

public class ABML<T> {

	    List<T> list = null; //Se instancia en el constructor
	    
	    void list(){
	        if(! list.isEmpty()) {
	        	for (T t : list) {
					System.out.println(t.toString() + "\n");
				}
	        }
	        else {
	        	System.out.println("No elements in this list.");
	        }
	    }
}
