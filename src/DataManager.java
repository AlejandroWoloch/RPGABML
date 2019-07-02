import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import File.PersistenceCollection;

public class DataManager {

	/**
	 * List of all the different classes that have instances that needs to be persisted
	 */
	enum Colection{
		PLAYABLECHARACTER, NONPLAYABLECHARACTER, USER, SPELL, PHYSICALSKILL
	}
		
	private static Map<Colection,String> fileNames = new HashMap<Colection,String>();	//File Names for persisted data, mapped to key from Colection enum
	private static Map<Colection,List<Base>> data = new HashMap<Colection,List<Base>>();	//Data to persist, mapped to key from Colection enum
	private static PersistenceCollection<Base> persistenceCollection = new PersistenceCollection<>(); //Used to persist data
	
	/**
	 * Before using anything from DataManager you must call this method to initialize fileNames and data Maps.
	 */
	public static void initDataManager() {
		initFileNames();
		initData();
	}
	
	/**
	 * Alternative method to initialize and get data from files all together
	 * 
	 * @throws Exception
  	 * inherited from PersistenceCollection.ReadFromFile()
	 */
	public static void initAndFillDataManager() throws Exception{
		initDataManager();
		readAllFiles();
	}
	
	/**
	 * Creates all empty lists and maps them to each Colection enum
	 */
	private static void initData() {
		for (Colection colection : Colection.values()) {
			data.put(colection,new ArrayList<Base>());
		}
	}
	
	/**
	 * Used to set the names of the files and map them to its corresponding Colection enum key
	 */
	private static void initFileNames() {		
		for (Colection colection : Colection.values()) {
			fileNames.put(colection,colection.toString());
		}
	}
	
	/**
	 * Used to get a single list from data hashmap
	 * 
	 * @param colection
	 * key map for the list that you want to get
	 * 
	 * @return
	 * Returns the list that is mapped to the colecion parameter int data hashmap
	 */
	public static List<Base> getData(Colection colection) {
		
		List<Base> list = new ArrayList<Base>();
		list.addAll(data.get(colection));
		
		return list;
	}
	
	
	/**
	 * Clears a list from the data hashmap
	 * 
	 * @param colection
	 * Used to indicate wich list to clear data
	 */
	public static void clearData(Colection colection) {
		data.get(colection).clear();
	}
	
	/**
	 * Replaces all elements from a list of data hashmap with given ones
	 * 
	 * @param colection
	 * Reference to which list update
	 * 
	 * @param list
	 * New elements to update data hashmap's list with
	 * 
	 * @throws Exception
	 * The given list can't be empty.
	 */
	public static void updateData(Colection colection, List<? extends Base> list) throws Exception{
  		if(! list.isEmpty()) {
  	  		data.get(colection).clear();
  	  		data.get(colection).addAll(list); 			
  		}
  		else {
  			throw new Exception("Can't update data with an empty list. Try clear instead");
  		}
  	}
	
	/**
	 * Writes all files with the information in data hashmap
	 * 
	 * @throws Exception
  	 * inherited from PersistenceCollection.WriteIntoFile()
	 */
	public static void writeAllFiles() throws Exception{
		for (Colection colection : Colection.values()) {
			writeSinlgeDataIntoFile(colection);
		}
	}
	
	/**
	 * Fills data hashmap with all the information from files
	 * 
	 * @throws Exception
  	 * inherited from PersistenceCollection.ReadFromFile()
	 */
  	public static void readAllFiles() throws Exception{
  		for (Colection colection : Colection.values()) {
  			readDataFromSingleFile(colection);
		}
  	}
  	
  	/**
  	 * Gets data from a single file and puts it into a list from the data hashmap
  	 * 
  	 * @param colection
  	 * Indicates which list from data is going to be update with its corresponding file
  	 * 
  	 * @throws Exception
  	 * inherited from PersistenceCollection.ReadFromFile()
  	 */
  	private static void readDataFromSingleFile(Colection colection) throws Exception{
		data.put(colection, persistenceCollection.ReadFromFile(fileNames.get(colection)));
  	}
  		
  	/**
  	 * Writes a single file with a single list of data hashmap
  	 * @param colection
  	 * Used to indicate which list is going to be write in its corresponding file
  	 * 
  	 * @throws Exception
  	 * inherited from PersistenceCollection.WriteIntoFile()
  	 */
  	private static void writeSinlgeDataIntoFile(Colection colection) throws Exception{
  		persistenceCollection.WriteIntoFile(data.get(colection), fileNames.get(colection));
  	}
  	
  	/**
  	 * Used to test DataManager
  	 * Shows all the fileNames
  	 */
	public static void show() {
		for (Colection colection : Colection.values()) {
			System.out.println(fileNames.get(colection));
		}
	}
	
	/**
  	 * Used to test DataManager
  	 * Shows the file's name mapped to the Colection enum key
  	 */
	public static String serch(Colection colection) {
		return fileNames.get(colection);
	}
}
