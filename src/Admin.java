
public class Admin extends User{

	//Atributes
	CRUD<User> users = null;
	CRUD<NonPlayableCharacter> monsters = null;
	CRUD<Spell> spells = null;
	CRUD<PhysicalSkill> skills = null;
	
	
	//Constructors
	public Admin(String name, String username, String email) throws Exception {
		super(name, username, email);
		this.initializateCRUDs();
		this.getAllDataFromDM();
	}

	public Admin(String name, String username, String password, String email) throws Exception {
		super(name, username, password, email);
		this.initializateCRUDs();
		this.getAllDataFromDM();
	}

	//Used By the Constructors to initialize all the CRUDs
	private void initializateCRUDs() {
		users = new CRUD<User>();
		monsters = new CRUD<NonPlayableCharacter>();
		spells = new CRUD<Spell>();
		skills = new CRUD<PhysicalSkill>();
	}
	
	public void getAllDataFromDM() throws Exception {
		users.updateAll(Main.castList(User.class, DataManager.getData(DataManager.Colection.USER)));
		monsters.updateAll(Main.castList(NonPlayableCharacter.class, DataManager.getData(DataManager.Colection.NONPLAYABLECHARACTER)));
		spells.updateAll(Main.castList(Spell.class, DataManager.getData(DataManager.Colection.SPELL)));
		skills.updateAll(Main.castList(PhysicalSkill.class, DataManager.getData(DataManager.Colection.PHYSICALSKILL)));
	}
	
	public void getDataFromDM(DataManager.Colection colection) throws Exception {
		
		switch(colection) {
		case USER:
			users.updateAll(Main.castList(User.class, DataManager.getData(DataManager.Colection.USER)));
			break;
		case NONPLAYABLECHARACTER:
			monsters.updateAll(Main.castList(NonPlayableCharacter.class, DataManager.getData(DataManager.Colection.NONPLAYABLECHARACTER)));
			break;
		case SPELL:
			spells.updateAll(Main.castList(Spell.class, DataManager.getData(DataManager.Colection.SPELL)));
			break;
		case PHYSICALSKILL:
			skills.updateAll(Main.castList(PhysicalSkill.class, DataManager.getData(DataManager.Colection.PHYSICALSKILL)));
			break;
		default:
			throw new Exception ("Wrong type");
		}
	}
	
	public void updateDataIntoDM(DataManager.Colection colection) throws Exception{
		
		switch(colection) {
		case USER:
			DataManager.updateData(colection, users.getList());
			break;
		case NONPLAYABLECHARACTER:
			DataManager.updateData(colection, monsters.getList());
			break;
		case SPELL:
			DataManager.updateData(colection, spells.getList());
			break;
		case PHYSICALSKILL:
			DataManager.updateData(colection, skills.getList());
			break;
		default:
			throw new Exception ("Wrong type");
		}	
	}
	
	public void updateAllDataIntoDM() throws Exception{
		DataManager.updateData(DataManager.Colection.USER, users.getList());
		DataManager.updateData(DataManager.Colection.NONPLAYABLECHARACTER, monsters.getList());
		DataManager.updateData(DataManager.Colection.SPELL, spells.getList());
		DataManager.updateData(DataManager.Colection.PHYSICALSKILL, skills.getList());
	}
	
	public void administrateMonsters() {
		System.out.println("MONSTRUOS\n1. Mostrar Lista\n2. Crear nuevo monstruo\n3. Buscar Monstruo\n4. ");
	}
	
	public void administrateUsers() {
		
	}
}
