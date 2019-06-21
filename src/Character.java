
public abstract class Character {

	// Attributes
	private static int lastId = 0;
	private int id;
	private byte level;
	private static byte maxLevel = 50;
	private static short baseAttack = 5;
	private static short baseDefense = 2;
	private static short baseHp = 50;
	private String name;
	protected static final String errorMessage = "Error: Invalid value";
	
	// Constructor
	public Character(byte level, String name) {
		this.setId();
		this.setLevel(level);
		this.setName(name);
	}

	// Methods
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// Override toString method.
	@Override
	public String toString() {
		return "Character [getId()=" + getId() + ", getLevel()=" + getLevel() + ", getName()=" + getName() + "]";
	}

	// Getters and Setters
	private static int getLastId() {
		return ++Character.lastId;
	}

	public int getId() {
		return id;
	}

	private void setId() {
		this.id = Character.getLastId();
	}
	
	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		if((level > 0) && (level < this.getMaxLevel())) {			
			this.level = level;
		} else {
			System.out.println(Character.errorMessage + ", level must be higher than zero.");
		}
	}

	public byte getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(byte maxLevel) {
		if(maxLevel > 1) {
			Character.maxLevel = maxLevel;			
		} else {
			System.out.println(Character.errorMessage + ", max level must be higher than one.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() > 0) {
			this.name = name;
		} else {
			System.out.println(Character.errorMessage + "... Dude, please... Create a name, don't be lazy");
		}
	}

	public static short getBaseAtack() {
		return baseAttack;
	}

	public static void setBaseAtack(short baseAttack) {
		if(baseAttack > 0) {			
			Character.baseAttack = baseAttack;
		} else {
			System.out.println(Character.errorMessage + ", base Attack must be higher than zero.");
		}
	}

	public static short getBaseDefense() {
		return baseDefense;
	}

	public static void setBaseDefense(short baseDefense) {
		if(baseDefense > 0) {			
			Character.baseDefense = baseDefense;
		} else {
			System.out.println(Character.errorMessage + ", base Defense must be higher than zero.");
		}
	}

	public static short getBaseHp() {
		return baseHp;
	}

	public static void setBaseHp(short baseHp) {
		if(baseHp > 0) {			
			Character.baseHp = baseHp;
		} else {
			System.out.println(Character.errorMessage + ", base HP must be higher than zero.");
		}
	}

}
