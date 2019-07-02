import java.util.Objects;

public class Player extends User { 
	/*
	 * A Player will be an User that will play the game and manage its team and items.
	 */
	
	//Attributes
	private static final long serialVersionUID = 1L;
	private PlayableCharacter character; //Character that the Player will use.
	//private ABML<PlayableCharacter team; //If there's time, there'll be a Collections of characters that the Player could use.
	private int gold; //Amount of gold the Player will have
	
	//Constructors
	public Player(String name, String username, String password, String email) throws Exception {
		super(name, username, password, email);
		this.setGold(0);
		this.character= null;
	}

	public Player(String name, String username, String email) throws Exception {
		super(0,name, username, email);
		this.setGold(0);
		this.character= null;
	}

	public Player(String name, String username, String password, String email, int gold) throws Exception {
		super(name, username, password, email);
		this.setGold(gold);
		this.character= null;
	}

	public Player(String name, String username, String email, int gold) throws Exception {
		super(0,name, username, email);
		this.setGold(gold);
		this.character= null;
	}

	
	//Getters and Setters

	public PlayableCharacter getCharacter() {
		return character;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) throws Exception {
		if(gold>=0) {
			this.gold=gold;
		}else {
			String setGoldError= " You can't have negative gold";
			throw new Exception(valueErrorMessage + setGoldError);
		}
	}
	



	//To String, Equals, HashCode.
	
	@Override
	public String toString() {
		String message= "\nPlayer [Character name: %s, Amount of Gold: %d]";
		String showCharacter= "none";
		if(this.getCharacter() != null) {
			showCharacter = this.getCharacter().getName();
		}
		return String.format(super.toString() + message, showCharacter, this.getGold());
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	//Methods
	
	public void updateCharacter(PlayableCharacter newCharacter) throws Exception{
		if(newCharacter != null) {
			this.character = newCharacter;
		}
		else {
			throw new Exception("Can't create a null character");
		}
	}
	

}
