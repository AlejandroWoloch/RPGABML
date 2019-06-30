public abstract class PhysicalSkill extends Ability {

	// Attributes
	private static final long serialVersionUID = 1L;
	private int damage;
	
	// Constructors
	public PhysicalSkill(int damage, String name, String classUser) throws Exception {
		super(name, classUser);
		this.setDamage(damage);
	}
	
	public PhysicalSkill(String name, byte level, String classUser, int damage) throws Exception {
		super(name, level, classUser);
		this.setDamage(damage);
	}
		
	//Getters and Setters
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) throws Exception{
		if (damage > 0) {
			this.damage = damage;			
		} else {
			String setDamgeError = "The spell damage must be higher than zero.";
			throw new Exception(valueErrorMessage + setDamgeError);
		}
	}
	
	// toString, equals and hashCode
	@Override
	public boolean equals(Object obj) {
        return super.equals(obj);
    }

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		String base = super.toString();
		String messageFmt = "\n=> Spell\n[Damage: %d]";
		return base.concat(String.format(messageFmt, getDamage()));
	}
}
