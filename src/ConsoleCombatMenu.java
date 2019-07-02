import java.util.ArrayList;
import java.util.Random;

public class ConsoleCombatMenu extends ConsoleMenu {
	//Attributes
	PlayableCharacter pc=null;
	CRUD<NonPlayableCharacter> monstersAviable = null;
	
	//Constructor
	public ConsoleCombatMenu(PlayableCharacter plch) {
		setPc(plch);
		this.monstersAviable = new CRUD<NonPlayableCharacter>();
	}
	
	//Methods
	public PlayableCharacter combatMenu() throws Exception {
		ArrayList<String> s= new ArrayList<>();
		s.add("Fight a monster");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Starting Fight"); startFight(); break;
			case 0: 
				DataManager.writeAllFiles();
				System.exit(0);	
				break;
			}
		}while(getOp()!=0);
		setOp((byte)-1);
		return pc;		
	}
	
	public PlayableCharacter startFight() throws Exception {
		
		monstersAviable.updateAll(Main.castList(NonPlayableCharacter.class, DataManager.getData(DataManager.Colection.NONPLAYABLECHARACTER)));

		NonPlayableCharacter npc = null;
		
		if(! monstersAviable.getList().isEmpty()) {
			int monstersAmount = monstersAviable.getList().size();
			Random rand = new Random();
			int n = rand.nextInt(monstersAmount);
			try {
				npc = monstersAviable.find(n);
			}
			catch (Exception e) {
				npc = new NonPlayableCharacter(getPc().getLevel(), "Elvis from an Exeption");
			}
		}
		else {
			npc = new NonPlayableCharacter(getPc().getLevel(), "Elvis from an Empty List");
		}
			
		while(npc.getCurrentHP()>0 || pc.getCurrentHP()>0) {
			System.out.println("Your turn to attack, your HP: " + pc.getCurrentHP());
			npc.takeDamage(pc.calculateAttack());
			if(npc.getCurrentHP()>0) {
				System.out.println(npc.getName()+ "'s turn to attack, his HP: "+npc.getCurrentHP());
				pc.takeDamage(pc.calculateAttack());
			}
		}
		if(npc.getCurrentHP()<=0) {
			System.out.println("You won. You've gained: " + npc.getExpRewarded() + " Exp");
			pc.gainExperience(npc.getExpRewarded());
		}else {
			System.out.println("You lose.");
		}
		
		return getPc();
	}

	
	
	
	//Getters Setter
	
	public PlayableCharacter getPc() {
		return pc;
	}

	public void setPc(PlayableCharacter pc) {
		this.pc = pc;
	}
}
