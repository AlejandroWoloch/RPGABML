import java.io.Serializable;
import java.util.Objects;


public abstract class Ability extends Base implements ISystemMessage, Serializable {

	//Attributes
	private static final long serialVersionUID = 1L;
	private byte level;
	protected final byte maxLevel = 50;
	private String classUser; //Class that can use this ability
	
	
	//Constructor
	public Ability(String name, byte level, String classUser) throws Exception {
		super();
		this.setName(name);
		this.setLevel(level);
	}
	
	public Ability(String name, String classUser) throws Exception {
		this.setName(name);
		this.setLevel((byte) 1);
	}

	//Getters and setters
	public int getMaxLevel(){
		return this.maxLevel;
	}

	public void setName(String name) throws Exception {
		if(name.length() > 0) {
				this.name = name;			
		} else {
				String setNameError= "The name should have at least one character";
				throw new Exception(valueErrorMessage + setNameError);
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
			throw new Exception(valueErrorMessage + setLevelError);
		}
	}
	
	public String getClassUser() {
		return this.classUser;
	}
	
	public void setClassUser(String classUser) throws Exception {
		if(classUser.length() > 0) {
				this.classUser = classUser;		//To be changed for a comprobation of the names of the existing classes	
		} else {
				String setClassUserError= "The name of the Class that can use this Ability should have at least one character";
				throw new Exception(valueErrorMessage+ setClassUserError);
		}
	}
	
	//Methods
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
		String message= "Ability [Id: %d, Name: %s, Level: %d, Class User: %s]";
		return String.format(message, this.getId(), this.getName(), this.getLevel(), this.getClassUser());
	}

	

}
