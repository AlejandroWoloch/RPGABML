//import java.util.ArrayList;

public class NonPlayableCharacter extends Character {
	private static int count = 0;
	private int id;
	private short expRewarded;
	//private ArrayList<Item> loot;  //TODO: remove this o implement an Item interface
	
	// Constructor
	public NonPlayableCharacter(short expRewarded) {
		super();
		this.setId(++count);
		this.setExpRewarded(expRewarded);
	}
	
	//Methods
	@Override
	public short calculateAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short calculateDefense() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short calculateHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getExpRewarded() {
		return expRewarded;
	}

	public void setExpRewarded(short expRewarded) {
		this.expRewarded = expRewarded;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		NonPlayableCharacter.count = count;
	}

	
}
