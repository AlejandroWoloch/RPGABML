import java.util.Objects;

public abstract class Ability {
	//Attributes
	private static int lastId = 0;
	private int id;
	private String name;
	private byte level;
	protected final byte maxLevel = 50;
	protected final byte baseCost = 2;
	protected static final String errorMessage = "Error: Invalid value - ";
	
	
	//Constructor
	public Ability(String name, byte level) throws Exception {
		this.setId();
		this.setName(name);
		this.setLevel(level);
	}
	
	public Ability(String name) throws Exception {
		this.setId();
		this.setName(name);
		this.setLevel((byte) 1);
	}

	//Getters and setters
	private static int getLastId() {
		return ++Ability.lastId;
	}
	
	public int getMaxLevel(){
		return this.maxLevel;
	}

	public int getId() {
		return id;
	}


	private void setId() {
		this.id = Ability.getLastId();
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) throws Exception {
		if(name.length() > 0) {
				this.name = name;			
		} else {
				String setNameError= "The name should have at least one character";
				throw new Exception(Ability.errorMessage + setNameError);
		}
	}


	public byte getLevel() {
		return level;
	}


	public void setLevel(byte level) throws Exception {
		if(level>0 && level<=maxLevel) {
			this.level=level;
		}else {
			String setLevelError= "The level should be between 1 and " + maxLevel;
			throw new Exception(Ability.errorMessage + setLevelError);
		}
	}
	
	//Methods
	
	public abstract byte calculateCost(); //The cost will be calculated by the concrete classes
	
	
	// Override equals method.
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().isInstance(Ability.class)) {
			return ((Ability) obj).getId() == this.getId();
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
		String message= "Ability [Id: %d, Name: %s, Level: %d";
		return String.format(message, this.getId(), this.getName(), this.getLevel());
	}

	

}
