
public abstract class Character {
	// Attributes
	private byte level;
	private byte maxLevel;
	private short attackPerLevel;
	private short defensePerLevel;
	private short hpPerLevel;
	private String name;
	
	// Constructor
	public Character() {}

	// Methods
	/**
	 * Abstract method to calculate the attack (damage) of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public abstract short calculateAttack();
	
	/**
	 * Abstract method to calculate the defense of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public abstract short calculateDefense();
	
	/**
	 * Abstract method to calculate the hp of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public abstract short calculateHp();

	// Getters and Setters
	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public byte getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(byte maxLevel) {
		this.maxLevel = maxLevel;
	}

	public short getAttackPerLevel() {
		return attackPerLevel;
	}

	public void setAttackPerLevel(short attackPerLevel) {
		this.attackPerLevel = attackPerLevel;
	}

	public short getDefensePerLevel() {
		return defensePerLevel;
	}

	public void setDefensePerLevel(short defensePerLevel) {
		this.defensePerLevel = defensePerLevel;
	}

	public short getHpPerLevel() {
		return hpPerLevel;
	}

	public void setHpPerLevel(short hpPerLevel) {
		this.hpPerLevel = hpPerLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
