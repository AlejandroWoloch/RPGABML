import java.util.List;

public class Admin extends User{

	//Attributes
	private static final long serialVersionUID = 1L;
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

	/**
	 * Used By the Constructors to initialize all the CRUDs
	 */
	private void initializateCRUDs() {
		users = new CRUD<User>();
		monsters = new CRUD<NonPlayableCharacter>();
		spells = new CRUD<Spell>();
		skills = new CRUD<PhysicalSkill>();
	}
	
	/**
	 * Used to get all the data from DataManager and update all admin's lists with it
	 * 
	 * @throws Exception
	 * Inherited From DataManager.getData()
	 */
	public void getAllDataFromDM() throws Exception {
		users.updateAll(Main.castList(User.class, DataManager.getData(DataManager.Colection.USER)));
		monsters.updateAll(Main.castList(NonPlayableCharacter.class, DataManager.getData(DataManager.Colection.NONPLAYABLECHARACTER)));
		spells.updateAll(Main.castList(Spell.class, DataManager.getData(DataManager.Colection.SPELL)));
		skills.updateAll(Main.castList(PhysicalSkill.class, DataManager.getData(DataManager.Colection.PHYSICALSKILL)));
	}
	
	/**
	 * Used to get the data from single DataManager colection and update its corresponding admin's list with it
	 * 
	 * @param colection
	 * DataManager.Colection enum used to key the desired list from DataManager's HashMap
	 * 
	 * @throws Exception
	 * Inherited from DataManager.getData()
	 */
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
	
	/**
	 * Used to update all data of DataManager with the modification in all admin's lists
	 * 
	 * @param colection
	 * DataManager.Colection enum used to key the desired list from DataManager's HashMap
	 * 
	 * @throws Exception
	 * Inherited from DataManager.updateData()
	 */
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
	
	/**
	 * Used to update all data of DataManager with the modification in all admin's lists
	 * 
	 * @throws Exception
	 * Inherited from DataManager.updateData()
	 */
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
	
	/**
	 * Used to get the list of monsters in the system.
	 * @return
	 * The monster list
	 */
	public List<NonPlayableCharacter> listMonsters() {
		return monsters.getList();
	}
	
	/**
	 * Used to serch a monster by its Id
	 * 
	 * @param id
	 * Id of the monster willed to find
	 * 
	 * @return
	 * The NonPlayableCharacter corresponded by the Id
	 * 
	 * @throws Exception
	 * Inherited from CRUD method find
	 */
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
	
	/**
	 * Used to update the data of a monster in the admins list
	 * 
	 * @param modifiedMonster
	 * The monster with the modified information that is willed to be updated
	 * 
	 * @throws Exception
	 * Inherited from CRUD method update
	 */
	public void updateMonster(NonPlayableCharacter modifiedMonster) throws Exception {
		try {
			monsters.update(modifiedMonster);
		}
		catch (Exception e) {
			throw new Exception ("The monster couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to remove a Monster from the admin's list
	 * 
	 * @param id
	 * Id of the Monster willed to be removed
	 * 
	 * @throws Exception
	 * Inherited from CRUD method delete
	 */
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
	 * Adds a new user to the users list
	 * @param newUser
	 * The user that is willed to be added
	 * 
	 * @throws Exception
	 * Inherited from CRUD method create();
	 */
	public void createUser(User newUser) throws Exception{
		try {
			users.create(newUser);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the user couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to get the list of users in the system.
	 * @return
	 * The users list
	 */
	public List<User> listUsers() {
		return users.getList();
	}
	
	/**
	 * Used to serch a User by its Id
	 * 
	 * @param id
	 * Id of the User willed to find
	 * 
	 * @return
	 * The User corresponded by the Id
	 * 
	 * @throws Exception
	 * Inherited from CRUD method find
	 */
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
	
	/**
	 * Used to update the data of an User in the admins list
	 * 
	 * @param modifiedMonster
	 * The User with the modified information that is willed to be updated
	 * 
	 * @throws Exception
	 * Inherited from CRUD method update
	 */
	public void updateUser(User modifiedUser) throws Exception {
		try {
			users.update(modifiedUser);
		}
		catch (Exception e) {
			throw new Exception ("The user couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to remove a User from the admin's list
	 * 
	 * @param id
	 * Id of the User willed to be removed
	 * 
	 * @throws Exception
	 * When the Id corresponds to the user that is calling this method
	 * Inherited from CRUD method delete
	 */
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
	 * Adds a new spell to the spells list
	 * @param newMonster
	 * the spell that is willed to be added
	 * 
	 * @throws Exception
	 * Inherited from CRUD method create();
	 */
	public void createSpell(Spell newSpell) throws Exception{
		try {
			spells.create(newSpell);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the spell couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to get the list of spells in the system.
	 * @return
	 * The spells list
	 */
	public List<Spell> listSpells() {
		return spells.getList();
	}
	
	/**
	 * Used to serch a Spell by its Id
	 * 
	 * @param id
	 * Id of the Spell willed to find
	 * 
	 * @return
	 * The Spell corresponded by the Id
	 * 
	 * @throws Exception
	 * Inherited from CRUD method find
	 */
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
	
	/**
	 * Used to update the data of a Spell in the admins list
	 * 
	 * @param modifiedMonster
	 * The Spell with the modified information that is willed to be updated
	 * 
	 * @throws Exception
	 * Inherited from CRUD method update
	 */
	public void updateSpell(Spell modifiedSpell) throws Exception {
		try {
			spells.update(modifiedSpell);
		}
		catch (Exception e) {
			throw new Exception ("The spell couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to remove a Spell from the admin's list
	 * 
	 * @param id
	 * Id of the Spell willed to be removed
	 * 
	 * @throws Exception
	 * Inherited from CRUD method delete
	 */
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
	 * Adds a new PhysicalSkills to the PhysicalSkills list
	 * @param newMonster
	 * the PhysicalSkills that is willed to be added
	 * 
	 * @throws Exception
	 * Inherited from CRUD method create();
	 */
	public void createPhysicalSkill(PhysicalSkill newPhysicalSkill) throws Exception{
		try {
			skills.create(newPhysicalSkill);
		}
		catch (Exception e) {
			throw new Exception ("A problem emerged and the skill couldn't be added. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to get the list of PhysicalSkill in the system.
	 * @return
	 * The PhysicalSkill list
	 */
	public List<PhysicalSkill> listPhysicalSkill() {
		return skills.getList();
	}
	
	/**
	 * Used to serch a PhysicalSkill by its Id
	 * 
	 * @param id
	 * Id of the PhysicalSkill willed to find
	 * 
	 * @return
	 * The PhysicalSkill corresponded by the Id
	 * 
	 * @throws Exception
	 * Inherited from CRUD method find
	 */
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
	
	/**
	 * Used to update the data of a PhysicalSkill in the admins list
	 * 
	 * @param modifiedMonster
	 * The PhysicalSkill with the modified information that is willed to be updated
	 * 
	 * @throws Exception
	 * Inherited from CRUD method update
	 */
	public void updatePhysicalSkill(PhysicalSkill modifiedPhysicalSkill) throws Exception {
		try {
			skills.update(modifiedPhysicalSkill);
		}
		catch (Exception e) {
			throw new Exception ("The skill couldn't be updated. Posible reason: " + e.getMessage());
		}
	}
	
	/**
	 * Used to remove a PhysicalSkill from the admin's list
	 * 
	 * @param id
	 * Id of the PhysicalSkill willed to be removed
	 * 
	 * @throws Exception
	 * Inherited from CRUD method delete
	 */
	public void deletePhysicalSkill(int id) throws Exception {
		try {
			skills.delete(id);
		}
		catch (Exception e) {
			throw new Exception ("Skill couldn't be deleted. Posible reason: " + e.getMessage());
		}
	}
}
