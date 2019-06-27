
public class Player extends User { 
	/*
	 * A Player will be an User that will play the game and manage its team and items.
	 */
	
	//Attributes
	//private ABML<item> inventory; //Collections of the items that the player has.
	private PlayableCharacter team; //Character that the Player will use.
	//private ABML<PlayableCharacter team; //If there's time, there'll be a Collections of characters that the Player could use.
	private int gold; //Amount of gold the Player will have
	
	//Constructor
	public Player() {}

	
	//Getters and Setters
	/*public ABML<item> getInventory() {
		return inventory;
	}*/

	/*public void setInventory(ABML<item> inventory) {
		this.inventory = inventory;
	}*/

	public PlayableCharacter getTeam() {
		return team;
	}

	public void setTeam(PlayableCharacter team) {
		this.team = team;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	//Methods
	public void administrateCharacters() {}
	
	public void startGame() {}
	
	public void createCharacter() {}
	
	public void administrateInventory() {}


	@Override
	public String toString() {
		return "Player";
	}
	
	
}
