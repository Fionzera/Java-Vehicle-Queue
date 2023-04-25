import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Program {
	public static Scanner scanner = new Scanner(System.in);
	static Queue<Vehicle> vehicle = new LinkedList<Vehicle>();
	
	public static void main(String[] args) {
		boolean ext = true;
		do {
			System.out.println("-----Vehicle Queue Menu-----");
			System.out.println("|  What you wanna do?      |");
			System.out.println("|  1 - Register a vehicle  |");
			System.out.println("|  2 - List                |");
			System.out.println("|  3 - Delete first added  |");
			System.out.println("|  4 - Exit                |");
			System.out.println("----------------------------");
			if(scanner.hasNextInt()) {
				int opt = scanner.nextInt();
				Validation.verifyOption(opt,vehicle);
			}else {
				Messages.msgErrorMenu();
				Messages.pressEnter();
				scanner.nextLine();
			}
		}while(ext);
	}
	
}
