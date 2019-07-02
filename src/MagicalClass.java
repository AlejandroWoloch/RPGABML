import java.util.List;

public abstract class MagicalClass extends PlayableCharacter {

	// Attributes
	private static final long serialVersionUID = 1L;
	private static final int maxMana = 100;
	private int mana;
	private int inteligence;
	protected CRUD<Spell> spellList;

	//Constructors
	public MagicalClass(String name) throws Exception {
		super(name);
		this.setMana(maxMana);
		this.setInteligence(super.getLevel()*25);
		this.spellList= new CRUD<Spell>();
	}

 	public MagicalClass(
 			byte level,
 			int experience,
 			int mana,
 			int inteligence,
 			String name
 	) throws Exception {
		super(level,name,experience);
		this.setMana(mana);
		this.setInteligence(inteligence);
		this.spellList.initialize();
	}
 	
 	// Methods
 	public abstract void lernNewSpell(Spell newSpell) throws Exception;
 	public abstract void updateSpell(Spell spell) throws Exception;

	public void forgetSpell(int id) throws Exception {
		try {
			this.spellList.delete(id);
		} catch (Exception error) {
			throw new Exception("A problem emerged and the monster couldn't be added. Posible reason: " + error.getMessage());
		}
	}
	
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
		String messageFmt = "\n=> MagicalClass\n[Mana: %d, Inteligence: %d, Spells\n" + this.getSpellList().isEmpty() == null ? this.spellList.read() : "No Spells" + "]";
		return base.concat(String.format(messageFmt, getMana(), getInteligence()));
	}
		
 	// Getters and Setters
 	public int getMana() {
 		return this.mana;
 	}

	public void setMana(int mana) throws Exception {
		if(mana >= 0 && mana <= maxMana) {
			this.mana = mana;
		} else {
			String setManaError = "Mana should be higher than zero and smaller than max Mana";
			throw new Exception(valueErrorMessage + setManaError);
		}
	}

 	public int getMaxMana() {
		return maxMana;
	}

 	public List<Spell> getSpellList() {
		return spellList.getList();
	}

	public int getInteligence() {
		return inteligence;
	}

	public void setInteligence(int inteligence) throws Exception {
		if (inteligence > 0) {
			this.inteligence = inteligence;			
		} else {
			String setInteligenceError = "Intelligence should be higher than zero";
			throw new Exception(valueErrorMessage + setInteligenceError);
		}
	}
}