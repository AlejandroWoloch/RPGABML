import java.io.Serializable;
import java.util.Objects;


public abstract class Character extends Base implements ISystemMessage, Serializable {

	// Attributes
	private static final long serialVersionUID = 1L;
	private byte level;
	private static byte maxLevel = 50;
	private static short baseAttack = 5;
	private static short baseDefense = 2;
	private static short baseHp = 50;
	private int currentHP;
	
	// Constructor
	public Character(byte level, String name) throws Exception {
		super();
		this.setLevel(level);
		this.setName(name);
		this.setCurrentHP(this.calculateHp());
		
	}

	// Methods
	public void setCurrentHP(int currentHP) {
		this.currentHP = Math.max(0, currentHP);
	}
	
	public int getCurrentHP() {
		return this.currentHP;
	}
	
	public void takeDamage(int damageRecived) {
		this.setCurrentHP(this.getCurrentHP() - damageRecived);
	}
	
	/**
	 * Abstract method to calculate the attack (damage) of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public short calculateAttack() {
		short random = (short)(Math.random() * (1 - 0)); 
		return (short) (Character.baseAttack  + ( Character.baseAttack * random ) * this.level);
	}
	
	/**
	 * Abstract method to calculate the defense of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public short calculateDefense() {
		return (short) ((Character.baseDefense * this.level) + (this.calculateHp() * 0.05));
	}
	
	/**
	 * Abstract method to calculate the hp of a character
	 * 
	 * This method will be defined and implemented by the child classes
	 * */
	public short calculateHp() {
		return (short) ((Character.baseHp * this.level) - (0.5 * this.calculateAttack()));
	}

	// Override equals method.
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().isInstance(Character.class)) {
			return ((Character) obj).getId() == this.getId();
		} else {
			return false;
		}
	}
	
	// Override hashCode method.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Override toString method.
	@Override
	public String toString() {
		return "Character [Id = " + getId() + ", Level = " + getLevel() + ", Name = " + getName() + " ]";
	}

	// Getters and Setters	
	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) throws Exception {
		if((level > 0) && (level < this.getMaxLevel())) {			
			this.level = level;
		} else {
			String setLevelError = "Level must be higher than zero.";
			throw new Exception(valueErrorMessage + setLevelError);
		}
	}

	public byte getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(byte maxLevel) throws Exception {
		if(maxLevel > 1) {
			Character.maxLevel = maxLevel;			
		} else {
			String setMaxLevelError = "Max level must be higher than one.";
			throw new Exception(valueErrorMessage + setMaxLevelError);
		}
	}

	public void setName(String name) throws Exception {
		if(name.length() > 0) {
			this.name = name;
		} else {
			String setNameError = "This is not a valid name";
			throw new Exception(valueErrorMessage + setNameError);
		}
	}

	public static short getBaseAtack() {
		return baseAttack;
	}

	public static void setBaseAtack(short baseAttack) throws Exception {
		if(baseAttack > 0) {			
			Character.baseAttack = baseAttack;
		} else {
			String setBaseAttackError = "Base Attack must be higher than zero.";
			throw new Exception(valueErrorMessage + setBaseAttackError);
		}
	}

	public static short getBaseDefense() {
		return baseDefense;
	}

	public static void setBaseDefense(short baseDefense) throws Exception {
		if(baseDefense > 0) {			
			Character.baseDefense = baseDefense;
		} else {
			String setBaseDefenseError = "Base Defense must be higher than zero.";
			throw new Exception(valueErrorMessage + setBaseDefenseError);
		}
	}

	public static short getBaseHp() {
		return baseHp;
	}

	public static void setBaseHp(short baseHp) throws Exception {
		if(baseHp > 0) {			
			Character.baseHp = baseHp;
		} else {
			String setBaseHPError = "Base HP must be higher than zero.";
			throw new Exception(valueErrorMessage + setBaseHPError);
		}
	}

}
