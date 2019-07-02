
public class Cleric extends MagicalClass {

	// Attributes
	private static final long serialVersionUID = 1L;

	// Constructors
	public Cleric(String name, int mana, int inteligence) throws Exception {
		super(name, mana, inteligence);
		
	}
	
	public Cleric(String name, int mana, int inteligence, byte level, int experience ) throws Exception {
		super(level, experience, mana, inteligence, name);
		
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

	@Override
	public void lernNewSpell(Spell newSpell) {
		try {
			super.spellList.create(newSpell);
		} catch (Exception error) {
			error.getMessage();
		}
	}

	@Override
	public void updateSpell(Spell spell) {
		try {
			super.spellList.update(spell);
		} catch (Exception error) {
			error.getMessage();
		}
	}
}