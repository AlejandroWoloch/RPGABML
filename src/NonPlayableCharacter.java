public class NonPlayableCharacter extends Character {
	
	// Attributes
	private static final long serialVersionUID = 1L;
	private static int lastId;
	private int expRewarded;
	
	// Constructor
	public NonPlayableCharacter(String name) throws Exception {
		super((byte) 1, name);
		this.setId();
	}
	
	public NonPlayableCharacter(byte level, String name) throws Exception {
		super(level, name);
		this.setId();
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
	

	public static void setLastId(int lastId) {
		NonPlayableCharacter.lastId = lastId;
	}
	
	private static int getLastId() {
		return ++NonPlayableCharacter.lastId;
	}
	
	private void setId() {
		this.id = NonPlayableCharacter.getLastId();
	}
}
