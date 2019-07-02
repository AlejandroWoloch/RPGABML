
public class HealingSpell extends Spell {
	
	// Attributes
	private static final long serialVersionUID = 1L;

	// Constructors
	public HealingSpell(int healing, String name, String classUser) throws Exception {
		super(Math.abs(healing)*(-1), name, classUser);
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
		return super.toString();
	}
}
