
public abstract class PhysicalClass extends PlayableCharacter{
	
	//Atributes
	private static final int maxStamina = 100;
	private int stamina;
	protected ArrayList<PhysicalSkill> skillList;
	private int maxSkills
	
	
	//Constructors
	public PhysicalClass(String name) { //For brand new PhysicalCharacters
		super(name);
		this.setStamina(maxStamina);
	}
	
	public PhysicalClass(byte level, String name, int experience, Weapon weapon, Armor armor, int stamina) {  //Used to instance with information from JSON
		super(level,name,experience,weapon,armor);
		this.setStamina(stamina);
	}
	
	
	//Getters and Setters
	public void setStamina(int stamina) {
		if(stamina >= 0 && stamina <= maxStamina) {
			this.stamina = stamina;
		}
	}
	
	public int getStamina() {
		return this.stamina;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}
	
	public ArrayList<PhysicalSkill> getSkillList() {
		return this.skillList;
	}
	
	public abstract void lernNewSkill(PhysicalSkill newSkill);
	
	public void forgetSkill(int id) {
		
		PhysicalSkill toRemove = null;
		
		for (PhysicalSkill skill : this.getSkillList()) {
			if(skill.getId() == id) {
				toRemove = skill;
			}
		}
		
		if(toRemove != null) {
			this.skillList.remove(toRemove);
		}
	}
}
