
public class Hunter extends PhysicalClass{

	
	//Constructors
	public Hunter(String name) {	//For brand new Hunters
		super(name);
	}
	
	public Hunter(byte level, String name, int experience, Weapon weapon, Armor armor, int stamina) {  //Used to instance with information from JSON
		super(level,name,experience,weapon,armor);
		this.setStamina(stamina);
	}
	
	@Override
	public void lernNewSkill(PhysicalSkill newSkill) {
		if(! this.getSkillList().contains(newSkill)) {
			if(newSkill.getAviableClasses().contains("Hunter")) {
				if(newSkill.getLevelRequired() <= this.getLevel())
					this.skillList.add(newSkill);
			}
		}
	}
	
	@Override
	public void equipWeapon(Weapon weapon) {
		if(weapon != null && weapon instanceof Bow) {
			this.equipedWeapon = weapon;
		}
	}
	
}
