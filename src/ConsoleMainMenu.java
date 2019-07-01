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
	}
	
	public void menu() throws Exception {
		ArrayList<String> s= new ArrayList<>();
		s.add("Create an Account");
		s.add("Login");
		int quant= generateOptions(s);
		insertOption(quant);
		switch(getOp()) {
		case 1: System.out.println("Accessing Create an Account"); break;
		case 2: System.out.println("Accessing Login"); break;
		case 0: System.exit(0);
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
	
	public void validateInsertOption() {
		
	}

	private byte getOp() {
		return op;
	}

	private void setOp(byte op) {
		this.op = op;
	}
	
	
}
