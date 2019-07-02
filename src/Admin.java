import java.util.ArrayList;
import java.util.List;

public class Admin extends User{

	//Atributes
	CRUD<User> users = null;
	CRUD<NonPlayableCharacter> monsters = null;
	CRUD<Spell> spells = null;
	CRUD<PhysicalSkill> skills = null;
	
	
	//Constructors
	public Admin(String name, String username, String email, boolean getData) throws Exception {
		super(name, username, email);
		this.initializateCRUDs();
	}

	public Admin(String name, String username, String password, String email, boolean getData) throws Exception {
		super(name, username, password, email);
		this.initializateCRUDs();
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
	
	public void createMonster(NonPlayableCharacter newMonster) throws Exception{
		try {
			monsters.create(newMonster);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the monster couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	public List<NonPlayableCharacter> listMonsters() {
		return monsters.getList();
	}
	
	public NonPlayableCharacter serchMonsterById(int id) throws Exception {
		NonPlayableCharacter temp = null;
		
		try {
			temp = monsters.find(id);
		}
		catch (Exception e) {
			throw new Exception("Couldn't find a monster with that Id. Posible reason: " + e.getMessage());
		}
		
		return temp;
	}
	
	public void updateMonster(NonPlayableCharacter modifiedMonster) throws Exception {
		try {
			monsters.update(modifiedMonster);
		}
		catch (Exception e) {
			throw new Exception ("The monster couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	public void deleteMonster(int id) throws Exception {
		try {
			monsters.delete(id);
		}
		catch (Exception e) {
			throw new Exception ("monster couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
	
	
	
	public void administrateUsers() {
		
	}
}
