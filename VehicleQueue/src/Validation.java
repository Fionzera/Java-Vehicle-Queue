import java.util.Queue;
import java.util.Scanner;

public abstract class Validation extends Program {
	public static boolean verifyEmpty(String string) {
		if(string.trim().equals("")) {
			Messages.msgEmptyInsert();
			Messages.pressEnter();
			return false;
		}
		return true;
	}
	
	public static void verifyOption(int opt, Queue<Vehicle> vehicle) {
		switch(opt) {
		case 1:
			Vehicle.register(vehicle);
			break;
		case 2:
			Vehicle.listVehicle(vehicle);
			break;
		case 3:
			Vehicle.firstAdded(vehicle);
			break;
		case 4:
			Messages.msgExit();
			System.exit(0);
		default:
			Messages.msgErrorMenu();
			Messages.pressEnter();
		}
	}
	
	public static String verifyOptionFuelType(int opt) {
		switch (opt){
			case 1:
				return "Alcohol";
			case 2:
				return "Gasoline";
			case 3:
				return "Eletric";
			case 4:
				return "Flex";
			default:
				Messages.msgWrongOption();
				Messages.pressEnter();
				Vehicle.registerFuelType();
				return "";
		}
	}
	
	public static boolean confirmation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-- Confirm or cancel? --");
		System.out.println("| 1) Yes               |");
		System.out.println("| 2) No                |");
		System.out.println("------------------------");
		if(scanner.hasNextInt()) {
			int opt = scanner.nextInt();
			switch(opt) {
			case 1:
				return true;
			case 2:
				return false;
			default:
				Messages.msgWrongOption();
				Messages.pressEnter();
			}
		}else {
			Messages.msgErrorMenu();
			Messages.pressEnter();
		}
		confirmation();
		return false;
	}
}
