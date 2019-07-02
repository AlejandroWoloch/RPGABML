import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMainMenu implements ISystemMessage{
	//attributes
	private byte op;
	private Scanner sc;
	private CRUD<User> users=null;
	
	//Constructor
	public ConsoleMainMenu() throws Exception {
		sc= new Scanner(System.in);
		users= new CRUD<User>();
		DataManager.initDataManager();
		users=readUserFile();
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
			writeUserFile();
		}else {
			System.out.println("Username already in use");
		}
	}
	
	public void login() {
		String username, password;
		User finalUser;
		System.out.println("Ingress username: ");
		username=validatingStrings();
		if(validateUsernameFromFile(username)) {
			System.out.println("Ingress password: ");
			password=validatingStrings();
			finalUser=validateUsernamePasswordFromFile(username,password);
			if(finalUser!=null) {
				System.out.println("You've logged in");
				if(finalUser instanceof Player) {
					//playerMenu(finalUser);
				}else {
					//adminMenu(finalUser);
				}
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
		for(User u:getUsers().getList()) {
			if(u.getUsername().equals(username)) {
				flag=true;
			}
		}
		return flag;
	}
	
	private User validateUsernamePasswordFromFile(String username, String password) {
		User user=null;
		for(User u:getUsers().getList()) {
			if(u.getUsername().equals(username)) {
				if(u.getPassword().equals(password)) {
					user=u;
				}
			}
		}
		return user;
	}
	
	private CRUD<User> readUserFile() throws Exception{
		CRUD<User> u= new CRUD<User>();
		try {
			u.updateAll(castList(User.class,DataManager.getData(DataManager.Colection.USER)));
		}catch (Exception e) {
		
		}
		return u;
	}
	
	private void writeUserFile() throws Exception {
		DataManager.updateData(DataManager.Colection.USER, getUsers().getList());
		DataManager.writeAllFiles();
	}

	//Getter Setter
	protected byte getOp() {
		return op;
	}

	protected void setOp(byte op) {
		this.op = op;
	}
	
	protected CRUD<User> getUsers(){
		return this.users;
	}
	
	protected void addUsers(Player p) throws Exception {
		this.users.create(p);
	}
	
}
