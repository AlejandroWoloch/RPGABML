import java.io.IOException;
import java.util.Objects;

public abstract class Ability {
	//Attributes
	private static int lastId = 0;
	private int id;
	private String name;
	private byte level;
	protected final byte maxLevel = 50;
	protected final byte baseCost = 2;
	protected static final String errorMessage = "Error: Invalid value";
	
	
	//Constructor
	public Ability(String name, byte level) throws IOException {
		this.setId();
		this.setName(name);
		this.setLevel(level);
	}
	
	public Ability(String name) throws IOException {
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


	public void setName(String name) throws IOException {
		try {
			if(name.length() > 0) {
				this.name = name;			
			} else {
				throw new IOException();
			}
		}
		catch(IOException e) {
			System.out.println(Ability.errorMessage + " - Name should have a content");
		}
	}


	public byte getLevel() {
		return level;
	}


	public void setLevel(byte level) {
		try {
			if(level>0 && level<=maxLevel) {
				this.level=level;
			}else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.out.println(Ability.errorMessage + " - The level asigned isn't inside the accepted values");
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
