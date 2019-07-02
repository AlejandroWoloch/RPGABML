
public class Mage extends MagicalClass {

	// Attributes
	private static final long serialVersionUID = 1L;

	// Constructors
	public Mage(String name, int mana, int inteligence) throws Exception {
		super(name, mana, inteligence);
		
	}
	
	public Mage(String name, int mana, int inteligence, byte level, int experience ) throws Exception {
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
	public void lernNewSpell(Spell newSpell) throws Exception {
		if(! this.getSpellList().contains(newSpell)) {
			if(newSpell.getClassUser().contains("Mage")) {
				super.spellList.create(newSpell);
			} else {
				throw new Exception("You can't learn that");
			}
		} else {
			throw new Exception("You already know that");
		}
	}

	@Override
	public void updateSpell(Spell spell) throws Exception {
		if(this.getSpellList().get(spell.id) != null) {
			super.spellList.update(spell);
		} else {
			throw new Exception("You can't update an object that doesn't exist");
		}
	}
}
