import java.util.Scanner;

public abstract class Messages extends Program {
	
	public static void pressEnter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Press Enter to continue... --");
		scanner.nextLine();
		clearConsole();
	}
	
	public static void clearConsole() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();

	}

	
	public static void msgErrorMenu() {
		System.out.println("-- Error #101, Invalid insert --");
	}
	
	public static void msgExit() {
		System.out.println("-- See you next time... --");
	}
	
	public static void msgEmptyInsert() {
		System.out.println("-- Error #404, Empty insert --");
	}
	
	public static void msgWrongOption() {
		System.out.println("-- Wrong option, try again! --");
	}
	
	public static void msgVehicleRegistred() {
		System.out.println("-- Successuful, vehicle registred! --");
	}
	
	public static void msgRegisterCancelled() {
		System.out.println("-- Registration has been cancelled! --");
	}
	
	public static void msgFirstDeleted() {
		System.out.println("-- First registry has been deleted! --");
	}
}
