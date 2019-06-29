public class Spell extends Ability {

	// Attributes
	private static int lastId = 0;
	private static String errorMessage = "Error: Invalid value.";
	private int id;
	private int damage;
	
	// Constructors
	public Spell(int damage, String name, String classUser) throws Exception {
		super(name, classUser);
		this.setId();
		this.setDamage(damage);
	}
	
	public Spell(String name, byte level, String classUser, int damage) throws Exception {
		super(name, level, classUser);
		this.setId();
		this.setDamage(damage);
	}
	
	// Methods
	// Override equals method.
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
		String base = super.toString();
		String messageFmt = "\n=> Spell\n[Damage: %d]";
		return base.concat(String.format(messageFmt, getDamage()));
	}
	
	@Override
	public byte calculateCost() {
		// TODO Auto-generated method stub
		return 0;
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
