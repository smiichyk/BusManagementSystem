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
        boolean exit = false;

        // Loop runs until the user chooses to exit
        while (!exit) {

            // Display the main menu options
            System.out.println("""
                    
                    **************************************************************************
                    
                    1. Bus Station Management
                    2. Bus Management
                    0. Exit Program""");

            // Read user input
            System.out.print("\nYour choice: ");
            String choice = scanner.nextLine();

            // Validate user input to ensure it is one of the allowed choices (0, 1, or 2)
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("0")) {
                System.out.println("""
                    
                    **************************************************************************
                    Invalid choice. Please enter a number from 0 to 2.
                    
                    1. Bus Station Management
                    2. Bus Management
                    0. Exit Program""");
                System.out.print("\nYour choice: ");
                choice = scanner.nextLine();
            }

            // Process user choice
            if (choice.equals("1")) {
                busStationManagementMenu();
            } else if (choice.equals("2")) {
                busManagementMenu();
            } else {
                System.out.println("""

                        Exiting program...
                        
                        **************************************************************************""");
                exit = true;
            }
        }
    }

    public static void busStationManagementMenu() {

        // Display the bus station management menu options
        System.out.println("""
                
                **************************************************************************
                
                1. View bus station information
                2. Add a new bus
                3. Remove a bus
                4. Search for a bus
                5. View all buses
                0. Main Menu""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices (0, 1, 2, 3, 4 or 5)
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") &&
                !choice.equals("5") && !choice.equals("0")) {
            System.out.println("""
                
                **************************************************************************
                
                Invalid choice. Please enter a number from 0 to 5.
                
                1. View bus station information
                2. Add a new bus
                3. Remove a bus
                4. Search for a bus
                5. View all buses
                0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            System.out.println("\nBUS STATION INFORMATION: ");
            System.out.println(busStation.toString());
        } else if (choice.equals("2")) {
            addBusMenu();
        } else if (choice.equals("3")) {
            removeBusMenu();
        }  else if (choice.equals("4")) {
            searchBusMenu();
        }  else if (choice.equals("5")) {
            busStation.displayAllBuses();
        }

        // If the user did not choose "0", call the bus station management menu again
        if (!choice.equals("0")) {
            busStationManagementMenu();
        }
    }

    public static void busManagementMenu() {

        // Display the bus management menu options
        System.out.println("""
                
                **************************************************************************
                
                1. View bus route
                2. Add a stop
                3. Remove a stop
                4. Update stop information
                5. Check if a stop is on the route
                6. View route duration
                7. Change bus capacity
                0. Main Menu""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices (0, 1, 2, 3, 4, 5, 6 or 7)
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") &&
                !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("0")) {
            System.out.println("""
                
                **************************************************************************
                
                Invalid choice. Please enter a number from 0 to 7.
                
                1. View bus route
                2. Add a stop
                3. Remove a stop
                4. Update stop information
                5. Check if a stop is on the route
                6. View route duration
                7. Change bus capacity
                0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {

        } else if (choice.equals("2")) {

        } else if (choice.equals("3")) {

        }  else if (choice.equals("4")) {

        }  else if (choice.equals("5")) {

        } else if (choice.equals("6")) {

        } else if (choice.equals("7")) {

        }
    }

    public static void addBusMenu() {

        // Display a separator
        System.out.print("\n**************************************************************************\n\n");

        // Prompt user to enter the bus number
        String busNumberString = validateBusNumber();

        // Prompt the user for the bus number and validate its format
        int busNumber = Integer.parseInt(busNumberString);

        // Prompt user to enter the bus name
        System.out.print("Enter bus name: ");
        String busName = scanner.nextLine();

        // Prompt user to enter the route name
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine();

        // Prompt the user for the departure and arrival times and validate their format
        String departureTime = validateTime("departure time");
        String arrivalTime = validateTime("arrival time");

        // Prompt the user for the seat capacity and validate its format
        int seatCapacity = validateSeatCapacity();

        // Create a new Bus object with the provided details and add the bus to the bus station
        Bus bus = new Bus(busNumber, busName, routeName, departureTime, arrivalTime, seatCapacity);
        busStation.addBus(bus);

        // Confirm that the bus has been added
        System.out.println("Bus "+busNumber+" added to the "+busStation.getStationName());
    }

    public static void removeBusMenu() {

    }

    public static void searchBusMenu() {
        System.out.println("""
                
                1. Search for a bus by number
                2. Search for a bus by name""");
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("""
                
                Invalid choice. Please enter a number from 0 to 2.
                
                1. Search for a bus by number
                2. Search for a bus by name""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {

        } else {

        }
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

    public static String validateBusNumber() {
        while (true) {
            System.out.print("Enter bus number: ");
            String busNumberString = scanner.nextLine();

            if (isValidFormat(busNumberString, busNumberLength)) {
                return busNumberString;
            }

            System.out.printf("""

                --------------------------------------------------------------
                Invalid bus number! Must be %d digits.
                --------------------------------------------------------------

                """, busNumberLength);
        }
    }

    public static String validateTime(String str) {
        while (true) {
            System.out.printf("Enter %s time (hh:mm): ", str);
            String time = scanner.nextLine();

            boolean validFormat = true;

            if (time.length() != 5 || time.charAt(2) != ':') {
                validFormat = false;
            } else {
                for (int i = 0; i < time.length(); i++) {
                    if (i != 2 && !Character.isDigit(time.charAt(i))) {
                        validFormat = false;
                    }
                }
            }

            if (validFormat) {
                return time;
            }

            System.out.printf("""

                --------------------------------------------------------------
                Invalid %s! Must be in hh:mm format (e.g., 08:00).
                --------------------------------------------------------------

                """, str);
        }
    }

    public static int validateSeatCapacity() {
        while (true) {
            boolean isValidFormat = true;

            System.out.print("Enter seat capacity: ");
            String seatCapacityString = scanner.nextLine();

            for (char character : seatCapacityString.toCharArray()) {
                if (!Character.isDigit(character)) {
                    isValidFormat = false;
                }
            }

            if (isValidFormat) {
                // If the user enters an empty value, default seat capacity to 0
                if (seatCapacityString.equals("")) {
                    seatCapacityString = "0";
                }

                // Convert the valid seat capacity string to an integer and return
                return Integer.parseInt(seatCapacityString);
            }

            System.out.print("""

                --------------------------------------------------------------
                Invalid seat capacity! Must be digits.
                --------------------------------------------------------------

                """);
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
}
