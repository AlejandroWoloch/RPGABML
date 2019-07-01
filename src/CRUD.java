import java.util.ArrayList;
import java.util.List;

public class CRUD<T extends Base> {

		// Attributes
	    List<T> list = null;
	    
	    // Methods
	    // CRUD methods
	    /**
	     * CREATE method
	     * Adds an Object in the List
	     */
	    void create(T obj) throws Exception {
	    	if(list!=null) {
	    		if(obj != null) {
	    			list.add(obj);
	    		} else {
	    			throw new Exception("The object does not have to be an empty object");
	    		}
	    	}else {
	    		throw new Exception("The list isn't initialized");
	    	}
	    }
	    
	    /**
	     * READ method
	     * Show the content of the List
	     */
	    String read(){
	    	String msg = "";
	    	
	        if(!list.isEmpty()) {
	        	for (T t : list) {
					msg += t.toString() + "\n";
				}
	        }
	        else {
	        	throw new NullPointerException("The list is empty.");
	        }
	        
	        return msg;
	    }
	    
	    /**
	     * UPDATE method
	     * Updates the value of the T object on the List
	     */
	    void update(T obj) throws Exception {
	    	if(!list.isEmpty()) {
	    		for(T t: list) {
	    			if(t.equals(obj)) {
	    				t = obj;
	    			}
	    		}
	    	}else {
	    		throw new NullPointerException("The list is empty, you can not update an object that not exist");
	    	}
	    }
	    
	    /**
	     * DELETE method
	     * Delete an Object based on its id
	     */
	    void delete(int id) throws Exception {
	    	T obj=find(id);
	    	list.remove(obj);
	    }

		// Other methods
	    /**
	     * GETLIST method
	     * returns the List
	     */
	    List<T> getList() {
	    	return list;
	    }
	    
	    /**
	     * INITIALIZE method
	     * Initialize an ArrayList: Create a new ArrayList of T Objects
	     */
	    void initialize() {
	    	list= new ArrayList<T>();
	    }
	    
	    /**
	     * FIND method
	     * Find an Object based on its id
	     * @throws Exception 
	     */
	    T find(int id) throws Exception {
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
	    	if (obj==null) {
	    		throw new Exception("There's no element with this ID");
	    	}
	    	return obj;
	    }
}
