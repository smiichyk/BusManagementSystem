import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BusStation busStation = getDundalkBusStation();
    private static final int busNumberLength = 6;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("""
                1. Bus Station Management
                2. Bus Management
                0. Exit Program""");
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();
        while (!choice.equals("1") &&  !choice.equals("2") && !choice.equals("0")) {
            System.out.println("\nInvalid choice. Please enter a number from 0 to 2.\n");
            System.out.println("""
                1. Bus Station Management
                2. Bus Management
                0. Exit Program""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {
            busStationManagementMenu();
        } else if (choice.equals("2")) {
            busManagementMenu();
        }
    }

    public static void busStationManagementMenu() {
        System.out.println();
        System.out.println("""
                1. View bus station information
                2. Add a new bus
                3. Remove a bus
                4. Search for a bus
                5. View all buses
                0. Main Menu""");
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") &&
                !choice.equals("5") && !choice.equals("0")) {
            System.out.println("\nInvalid choice. Please enter a number from 0 to 5.\n");
            System.out.println("""
                1. View bus station information
                2. Add a new bus
                3. Remove a bus
                4. Search for a bus
                5. View all buses
                0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {
            System.out.println(busStation.toString());
        } else if (choice.equals("2")) {
            addBusMenu();
        } else if (choice.equals("3")) {
            removeBusMenu();
        }  else if (choice.equals("4")) {
            searchBusMenu();
        }  else if (choice.equals("5")) {
            System.out.println(busStation.getAllBuses());
        } else {
            mainMenu();
        }
        busStationManagementMenu();
    }

    public static void busManagementMenu() {
        System.out.println();
        System.out.println("""
                1. View bus route
                2. Add a stop
                3. Remove a stop
                4. Update stop information
                5. Check if a stop is on the route
                6. View route duration
                7. Change bus capacity
                0. Main Menu""");
    }

    public static void addBusMenu() {
        String busNumberString;
        int busNumber;
        String busName;
        String routeName;
        String departureTime;
        String arrivalTime;
        String seatCapacityString;
        int seatCapacity;
        System.out.print("\nEnter bus number: ");
        busNumberString = scanner.nextLine();
        while (!isValidFormat(busNumberString, busNumberLength)) {
            System.out.println("\nInvalid bus number! Must be " + busNumberLength + " digits.\n\nEnter bus number: ");
            busNumberString = scanner.nextLine();
        }
        busNumber = Integer.parseInt(busNumberString);
        System.out.print("Enter bus name: ");
        busName = scanner.nextLine();
        System.out.print("Enter route name: ");
        routeName = scanner.nextLine();
        System.out.print("Enter departure time: ");
        departureTime = scanner.nextLine();
        System.out.print("Enter arrival time: ");
        arrivalTime = scanner.nextLine();
        System.out.print("Enter seat capacity: ");
        seatCapacityString = scanner.nextLine();
        while (!isValidFormat(seatCapacityString)) {
            System.out.println("\nInvalid seat capacity! Must be digits.\n\nEnter seat capacity: ");
            seatCapacityString = scanner.nextLine();
        }
        seatCapacity = Integer.parseInt(seatCapacityString);
        Bus bus = new Bus(busNumber, busName, routeName, departureTime, arrivalTime, seatCapacity);
        busStation.addBus(bus);
        System.out.println("Bus "+busNumber+" added to the "+busStation.getStationName());
    }

    public static void removeBusMenu() {

    }
    public static void searchBusMenu() {
        System.out.println();
        System.out.println("""
                1. Search for a bus by number
                2. Search for a bus by name""");
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("\nInvalid choice. Please enter a number from 0 to 2.\n");
            System.out.println("""
                1. Search for a bus by number
                2. Search for a bus by name""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {

        } else {

        }
    }

    public static BusStation getDundalkBusStation() {
        BusStation dundalkBusStation = new BusStation("Dundalk Bus Station", "Dundalk");
        dundalkBusStation.addBus(getRoute100());
        dundalkBusStation.addBus(getRoute100X());
        return dundalkBusStation;
    }

    public static Bus getRoute100() {
        ArrayList<String> stops = new ArrayList<>(Arrays.asList(
                "Dundalk (Bus Station- Long Walk)", "Dundalk (Dublin Rd McDonalds)",
                "Dundalk (Opp County Louth Hospital)", "Dundalk I.T (Main Gate)", "Haggardstown (Sextons)",
                "Greengates Cross (Southbound)", "Castlebellingham (The Village Store)",
                "Kilsaran (Opp St Olivers Park)", "Kilsaran (Opp St Marys Villas)",
                "Mullins Cross (Southbound)", "Dunleer (The Dunleer Inn)", "Dunleer (Wogans Hardware)",
                "Mullary (Southbound)", "Tinure (Southbound)", "Monasterboice (Monasterboice Inn)",
                "Killeneer (Cockle Rd Cross Sbound)", "Killeneer (Killeneer Cottages)",
                "Drogheda Hospital (NorthGate East)", "Drogheda (Bus Station)"
        ));
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "06:15", "06:17", "06:19", "06:20", "06:23", "06:24", "06:30", "06:31", "06:32", "06:35",
                "06:39", "06:40", "06:43", "06:45", "06:49", "06:49", "06:50", "06:56", "07:06"
        ));
        return new Bus(314682, "100", "Dundalk - Drogheda", "06:15",
                "07:06", 55, stops, times);
    }

    public static Bus getRoute100X() {
        ArrayList<String> stops = new ArrayList<>(Arrays.asList(
                "Dundalk (Bus Station- Long Walk)", "Dundalk (Dublin Rd McDonalds)",
                "Dundalk (Opp County Louth Hospital)", "Dundalk I.T (Main Gate)",
                "Castlebellingham (The Village Store)", "Dunleer (The Dunleer Inn)",
                "Drogheda (North Road - Opp Circle K)", "Drogheda (Donore Rd FBD)", "Drogheda (Bus Station)",
                "Drogheda (Donore Rd The Thatch Pub)", "Dublin Airport (Terminal Two)", "Dublin Airport - Maldron Hotel",
                "Dublin (East Wall Rd Opp 3Arena)", "Dublin (Opp Convention Centre)",
                "Custom House Qy (Op Hilton Garden Inn)", "South Townsend St",
                "Westland Row Church", "Merrion Square West (Jct Clare St)", "Merrion Square South"
        ));

        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "06:30", "06:33", "06:35", "06:37", "", "", "", "07:02", "07:10", "07:14",
                "07:46", "07:48", "08:02", "08:04", "08:06", "08:09", "08:12", "08:16", "08:20"
        ));
        return new Bus(314654, "100X", "Dundalk - Dublin", "06:30",
                "08:20", 55, stops, times);
    }

    public static boolean isValidFormat(String str) {
        for (char character : str.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidFormat(String str, int length) {
        if (str.length()!=length) {
            return false;
        }
        for (char character : str.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }
}
