public abstract class Spell extends Ability {

	// Attributes
	private static final long serialVersionUID = 1L;
	private int damage;
	private static int lastId;
	
	// Constructors
	public Spell(int damage, String name, String classUser) throws Exception {
		super(name, classUser);
		this.setDamage(damage);
		this.setId();
	}
	
	public Spell(String name, byte level, String classUser, int damage) throws Exception {
		super(name, level, classUser);
		this.setDamage(damage);
		this.setId();
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
	public static void setLastId(int lastId) {
		Spell.lastId = lastId;
	}
	
	private static int getLastId() {
		return ++Spell.lastId;
	}
	
	private void setId() {
		this.id = Spell.getLastId();
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}	
}
