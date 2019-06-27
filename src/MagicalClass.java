import java.util.ArrayList;

public abstract class MagicalClass extends PlayableCharacter {

 	// Attributes
	private final int maxMana = 100;
	private int mana;
	private int inteligence;
	protected ArrayList<Spell> spellList;
	protected static final String errorMessage = "Error: Invalid value";

	//Constructors
	public MagicalClass(String name, int mana) {
		super(name);
		this.setMana(mana);
	}

 	public MagicalClass(byte level, String name, int experience, int mana) {
		super(level,name,experience);
		this.setMana(mana);
	}
 	
 	// Methods
 	public abstract void lernNewSpell(Spell newSpell);

	public void forgetSkill(int id) {
		Spell toRemove = null;
	
		for (Spell spell : this.getSpellList()) {
			if(spell.getId() == id) {
				toRemove = spell;
			}
		}
	
		if(toRemove != null) {
			this.spellList.remove(toRemove);
		}
	}
 	
 	// Getters and Setters
 	public int getMana() {
 		return this.mana;
 	}
 	
	public void setMana(int mana) {
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
}