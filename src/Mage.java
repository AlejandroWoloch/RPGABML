
public class Mage extends MagicalClass {

	// Attributes
	
	// Constructors
	public Mage(String name, int mana, int inteligence) {
		super(name, mana, inteligence);
		
	}
	
	public Mage(String name, int mana, int inteligence, byte level, int experience ) {
		super(level, name, experience, mana, inteligence);
		
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
		super.toString();
		/*String base = super.toString();
		String messageFmt = "\n=> Spell\n[Damage: %d]";
		return base.concat(String.format(messageFmt, getDamage()));*/
	}
	
	// Getters and Setters
}
