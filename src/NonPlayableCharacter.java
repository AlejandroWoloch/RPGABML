import java.util.Objects;
//import java.util.ArrayList; //TODO: remove this o implement an Item interface

public class NonPlayableCharacter extends Character {
	
	// Attributes
	private short expRewarded;
	//private ArrayList<Item> loot;  //TODO: remove this o implement an Item interface
	
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
			String error = super.errorMessage; //TODO: How do I fix this?
			System.out.println(error + "... Experience rewarded must be higher than zero.");
		}
	}	
}
