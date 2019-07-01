import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CRUD<T extends Base> {

		// Attributes
	    List<T> list = null;
	    
	    CRUD (){
	    	initialize();
	    }
	    
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
	    		throw new NullPointerException("The list isn't initialized");
	    	}
	    }
	    
	    /**
	     * READ method
	     * Show the content of the List
	     */
	    String read(){
	    	String msg = "";
	    	if(list!=null) {	
	        	if(!list.isEmpty()) {
	        		for (T t : list) {
	        			msg += t.toString() + "\n";
	        		}
	        	}
	        	else {
	        		throw new NullPointerException("The list is empty.");
	        	}
	    	}else {
	    		throw new NullPointerException("The list isn't initialized");
	    	}
	        
	        return msg;
	    }
	    
	    /**
	     * UPDATE method
	     * Updates the value of the T object on the List
	     */
	    void update(T obj) throws Exception {
	    	if(list!=null) {
	    		if(!list.isEmpty()) {
	    			for(T t: list) {
	    				if(t.equals(obj)) {
	    					t = obj;
	    				}
	    			}
	    		}else {
	    			throw new NullPointerException("The list is empty, you can not update an object that not exist");
	    		}
	    	}else {
	    		throw new NullPointerException("The list isn't initialized");
	    	}
	    }
	    
	    /*
	    List<T> getSubSet(List<Base> list){
	    	List<T> temp = new ArrayList<T>();
	    	T aux = (T) new Base();
	    	
	    	for (Base t : list) {
				if(t.getClass().isInstance(aux))
					temp.add((T) t);
			}
	    	
	    	return temp;
	    }
	    */
	    /**
	     * Replaces the elements of list with new ones from another list
	     * 
	     * @param newData
	     * list with the new values to add to list
	     * @throws Exception
	     */
	    void updateAll(List<T> newData) throws Exception {
	    	if(newData != null) {
		  		if(! newData.isEmpty()) {
		  			if(list != null){
			  	  		list.clear();
			  	  		list.addAll(newData); 	
		  			}
		  			else {
		  				throw new Exception("The list isn't initialized");
		  			}		
		  		}
		  		else {
		  			throw new Exception("Can't update list with an empty newData. Try clear() instead");
		  		}
	    	}
	    	else {
	    		throw new Exception("newData is null");
	    	}
	    }
	    
	    /**
	     * Empties list
	     * @throws Exception
	     */
	    void clear() throws Exception {
	    	if(list !=null)
	    		list.clear();
	    	else
	    		throw new Exception ("The list isn't initialized");
	    }
	    
	    /**
	     * DELETE method
	     * Delete an Object based on its id
	     */
	    void delete(int id) throws Exception {
	    	if(list!=null) {
	    		T obj=find(id);
	    		list.remove(obj);
	    	}else {
	    		throw new NullPointerException("The list isn't initialized");
	    	}
	    }

		// Other methods
	    /**
	     * GETLIST method
	     * returns a new list with the elements of list
	     */
	    List<T> getList() {
	    	List<T> temp = new ArrayList<T>();
	    	temp.addAll(list);
	    	
	    	return temp;
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
	    	if(list!=null) {
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
	    	}else {
	    		throw new NullPointerException("The list isn't initialized");
	    	}
	    	return obj;
	    }
}
