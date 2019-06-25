public class NonPlayableCharacter extends Character {
	
	// Attributes
	private short expRewarded;
	
	// Constructor
	public NonPlayableCharacter(String name, short expRewarded) {
		super((byte) 1, name);
		this.setExpRewarded(expRewarded);
	}
	
	public NonPlayableCharacter(byte level, String name, short expRewarded) {
		super(level, name);
		this.setExpRewarded(expRewarded);
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
	public short getExpRewarded() {
		return expRewarded;
	}

	public void setExpRewarded(short expRewarded) {
		if (expRewarded > 0) {			
			this.expRewarded = expRewarded;
		} else {
			String error = super.errorMessage;
			System.out.println(error + "... Experience rewarded must be higher than zero.");
		}
	}	
}
