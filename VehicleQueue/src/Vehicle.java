import java.util.Scanner;
import java.util.Queue;

public class Vehicle extends Program {
	private String model;
	private String licensePlate;
	private String color;
	private String fuelType;
	private int horsePower;
	private static int vehicleCount = 0;
	
	public String getModel() {
		return this.model;
	}
	
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getHorsePower() {
		return this.horsePower;
	}
	
	public String getFuelType() {
		return this.fuelType;
	}
	
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public static void register(Queue<Vehicle> vehicle) {
		Vehicle newVehicle = new Vehicle();
		
		System.out.println("-----Vehicle Register-------");
		newVehicle.setModel(Vehicle.registerModel());
		newVehicle.setColor(Vehicle.registerColor());
		newVehicle.setLicensePlate(Vehicle.registerLicensePlate());
		newVehicle.setHorsePower(registerHorsePower());
		newVehicle.setFuelType(Vehicle.registerFuelType());
		
		if(Validation.confirmation()) {
			Messages.msgVehicleRegistred();
			vehicle.add(newVehicle);
			vehicleCount++;
		}else {
			Messages.msgRegisterCancelled();
		}
		Messages.pressEnter();
	}
	
	public static String registerModel() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("| Insert the Vehicle model: |");
		String model = scanner.nextLine();
		if(!Validation.verifyEmpty(model)) {
			registerModel();
		}
		return model;
	}
	
	public static String registerLicensePlate() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("| Insert the License plate:");
		String licensePlate = scanner.nextLine();
		if(!Validation.verifyEmpty(licensePlate)) {
			registerLicensePlate();
		}
		return licensePlate;
	}
	
	public static String registerFuelType() {
		Scanner scanner = new Scanner(System.in);
		String fuelType = "";
		
		System.out.println("-----------------------------------");
		System.out.println("| Which is the vehicle fuel type? |");
		System.out.println("| 1) Alcohol                      |");
		System.out.println("| 2) Gasoline                     |");
		System.out.println("| 3) Eletric                      |");
		System.out.println("| 4) Flex                         |");
		System.out.println("-----------------------------------");
		
		if(scanner.hasNextInt()) {
			fuelType = Validation.verifyOptionFuelType(scanner.nextInt());
		}else {
			Messages.msgErrorMenu();
			Messages.pressEnter();
			registerFuelType();
		}
		return fuelType;
	}
	
	public static int registerHorsePower() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("| Insert Horse Power:");
		if(scanner.hasNextInt()) {
			int hp = scanner.nextInt();
			if(hp>0) {
				return hp;
			}
		}
		Messages.msgErrorMenu();
		Messages.pressEnter();
		registerHorsePower();
		return 0;
	}
	
	public static String registerColor() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("| Insert color:");
		String color = scanner.nextLine();
		
		if(!Validation.verifyEmpty(color)){
			registerColor();
		}
		return color;
	}
	
	public static void listVehicle(Queue<Vehicle> vehicles) {
		for(Vehicle vehicle : vehicles) {
			System.out.println("----------------------------");
			System.out.println("| Model: "+vehicle.getModel());
			System.out.println("| Color: "+vehicle.getColor());
			System.out.println("| License Plate: "+vehicle.getLicensePlate());
			System.out.println("| Horse Power: "+vehicle.getHorsePower());
			System.out.println("| Fuel Type: "+vehicle.getFuelType());
			System.out.println("----------------------------");
		}
		System.out.println("Total vehicles registred: "+vehicleCount+".");
		Messages.pressEnter();
	}
	
	public static void firstAdded(Queue<Vehicle> vehicle) {
		vehicle.remove();
		Messages.msgFirstDeleted();
		Messages.pressEnter();
		vehicleCount--;
	}
}

