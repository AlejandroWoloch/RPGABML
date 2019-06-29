import java.util.ArrayList;
import java.util.List;

public class CRUD<T extends Base> {

	    List<T> list = null;
	    
	    void read(){
	        if(!list.isEmpty()) {
	        	for (T t : list) {
					System.out.println(t.toString() + "\n");
				}
	        }
	        else {
	        	throw new NullPointerException("The list is empty.");
	        }
	    }
	    
	    List<T> getList(){
	    	return list;
	    }
	    
	    void initialize() {
	    	list= new ArrayList<T>();
	    }
	    
	    void delete(int id) {
	    	T obj=find(id);
	    	if(obj!=null) {
	    		list.remove(obj);
	    	}else {
	    		throw new Exception("There's no element with this ID");
	    	}
	    }
	    
	    T find(int id) {
	    	T obj=null;
	    	if(!list.isEmpty()) {
	    		for(T t: list) {
	    			if(t.getId()==id) {
	    				obj=t;
	    			}
	    		}
	    	}else {
	    		throw new NullPointerException("The list is empty");
	    	}
	    	return obj;
	    }
}
