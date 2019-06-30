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
	    List<T> create(T obj) {
	    	if(obj != null) {
	    		list.add(obj);
	        } else {
	        	throw new Exception("The object does not have to be an empty object");
	        }
	    }
	    
	    /**
	     * READ method
	     * Show the content of the List
	     */
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
	    
	    /**
	     * DELETE method
	     * Delete an Object based on its id
	     */
	    void delete(int id) {
	    	T obj=find(id);
	    	list.remove(obj);
	    }
	    
	    
	    // Other methods
	    /**
	     * GETLIST method
	     * returns the List
	     */
	    List<T> getList(){
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
	     */
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
	    	if (obj==null) {
	    		throw new Exception("There's no element with this ID");
	    	}
	    	return obj;
	    }
}