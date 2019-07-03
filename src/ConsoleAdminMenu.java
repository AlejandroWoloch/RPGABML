import java.util.ArrayList;

public class ConsoleAdminMenu extends ConsoleMenu {
	
	private Admin admin=null;
	
	public ConsoleAdminMenu() {
		
	}

	
	public void adminMenu(User finalUser) throws Exception {
		setAdmin((Admin)finalUser);
		admin.getAllDataFromDM();
		ArrayList<String> s= new ArrayList<>();
		s.add("Users");
		s.add("Spells");
		s.add("Skills");
		s.add("Monsters");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Accessing CRUD Users"); menuCrud("user"); break;
			case 2: System.out.println("Accessing CRUD Spells"); menuCrud("spell"); break;
			case 3: System.out.println("Accessing CRUD Skills"); menuCrud("skill"); break;
			case 4: System.out.println("Accessing CRUD Monsters"); menuCrud("monster"); break;
			case 0: DataManager.writeAllFiles(); System.exit(0);	
			}
			admin.updateAllDataIntoDM();
		}while(getOp()!=0);
	}
	
	private void menuCrud(String type) throws Exception {
		ArrayList<String> s= new ArrayList<>();
		s.add("Create");
		s.add("Delete");
		s.add("Update");
		s.add("Read");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: 
				System.out.println("Accessing to Create");
				switch(type) {
				//case "user": menuCrudUser(); break;
				//case "spell": menuCrudUser(); break;
				//case "skill": menuCrudUser(); break;
				case "monster": this.admin.createMonster(this.createMonster()); break;
				}
				break;
			case 2: System.out.println("Accessing to Delete");
				switch(type) {
				//case "user": menuCrudUser(); break;
				//case "spell": menuCrudUser(); break;
				//case "skill": menuCrudUser(); break;
				//case "monster": menuCrudUser(); break;
				}
				break;
			case 3: System.out.println("Accessing to Uelete");
				switch(type) {
				//case "user": menuCrudUser(); break;
				//case "spell": menuCrudUser(); break;
				//case "skill": menuCrudUser(); break;
				//case "monster": menuCrudUser(); break;
				}
				break;
			case 4: System.out.println("Accessing to Read");
				switch(type) {
				//case "user": menuCrudUser(); break;
				//case "spell": menuCrudUser(); break;
				//case "skill": menuCrudUser(); break;
				//case "monster": menuCrudUser(); break;
				}
				break;
			case 0: DataManager.writeAllFiles(); System.exit(0);	
			}
		}while(getOp()!=0);
		
		
	}
	
	private NonPlayableCharacter createMonster() throws Exception {
        String name;
        byte level;
        System.out.println("Ingress name: ");
        name = validatingStrings();
        System.out.println("Ingress level: ");
        level = (byte) validatingInt(100);
        return new NonPlayableCharacter((byte)level, name);
    }


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
