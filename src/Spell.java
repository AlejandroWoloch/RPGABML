import java.util.Objects;

public class Spell {

	// Attributes
	private static int lastId = 0;
	private static String errorMessage = "Error: Invalid value.";
	private int id;
	private String name;
	private int damage;
	
	// Constructors
	public Spell(int damage) throws Exception {
		this.setId();
		this.setDamage(damage);
	}
	
	public Spell(String name, int damage) throws Exception {
		this.setId();
		this.setName(name);
		this.setDamage(damage);
	}
	
	// Methods
	// Override equals method.
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().isInstance(Spell.class)) {
			return ((Spell) obj).getId() == this.getId();
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
		return "Spell [Id = " + getId() + " ]";
	}
	
	// Getters and Setters
	private static int getLastId() {
		return ++Spell.lastId;
	}

	public int getId() {
		return id;
	}

	private void setId() {
		this.id = Spell.getLastId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.length() > 0) {
			this.name = name;			
		} else {
			String setManaError = " The spell should have a name";
			throw new Exception(Spell.errorMessage + setManaError);
		}
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) throws Exception {
		if (damage > 0) {
			this.damage = damage;			
		} else {
			String setManaError = " The spell damage must be higher than zero.";
			throw new Exception(Spell.errorMessage + setManaError);
		}
	}
	
	
}
