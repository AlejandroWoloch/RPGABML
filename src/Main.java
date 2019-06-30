import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import File.PersistenceCollection;

public class Main {

	public static void main(String[] args) {
		String userFile = "Users";
		try {

            // List of the Team Carlu!
            List<PlayableCharacter> teamCarlu = new ArrayList<>();
            teamCarlu.add(new PlayableCharacter("Spiderman"));
            teamCarlu.add(new PlayableCharacter("Thanos"));

            // List of the Team Alee!
            List<PlayableCharacter> teamAlee = new ArrayList<>();
            teamAlee.add(new PlayableCharacter("Dr Strange"));
            teamAlee.add(new PlayableCharacter("Antman"));

            // OBJECTS TO PERSIST
            User carlos = new User("Carlos", "C4rl1t0x", "carlus@gmail.com");
            User alejandro = new User("Alejandro", "ElAlePiola", "alee@gmail.com");

            // Array to Persist
            List<User> employeesToPersist = new ArrayList<>();
            employeesToPersist.add(carlos);
            employeesToPersist.add(alejandro);

            PersistenceCollection<User> userPersistenceCollecion = new PersistenceCollection<>();

            // WRITE
            userPersistenceCollecion.WriteIntoFile(employeesToPersist, userFile);
            Scanner scanner = new Scanner(System.in);
            String cont = scanner.next();

            // READ
            List<User> usersFromFile = new ArrayList<>();
            usersFromFile = userPersistenceCollecion.ReadFromFile(userFile);
            for(User emp : usersFromFile){
                System.out.println("======================================================================");
                System.out.println(emp.toString());
                //Metodo del vendedor para listar todos los celulares, hecho para evitar hacer otro foreach y ver todos de forma mas simple
                //((Seller)emp).showCellPhones();
            }
        }
        catch (Exception e) {
            System.out.println("=> SE ROMPIO ALGO A LA HORA DE ESCRIBIR EN EL ARCHIVO!!\n\n=>Message: " + e.getMessage());
        }
	}

}
