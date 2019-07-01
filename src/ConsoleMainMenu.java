import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMainMenu implements ISystemMessage{
	//attributes
	private byte op;
	private Scanner sc;
	
	//Constructor
	public ConsoleMainMenu() {
		sc= new Scanner(System.in);
		//Load Players and Admins from files
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
			case 2: System.out.println("Accessing Login"); break;
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
		username=sc.nextLine();
		//Validation for the Username, for the correct length and check if it's already in the system
		System.out.println("Ingress password: ");
		password=sc.nextLine();
		//Validation for the Password
		System.out.println("Ingress Name: ");
		name=sc.nextLine();
		//Validation for the Name
		System.out.println("Ingress email: ");
		email=sc.nextLine();
		//Validation for the Email
		
		Player player=new Player(name,username,password,email);
		//Add Player to the Player file
	}
	
	public void login() {
		String username, password;
		System.out.println("Ingress username: ");
		username=sc.nextLine();
		//Validation for the Username, for the correct length and check if it's already in the system, in case it is, proceed, else informs and returns to the previous menu
		System.out.println("Ingress password: ");
		password=sc.nextLine();
		//Validation for the Password, and check if it matches with the one acording to that user
		
		//If everything is correct, depending if it's a Player or an Admin, takes it to another menu
	}
	

	//Getter Setter
	private byte getOp() {
		return op;
	}

	private void setOp(byte op) {
		this.op = op;
	}
	
	
}
