import java.util.ArrayList;

public class ConsolePlayerMenu extends ConsoleMenu {
	//Attributes
	private Player player=null;
	private CRUD<PlayableCharacter> chars=null;
	
	//Constructor
	public ConsolePlayerMenu() throws Exception {
		this.chars= new CRUD<PlayableCharacter>();
		//DataManager.initDataManager();
		//this.chars=readCharacterFile();
	}
	
	//Methods
	public Player playerMenu(Player player) throws Exception {
		setPlayer(player);
		if(getPlayer().getCharacter()==null) {
			withoutCharacterMenu();
			withCharacterMenu();
		}else {
			withCharacterMenu();
		}
		return getPlayer();
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
		System.out.println("Ingress Character's name: ");
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
					updatePlayersCharacter(cl);
					break;
			case 2: System.out.println("Creating a Mage");
					Mage ma=new Mage(name);
					setOp((byte)0);
					updatePlayersCharacter(ma);
					break;
			case 3: System.out.println("Creating a Hunter");
					Hunter hu=new Hunter(name);
					setOp((byte)0);
					updatePlayersCharacter(hu);
					break;
			case 4: System.out.println("Creating a Hunter");
					Warrior wa=new Warrior(name);
					setOp((byte)0);
					updatePlayersCharacter(wa);
					break;
			case 0: break;
				}
			}while(getOp()!=0);
		//writeCharacterFile();
	}
	
	public void withCharacterMenu() throws Exception {
		PlayableCharacter pc= getPlayer().getCharacter();
		ArrayList<String> s= new ArrayList<>();
		s.add("View Character");
		s.add("Modify Character");
		s.add("Fight some Monsters");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Accessing View Character"); 
					System.out.println(pc);
					break;
			case 2: System.out.println("Accessing Modify Character\nThe only thing that can be changed is the name");
					String name;
					System.out.println("Ingress Character's name: ");
					name=validatingStrings();
					pc.setName(name);
					updatePlayersCharacter(pc);
					break;
			case 3:/* ConsoleCombatMenu ccm=new ConsoleCombatMenu();
					pc=cmm.combatMenu(pc);*/
					updatePlayersCharacter(pc);
					break;
			case 0: //System.exit(0);	
					break;
			}
		}while(getOp()!=0);
	}

	
	
	private CRUD<PlayableCharacter> readCharacterFile() throws Exception{
		CRUD<PlayableCharacter> c= new CRUD<PlayableCharacter>();
		DataManager.readAllFiles();
		try {
			c.updateAll(castList(PlayableCharacter.class,DataManager.getData(DataManager.Colection.PLAYABLECHARACTER)));
		}catch (Exception e) {
		
		}
		return c;
	}
	
	private void writeCharacterFile() throws Exception {
		DataManager.updateData(DataManager.Colection.USER, getChars().getList());
		DataManager.writeAllFiles();
	}
	
	private void updatePlayersCharacter(PlayableCharacter pc) throws Exception {
		this.player.updateCharacter(pc);
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

	public CRUD<PlayableCharacter> getChars() {
		return chars;
	}	
	
}
