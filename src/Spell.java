public abstract class Spell extends Ability {

	// Attributes
	private int damage;
	
	// Constructors
	public Spell(int damage, String name, String classUser) throws Exception {
		super(name, classUser);
		this.setDamage(damage);
	}
	
	public Spell(String name, byte level, String classUser, int damage) throws Exception {
		super(name, level, classUser);
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
	

	// Getters and Setters
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) throws Exception {
		if (damage > 0) {
			this.damage = damage;			
		} else {
			String setManaError = "The spell damage must be higher than zero.";
			throw new Exception(valueErrorMessage + setManaError);
		}
	}	
}
