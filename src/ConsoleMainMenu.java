import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMainMenu implements ISystemMessage{
	//attributes
	private byte op;
	private Scanner sc;
	private CRUD<Player> users=null;
	
	//Constructor
	public ConsoleMainMenu() throws Exception {
		sc= new Scanner(System.in);
		users= new CRUD<Player>();
		DataManager.initDataManager();
		users.clear();
		users.updateAll(castList(Player.class,DataManager.getData(DataManager.Colection.PLAYER)));
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Base> List<T> castList(Class<T> specificClass, List<? extends Base> units) {
        return (List<T>) units;
   }
	
	//Methods
	public void menu() throws Exception {
		op=-1;
		ArrayList<String> s= new ArrayList<>();
		s.add("Create an Account");
		s.add("Login");
		while(getOp()!=0) {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Accessing Create an Account"); createAccount(); break;
			case 2: System.out.println("Accessing Login"); login(); break;
			case 0: System.exit(0);	
			}
		}	
	}
	
	public int generateOptions(ArrayList<String> options) {
		int cont=0;
		for(String o:options) {
			cont++;
			System.out.println(cont + "- " + o);
		}
		System.out.println("0- Exit");
		return cont;
	}
	
	public void insertOption(int quant) throws Exception {
		if(quant==0) {
			throw new Exception("There's no options to show");
		}else {
			do {
				System.out.print("Ingress option: ");
				try {
					setOp(sc.nextByte());
					if(getOp()<0 || getOp()>quant) {
						System.out.println(valueErrorMessage + "Invalid option");
					}
				}catch (InputMismatchException e) {
					System.out.println(valueErrorMessage + "Insert a number");
					setOp((byte) -1);
					sc.nextLine();
				}
			}while(getOp()<0 || getOp()>quant);
		}
	}
	
	public void createAccount() throws Exception {
		String name, username, password, email;
		System.out.println("Ingress username: ");
		username=validatingStrings();
		if(!validateUsernameFromFile(username)) {
			System.out.println("Ingress password: ");
			password=validatingStrings();
			System.out.println("Ingress Name: ");
			name=validatingStrings();
			System.out.println("Ingress email: ");
			email=validatingStrings();
			Player player=new Player(name,username,password,email);
			addUsers(player);
		}else {
			System.out.println("Username already in use");
		}
	}
	
	public void login() {
		String username, password;
		System.out.println("Ingress username: ");
		username=validatingStrings();
		if(validateUsernameFromFile(username)) {
			System.out.println("Ingress password: ");
			password=validatingStrings();
			if(validateUsernamePasswordFromFile(username,password)) {
				//Check if it's Player or Admin and sends to different menus
			}else {
				System.out.println("Incorrect Username or Password");
			}
		}else {
			System.out.println("Incorrect Username");
		}
	}
	
	private String validatingStrings() {
		String word="";
		do {	
			try {
				word=sc.nextLine();
			}catch (InputMismatchException e){
				System.out.println(valueErrorMessage + "Please ingress again");
			}
		}while(word.length()<=0);
		return word;
	}
	
	private boolean validateUsernameFromFile(String username) {
		boolean flag=false;
		for(Player u:getUsers().getList()) {
			if(u.getUsername()==username) {
				flag=true;
			}
		}
		return flag;
	}
	
	private boolean validateUsernamePasswordFromFile(String username, String password) {
		boolean flag=false;
		for(Player u:getUsers().getList()) {
			if(u.getUsername()==username) {
				if(u.getPassword()==password) {
					flag=true;
				}
			}
		}
		return flag;
	}

	//Getter Setter
	protected byte getOp() {
		return op;
	}

	protected void setOp(byte op) {
		this.op = op;
	}
	
	protected CRUD<Player> getUsers(){
		return this.users;
	}
	
	protected void addUsers(Player p) throws Exception {
		this.users.create(p);
	}
	
}
