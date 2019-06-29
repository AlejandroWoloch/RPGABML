import java.util.ArrayList;

public abstract class MagicalClass extends PlayableCharacter {

 	// Attributes
	private static final int maxMana = 100;
	private int mana;
	private int inteligence;
	protected ArrayList<Spell> spellList; // CRUD<Spell>
	protected static final String errorMessage = "Error: Invalid value";

	//Constructors
	public MagicalClass(String name, int mana, int inteligence) throws Exception {
		super(name);
		this.setMana(mana);
		this.setInteligence(inteligence);
		this.spellList.init();
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
	}
 	
 	// Methods
 	public abstract void lernNewSpell(Spell newSpell);

	public void forgetSkill(int id) {
		try {
			this.spellList.delete(id);
        }catch (Exception error){
            throw error;
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
		String messageFmt = "\n=> MagicalClass\n[Mana: %d, Inteligence: %d]";
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
			throw new Exception(MagicalClass.errorMessage + setManaError);
		}
	}

 	public int getMaxMana() {
		return maxMana;
	}

 	public ArrayList<Spell> getSpellList() {
		return this.spellList;
	}

	public int getInteligence() {
		return inteligence;
	}

	public void setInteligence(int inteligence) throws Exception {
		if (inteligence > 0) {
			this.inteligence = inteligence;			
		} else {
			String setInteligenceError = "Mana should be higher than zero and smaller than max Mana";
			throw new Exception(MagicalClass.errorMessage + setInteligenceError);
		}
	}
}