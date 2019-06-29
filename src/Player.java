import java.util.Objects;

public class Player extends User { 
	/*
	 * A Player will be an User that will play the game and manage its team and items.
	 */
	
	//Attributes
	//private ABML<item> inventory; //Collections of the items that the player has.
	private PlayableCharacter team; //Character that the Player will use.
	//private ABML<PlayableCharacter team; //If there's time, there'll be a Collections of characters that the Player could use.
	private int gold; //Amount of gold the Player will have
	
	//Constructors
	public Player(String name, String username, String password, String email) throws Exception {
		super(name, username, password, email);
		this.setGold(0);
		this.team= null;
	}

	public Player(String name, String username, String email) throws Exception {
		super(name, username, email);
		this.setGold(0);
		this.team= null;
	}

	public Player(String name, String username, String password, String email, int gold) throws Exception {
		super(name, username, password, email);
		this.setGold(gold);
		this.team= null;
	}

	public Player(String name, String username, String email, int gold) throws Exception {
		super(name, username, email);
		this.setGold(gold);
		this.team= null;
	}

	
	//Getters and Setters

	public PlayableCharacter getTeam() {
		return team;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) throws Exception {
		if(gold>=0) {
			this.gold=gold;
		}else {
			String setGoldError= " You can't have negative gold";
			throw new Exception(User.errorMessage + setGoldError);
		}
	}
	
	//Methods
	public void administrateCharacters() {/*Don't know what objective will have this method*/}
	
	public void startGame() {/*Will be defined when we have all the other classes defined*/}
	
	public void createCharacter(/*Here goes every detail to define the character*/) {
		/*
		 * Here goes the logic to define which Class of playable character is being created
		 */
	}
	
	//public void administrateInventory() {} //Not going to use this for now


	//To String, Equals, Hashcode.
	
	@Override
	public String toString() {
		String message= "/nPlayer [Character name: %s, Amount of Gold: %d]";
		return String.format(super.toString() + message, team.getName(), this.getGold());
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	
}