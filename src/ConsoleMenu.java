
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleMenu implements ISystemMessage {
	//Attributes
	private byte op;
	protected Scanner sc;
	
	//Constructor
	public ConsoleMenu() {
		sc= new Scanner(System.in);
	}
	
	//Methods
	@SuppressWarnings("unchecked")
	protected static <T extends Base> List<T> castList(Class<T> specificClass, List<? extends Base> units) {
        return (List<T>) units;
    }
	
	protected int generateOptions(ArrayList<String> options) {
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
	
	protected String validatingStrings() {
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
	
	//Getters Setters
	protected byte getOp() {
		return op;
	}

	protected void setOp(byte op) {
		this.op = op;
	}
}
