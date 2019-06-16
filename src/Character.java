
public abstract class Character {

	// Attributes
	private static int count = 0;
	private int id;
	private byte level;
	private static byte maxLevel = 50;
	private static short baseAtack = 5;
	private static short baseDefense = 2;
	private static short baseHp = 50;
	private String name;
	
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
		return (short) (Character.baseAtack  + ( Character.baseAtack * random ) * Character.baseHp);
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

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId() {
		this.id = ++Character.count;
	}
	
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
		Character.maxLevel = maxLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Character.count = count;
	}

	public static short getBaseAtack() {
		return baseAtack;
	}

	public static void setBaseAtack(short baseAtack) {
		Character.baseAtack = baseAtack;
	}

	public static short getBaseDefense() {
		return baseDefense;
	}

	public static void setBaseDefense(short baseDefense) {
		Character.baseDefense = baseDefense;
	}

	public static short getBaseHp() {
		return baseHp;
	}

	public static void setBaseHp(short baseHp) {
		Character.baseHp = baseHp;
	}

}
