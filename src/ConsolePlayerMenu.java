import java.util.ArrayList;

public class ConsolePlayerMenu extends ConsoleMenu {
	//Attributes
	private Player player=null;
	
	//Constructor
	public ConsolePlayerMenu() {
		
	}
	
	//Methods
	public void playerMenu(Player player) throws Exception {
		setPlayer(player);
		if(getPlayer().getCharacter()==null) {
			withoutCharacterMenu();
		}else {
			withCharacterMenu();
		}
	}
	
	public void withoutCharacterMenu() throws Exception {
		ArrayList<String> s= new ArrayList<>();
		s.add("Create a Character");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Accessing Create a Character"); createCharacter(); break;
			case 0: System.exit(0);	
			}
		}while(getOp()!=0);
	}
	
	@SuppressWarnings("null")
	public void createCharacter() throws Exception {
		String name;
		int manaStamina,intelligence;
		System.out.println("Ingress name: ");
		name=validatingStrings();
		System.out.println("Choose your characters class");
		ArrayList<String> s= new ArrayList<>();
		s.add("(Magical Class) Cleric");
		s.add("(Magical Class) Mage");
		s.add("(Physical Class) Hunter");
		s.add("(Physical Class) Physical");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Creating a Cleric");
					Cleric cl=new Cleric(name);
					setOp((byte)0);
					break;
			case 2: System.out.println("Creating a Mage");
					Mage ma=new Mage(name);
					setOp((byte)0);
					break;
			case 3: System.out.println("Creating a Hunter");
					Hunter hu=new Hunter(name);
					setOp((byte)0);
					break;
			case 4: System.out.println("Creating a Hunter");
					Warrior wa=new Warrior(name);
					setOp((byte)0);
					break;
			case 0: break;
				}
			}while(getOp()!=0);
	}
	
	public void withCharacterMenu() {
		
	}
	
	
	
	//Getters Setters

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
	
}
