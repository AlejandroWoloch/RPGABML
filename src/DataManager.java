import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import File.PersistenceCollection;

//import Test.Padre;

public class DataManager {

	enum Colection{
		PLAYABLECHARACTER, NONPLAYABLECHARACTER, USER, SPELL, PHYSICALSKILL
	}
	
	private static Map<Colection,String> fileNames = new HashMap<Colection,String>();
	private static Map<Colection,List<Base>> data = new HashMap<Colection,List<Base>>();
	private static PersistenceCollection<Base> persistenceCollection = new PersistenceCollection<>();
	
	
	//Methods to initialize Data Manager
	/**
	 * Before using anything from DataManager you must call this method to initialize fileNames and data Maps.
	 */
	public static void initDataManager() {
		initFileNames();
		initData();
	}
	/**
	 * Alternative method to initialize and get data from files all together
	 * @throws Exception
	 */
	public static void initAndFillDataManager() throws Exception{
		initDataManager();
		readAllFiles();
	}
	
	private static void initData() {
		for (Colection colection : Colection.values()) {
			data.put(colection,new ArrayList<Base>());
		}
	}
	
	private static void initFileNames() {		
		for (Colection colection : Colection.values()) {
			fileNames.put(colection,colection.toString());
		}
	}
	
	public static List<Base> getList(Colection colection) throws Exception {
		return data.get(colection);
	}
	
	public static void writeAllFiles() throws Exception{
		for (Colection colection : Colection.values()) {
			writeFileFromSinlgeData(colection);
		}
	}
	

  	public static void readAllFiles() throws Exception{
  		for (Colection colection : Colection.values()) {
  			readDataFromSingleFile(colection);
		}
  	}
  	
  	private static void readDataFromSingleFile(Colection colection) throws Exception{
		data.put(colection, persistenceCollection.ReadFromFile(fileNames.get(colection)));
  	}
  	
  	private static void writeFileFromSinlgeData(Colection colection) throws Exception{
  		persistenceCollection.WriteIntoFile(data.get(colection), fileNames.get(colection));
  	}
	
	/* 
	 * public static String getFile(Colection colection)
   	 * 
	 */
	
	public static void show() {
		for (Colection colection : Colection.values()) {
			System.out.println(fileNames.get(colection));
		}
	}
	
	public static String serch(Colection index) {
		return fileNames.get(index);
	}
}
