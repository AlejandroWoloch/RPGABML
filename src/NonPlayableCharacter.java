public class NonPlayableCharacter extends Character {
	
	// Attributes
	private int expRewarded;
	
	// Constructor
	public NonPlayableCharacter(byte level, String name) {
		super(level, name);
	}
	
	//Methods
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
		String messageFmt = "\n=> NonPlayableCharacter\n[Exp Rewarded: %d ]";
		return base.concat(String.format(messageFmt, getExpRewarded()));
	}

	// Getters and Setters
	public int getExpRewarded() {
		return expRewarded;
	}

	public void setExpRewarded() {
		this.expRewarded = (int) (super.calculateAttack() - super.calculateDefense() + (0.5 * super.calculateHp()));
	}	
}
