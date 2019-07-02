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

	public static void main(String[] args) throws Exception{
		
		ConsoleMainMenu cmm= new ConsoleMainMenu();
		cmm.menu();
	}

}
