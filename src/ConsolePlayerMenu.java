public class ConsolePlayerMenu extends ConsoleMenu {
	//Attributes
	private Player player=null;
	
	//Constructor
	public ConsolePlayerMenu() {
		
	}
	
	//Methods
	public void playerMenu(Player player) throws Exception {
		setPlayer(player);
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) throws Exception {
		if(player!=null) {
			this.player=player;
		}else {
			throw new Exception("Empty Player, can't continue");
		}
	}
	
	//Getters Setters
	
	
	
}
