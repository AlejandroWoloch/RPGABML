import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	/**
	 * Esta funcion es para poder castear un List<Base> a un List de otro tipo
	 * 
	 * @param specificClass
	 * Clase a la cual deseamos castear
	 * 
	 * @param units
	 * Lista que deseamos castear a otro tipo
	 * 
	 * @return
	 * La lista casteada al nuevo tipo
	 */
	
	@SuppressWarnings("unchecked")
	public static <T extends Base> List<T> castList(Class<T> specificClass, List<? extends Base> units) {
        return (List<T>) units;
   }

	public static void main(String[] args){
		
		/**
		 * La lista de un CRUD ya no esta vinculada por puntero a su contra parte del DataManager
		 * Por lo tanto deberan interactuar con los Getters y Update
		 * 
		 * El DataManager sera el encargado de Leer y Escribir los archivos
		 * El CRUD no tendra acceso a los archivos directamente, sino que le pedira los datos al DataManager y luego le devolvera los cambios que haya hecho
		 * 
		 * Al inicio del Programa Deberemos hacer un DataManager.initDataManager() para inicializar las listas
		 * Luego un DataManager.readAllFiles() para cargar las listas con la info de los archivos
		 * 
		 * Luego inicializaremos los CRUDs de cada tipo y le pediran los datos al data manager del siguiente modo para cada CRUD:
		 * players.updateAll(castList(Player.class, DataManager.getData(DataManager.Colection.PLAYER)));
		 * 
		 * En el transcurso del programa los CRUD iran haciendo cambios a sus datos, cuando hayan terminados y se deseara persistirlos,
		 * se debera actualizar el DataManager con los nuevos datos del CRUD, para ello haremos:
		 * DataManager.updateData(DataManager.Colection.PLAYER, players.getList());
		 * 
		 * Los enum DataManager.Colection son para indicar a cual grupo de datos nos referimos.
		 * 
		 * Una vez actualizado el DataManager con los cambios que se desean persistir, simplemente haremos un DataManager.writeAllFiles()
		 * 
		 * Actualmente solo se puede leer y escribir todos los archivos juntos, deje como privado los metodos para hacerlo en un unico archivo,
		 * esto es discutible en base a lo que queramos, es simplemente cambiar esos metodos a publico.
		 * 
		 * El ejemplo de abajo fue para probar los update del CRUD y del DataManager, no es necesariamente asi como deberiamos usarlo ajaja
		 * 
		 */
		
		/**
		 * Creo un CRUD de Players y lo inicializo con el constructor
		 */		
		CRUD<Player> players = new CRUD<Player>();
		//players.initialize();
		
		/**
		 * Cargo el CRUD Player con data y la muestro
		 */
		try {
			players.create(new Player("1","1","1","1"));
			players.create(new Player("2","2","2","2"));
			players.create(new Player("3","3","3","3"));
		} catch (Exception e) {		}
		
		System.out.println("Primer sout\n" + players.read());
		
		/**
		 * Creo una lista de players auxiliar y la cargo con data
		 */
		List<Player> auxP = new ArrayList<Player>();
		
		try {
			auxP.add(new Player("4","4","4","4"));
			auxP.add(new Player("5","5","5","5"));
			auxP.add(new Player("6","6","6","6"));
		} catch (Exception e) {		}
		
		
		/**
		 * Inicio el DataManager y remplazo la lista PLAYER con los elementos de auxP
		 */
		DataManager.initDataManager();
		try {
			DataManager.updateData(DataManager.Colection.USER, auxP);
		} catch (Exception e1) {		}
		
		
		/**
		 * Reemplazo la data del CRUD Player con lo que tengo en el DataManager
		 * Como DataManager.getData() retorna un List<Base> lo casteo a Player.class
		 * Luego vuelvo a mostrar la data de CRUD Player y efectivamente se sobreescribio.
		 */
		try {
			players.updateAll(castList(Player.class, DataManager.getData(DataManager.Colection.USER)));
		} catch (Exception e) {		}
		

		System.out.println("\nSegundo sout\n" + players.read());
	}

}
