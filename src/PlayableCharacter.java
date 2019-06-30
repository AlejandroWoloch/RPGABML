
public abstract class PlayableCharacter extends Character{

	//Attributes
	private static final long serialVersionUID = 1L;
	private static byte baseForNextLevelXP = 100; 	//Used for levelingUp
	private int experience;					//Current XP, can't exceed experience for next level.
	
	
	//Constructors
	public PlayableCharacter(String name) throws Exception{ //For brand new Characters that will start at level 1
		super((byte) 1, name);
		this.setExperience(0);
	}
	
	public PlayableCharacter(byte level, String name, int experience) throws Exception{ //Used to instance characters with data from JSON
		super(level, name);
		this.setExperience(experience);
	}
	
	//Getters and Setters
	private void setExperience(int experience) throws Exception {	//I made it private so you are forced to use the gainExperience method
		if(experience >= 0) {
			this.experience = experience;
			if(this.isLevelingUpAviable()) {
				this.levelUp();
			}
		}
		else {
			String xpError = "You can't set experience lower than 0";
			throw new Exception(valueErrorMessage + xpError);
		}
		
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public static byte getBaseForNextLevelXP() {
		return PlayableCharacter.baseForNextLevelXP;
	}
	
	public int getNextLevelXPNeeded() {		//I did a random exponential calculation, not necessarily final
		return (int) (baseForNextLevelXP * (Math.pow(this.getLevel(), 1.5f)));
	}
	
	
	//Methods used for the leveling up of characters.
	private boolean isLevelingUpAviable() {		//Controls if current Xp exceeds required XP, and if you are not max level already
		return ((this.experience > this.getNextLevelXPNeeded()) && (this.getLevel() < this.getMaxLevel()));
	}
	
	private void levelUp() throws Exception{		//Used by setExperience method to levelUp if necessary
		int newXP = this.getExperience() - this.getNextLevelXPNeeded();
		this.setLevel((byte) (this.getLevel() + 1));
		this.setExperience(newXP);	
	}
	
	public void gainExperience(int amount) throws Exception{		//This is the method that we should use outside the class to add experience to a Playable character
		if(amount > 0) {
			this.setExperience(amount + this.getExperience());
		}
		else {
			String xpError = "You can't earn negative XP";
			throw new Exception(valueErrorMessage + xpError);
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
		return "PlayableCharacter [Current XP = " + this.getExperience() + ", XP for next level = " + this.getNextLevelXPNeeded() + " ]\n Super => " + super.toString();
	}
}
