import java.util.Objects;

public abstract class PlayableCharacter extends Character{

	//Atributes
	private static byte nextlevelXP = 100; 	//Used for levelingUp
	private int experience;					//Current XP, can't exceed experience for next level.
	//private Weapon equipedWeapon;			//Comented until we implement Items class
	//private Armor equipedArmor;
	
	
	//Constructors
	public PlayableCharacter(String name) { //For brand new Characters that will start at level 1
		super((byte) 1, name);
		//this.equipedWeapon = null;	//Comented until we implement Items class
		//this.equipedArmor = null;
		this.setExperience(0);
	}
	
	public PlayableCharacter(byte level, String name, int experience) { //Used to instance characters with data from JSON
		super(level, name);
		this.setExperience(experience);
	}
	
	/* Replace last constructor with this once we have Items class implemented.
	public PlayableCharacter(byte level, String name, int experience, Weapon weapon, Armor armor) { //Used to instance characters with data from JSON
		super(level, name);
		this.equipWeapon(weapon);
		this.equipArmos(armor);
		this.setExperience(experience);
	}
	*/
	
	/* //Comented until we implement Items class
	public abstract void equipWeapon(Weapon weapon);
	
	public Weapon getWeapon() {
		return this.equipedWeapon;
	}
	
	public abstract void equipArmos(Armor armor);
	
	public Armor getArmor() {
		return this.equipedArmor;
	}
	*/
	
	private void setExperience(int experience) {	//I made it private so you are forced to use the gainExperience method
		if(experience >= 0) {
			this.experience = experience;
			if(this.isLevelingUpAviable()) {
				this.levelUp();
			}
		}
		
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public int getNextLevelXPNeeded() {		//I did a random exponential calculation, not necessarily final
		return (int) (nextlevelXP * (Math.pow(this.getLevel(), 1.5f)));
	}
	
	private boolean isLevelingUpAviable() {		//Controls if current Xp exceeds required XP, and if you are not max level already
		return ((this.experience > this.getNextLevelXPNeeded()) && (this.getLevel() < this.getMaxLevel()));
	}
	
	private void levelUp() {		//Used by setExperience method to levelUp if necessary
		int newXP = this.getExperience() - this.getNextLevelXPNeeded();
		this.setLevel((byte) (this.getLevel() + 1));
		this.setExperience(newXP);
	}
	
	public void gainExperience(int amount) {		//This is the method that we should use outside the class to add experience to a Playable character
		if(amount > 0) {
			this.setExperience(amount + this.getExperience());
		}
	}
	
	
	//toString and Equals
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	// Override hashCode method.
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	// Override toString method.
	@Override
	public String toString() {
		return "PlayableCharacter [Current XP = " + this.getExperience() + ", XP for next level = " + this.getNextLevelXPNeeded() + " ]" + super.toString();
	}
}
