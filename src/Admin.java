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
	
	
	/**
	 * Methods to administrate monsters.
	 */
	
	
	/**
	 * Adds a new monster to the monsters list
	 * @param newMonster
	 * the monster that is willed to be added
	 * 
	 * @throws Exception
	 * Inherited from CRUD method create();
	 */
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
			throw new Exception ("The Monster couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
	
	
	/**
	 * Methods to administrate users.
	 */
	
	
	/**
	 * 
	 * @param newMonster
	 * @throws Exception
	 */
	public void createUser(User newUser) throws Exception{
		try {
			users.create(newUser);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the user couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	public List<User> listUsers() {
		return users.getList();
	}
	
	public User serchUserById(int id) throws Exception {
		User temp = null;
		
		try {
			temp = users.find(id);
		}
		catch (Exception e) {
			throw new Exception("Couldn't find an user with that Id. Posible reason: " + e.getMessage());
		}
		
		return temp;
	}
	
	public void updateUser(User modifiedUser) throws Exception {
		try {
			users.update(modifiedUser);
		}
		catch (Exception e) {
			throw new Exception ("The user couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	public void deleteUser(int id) throws Exception {
		
		if(id == this.getId()) {
			throw new Exception("You can't delete yourself");
		}
		try {
			users.delete(id);
		}
		catch (Exception e) {
			throw new Exception ("The user couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
	
	
	/**
	 * Methods to administrate spells.
	 */
	
	
	/**
	 * 
	 * @param newMonster
	 * @throws Exception
	 */
	public void createSpell(Spell newSpell) throws Exception{
		try {
			spells.create(newSpell);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the spell couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	public List<Spell> listSpells() {
		return spells.getList();
	}
	
	public Spell serchSpellById(int id) throws Exception {
		Spell temp = null;
		
		try {
			temp = spells.find(id);
		}
		catch (Exception e) {
			throw new Exception("Couldn't find a spell with that Id. Posible reason: " + e.getMessage());
		}
		
		return temp;
	}
	
	public void updateSpell(Spell modifiedSpell) throws Exception {
		try {
			spells.update(modifiedSpell);
		}
		catch (Exception e) {
			throw new Exception ("The spell couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	public void deleteSpell(int id) throws Exception {
		try {
			spells.delete(id);
		}
		catch (Exception e) {
			throw new Exception ("Spell couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
	
	
	/**
	 * Methods to administrate PhysicalSkills.
	 */
	
	
	/**
	 * 
	 * @param newMonster
	 * @throws Exception
	 */
	public void createPhysicalSkill(PhysicalSkill newPhysicalSkill) throws Exception{
		try {
			skills.create(newPhysicalSkill);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the skill couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	public List<PhysicalSkill> listPhysicalSkill() {
		return skills.getList();
	}
	
	public PhysicalSkill serchPhysicalSkillById(int id) throws Exception {
		PhysicalSkill temp = null;
		
		try {
			temp = skills.find(id);
		}
		catch (Exception e) {
			throw new Exception("Couldn't find a skill with that Id. Posible reason: " + e.getMessage());
		}
		
		return temp;
	}
	
	public void updatePhysicalSkill(PhysicalSkill modifiedPhysicalSkill) throws Exception {
		try {
			skills.update(modifiedPhysicalSkill);
		}
		catch (Exception e) {
			throw new Exception ("The skill couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	public void deletePhysicalSkill(int id) throws Exception {
		try {
			skills.delete(id);
		}
		catch (Exception e) {
			throw new Exception ("Skill couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
}
