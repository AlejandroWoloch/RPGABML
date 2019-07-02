import java.util.ArrayList;

public class ConsoleMainMenu extends ConsoleMenu{
	//Attributes
	private CRUD<User> users=null;
	
	//Constructor
	public ConsoleMainMenu() throws Exception {
		users= new CRUD<User>();
		users=readUserFile();
	}
	
	//Methods
	public void menu() throws Exception {
		ArrayList<String> s= new ArrayList<>();
		s.add("Create an Account");
		s.add("Login");
		do {
			int quant= generateOptions(s);
			insertOption(quant);
			sc.nextLine(); //This is used to get to read the next line and not the number of the option input
			switch(getOp()) {
			case 1: System.out.println("Accessing Create an Account"); createAccount(); break;
			case 2: System.out.println("Accessing Login"); login(); break;
			case 0: System.exit(0);	
			}
		}while(getOp()!=0);
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
			//writeUserFile();
		}else {
			System.out.println("Username already in use");
		}
	}
	
	public void login() throws Exception {
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
					ConsolePlayerMenu cpm=new ConsolePlayerMenu();
					try {
						finalUser=cpm.playerMenu((Player) finalUser);
					} catch (Exception e) {
						System.out.println("There was an unexpected error: " + e.getMessage());
					}
				}else {
					//adminMenu(finalUser);
				}
				users.update(finalUser);
				//writeUserFile();
			}else {
				System.out.println("Incorrect Username or Password");
			}
		}else {
			System.out.println("Incorrect Username");
		}
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
	}

	//Getter Setter
	
	protected CRUD<User> getUsers(){
		return this.users;
	}
	
	protected void addUsers(Player p) throws Exception {
		this.users.create(p);
	}
	
}
