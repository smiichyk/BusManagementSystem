import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static BusStation busStation = getDundalkBusStation();
    private static final int busNumberLength = 6;

    public static void main(String[] args) {
        mainMenu();
    }

    public static BusStation getDundalkBusStation() {
        BusStation dundalkBusStation = new BusStation("Dundalk Bus Station", "Dundalk");
        dundalkBusStation.addBus(getRoute100_314645());
        dundalkBusStation.addBus(getRoute100_314682());
        dundalkBusStation.addBus(getRoute100_314569());
        dundalkBusStation.addBus(getRoute100X_314654());
        return dundalkBusStation;
    }

    public static Bus getRoute100_314682() {
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

    public static Bus getRoute100_314645() {
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
                "07:15", "07:17", "07:19", "07:20", "07:23", "07:24", "07:30", "07:31", "07:32", "07:35",
                "07:39", "07:40", "07:43", "07:45", "07:49", "07:49", "07:50", "07:56", "08:06"
        ));
        return new Bus(314645, "100", "Dundalk - Drogheda", "07:15",
                "08:06", 55, stops, times);
    }

    public static Bus getRoute100_314569() {
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
                "08:15", "08:17", "08:19", "08:20", "08:23", "08:24", "08:30", "08:31", "08:32", "08:35",
                "08:39", "08:40", "08:43", "08:45", "08:49", "08:49", "08:50", "08:56", "09:06"
        ));
        return new Bus(314569, "100", "Dundalk - Drogheda", "08:15",
                "09:06", 48, stops, times);
    }

    public static Bus getRoute100X_314654() {
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

    public static void mainMenu() {
        String[] choices = {"1", "2", "0"};
        boolean exit = false;

        // Loop runs until the user chooses to exit
        while (!exit) {

            // Display the menu options
            System.out.println("""
                    
                    **************************************************************************
                    
                    MAIN MENU:
                    
                    1. Bus Station Management
                    2. Bus Management
                    0. Exit Program""");

            // Read user input
            System.out.print("\nYour choice: ");
            String choice = scanner.nextLine();

            // Validate user input to ensure it is one of the allowed choices
            while (!isValidChoice(choice, choices)) {
                System.out.println("""
                    
                    __________________________________________________________________________
                 
                    Invalid choice. Please enter a number from 0 to 2.
                    
                    __________________________________________________________________________
                    
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

        String[] choices = {"1", "2", "3", "4", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                BUS STATION MANAGEMENT MENU:
                
                1. View bus station information
                2. Edit bus station information
                3. Create a new bus station
                4. Buses Management
                0. Main Menu""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                    
                    __________________________________________________________________________
                                    
                    Invalid choice. Please enter a number from 0 to 9.
                    
                    __________________________________________________________________________
                                    
                    1. View bus station information
                    2. Edit bus station information
                    3. Create a new bus station
                    4. Buses Management
                    0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            System.out.println("\n"+busStation.toString());
        } else if (choice.equals("2")) {
            editBusStationInfoMenu();
        } else if (choice.equals("3")) {
            createNewBusStationMenu();
        }  else if (choice.equals("4")) {
            busesManagementMenu();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busStationManagementMenu();
        }
    }

    public static void busManagementMenu() {

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                BUS MANAGEMENT MENU:
                
                1. View bus route
                2. Add a stop
                3. Remove a stop
                4. Update stop information
                5. Check if a stop is on the route
                6. View route duration
                7. Change bus capacity
                0. Main Menu""");
    }

    public static void editBusStationInfoMenu() {
        String[] choices = {"1", "2", "3", "0"};

        // Display the menu options
        System.out.println("""
                                
                **************************************************************************
                
                EDIT BUS STATION INFO MENU:
                                
                1. Change station name
                2. Change location
                3. Replace bus list from text file
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                    
                    __________________________________________________________________________
                                        
                    Invalid choice. Please enter a number from 0 to 3.
                        
                    __________________________________________________________________________
                                    
                    1. Change station name
                    2. Change location
                    3. Replace bus list from text file
                    0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();
            // Change station name
            busStation.setStationName(stationName);
        } else if (choice.equals("2")) {
            // Prompt user to enter the location
            System.out.print("\nEnter location: ");
            String location = scanner.nextLine();
            // Change location
            busStation.setLocation(location);
        } else if (choice.equals("3")) {
            replaceBusListFromTextFileMenu();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            editBusStationInfoMenu();
        }
    }

    public static void createNewBusStationMenu() {
        String[] choices = {"1", "2", "3", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                CREATE NEW BUS STATION MENU:
                
                1. Create an empty bus station
                2. Create a bus station with full details
                3. Create a bus station with partial information
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                
                __________________________________________________________________________
             
                Invalid choice. Please enter a number from 0 to 3.
                
                __________________________________________________________________________
                                
                1. Create an empty bus station
                2. Create a bus station with full details
                3. Create a bus station with partial information
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            createBusStationMenuChoiceMenu(1);
        } else if (choice.equals("2")) {
            createBusStationMenuChoiceMenu(2);
        } else if (choice.equals("3")) {
            createBusStationMenuChoiceMenu(3);
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createNewBusStationMenu();
        }
    }

    public static void busesManagementMenu() {
        String[] choices = {"1", "2", "3", "4", "5", "6", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                BUSES MANAGEMENT MENU:
                
                1. Add a new bus
                2. Add buses from text file
                3. Remove a bus
                4. Remove all buses
                5. Search for a bus
                6. View all buses
                0. Main Menu""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                __________________________________________________________________________
                                
                Invalid choice. Please enter a number from 0 to 6.
                
                __________________________________________________________________________
                                
                1. Add a new bus
                2. Add buses from text file
                3. Remove a bus
                4. Remove all buses
                5. Search for a bus
                6. View all buses
                0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            addBusMenu();
        } else if (choice.equals("2")) {
            loadBusesFromTextFileMenu();
        } else if (choice.equals("3")) {
            // Prompt user to enter the bus number
            String busNumberString = validateBusNumber();
            // Prompt the user for the bus number and validate its format
            int busNumber = Integer.parseInt(busNumberString);

            if (busStation.isBusInBusesByNumber(busNumber)) {
                busStation.removeBus(busNumber);
                System.out.println("\nBus "+busNumber+" removed from the bus list.");
            } else {
                System.out.println("\nThere are no buses with the bus number "+busNumber+".");
            }
        } else if (choice.equals("4")) {
            busStation.setBuses(new ArrayList<>());
        } else if (choice.equals("5")) {
            searchBusMenu();
        } else if (choice.equals("6")) {
            busStation.displayAllBuses(busStation.getBuses(), 0, 0, "");
            System.out.println();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busesManagementMenu();
        }
    }

    public static void addBusMenu() {

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

    public static void searchBusMenu() {

        String[] choices = {"1", "2", "3", "0"};

        // Display menu options
        System.out.println("""
                
                **************************************************************************
                
                SEARCH BUS MENU:
                
                1. By number
                2. By name
                3. By route name
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                __________________________________________________________________________
                                
                Invalid choice. Please enter a number from 0 to 3.
                
                __________________________________________________________________________
                                
                1. By number
                2. By name
                3. By route name
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Prompt user to enter the bus number
            String busNumberString = validateBusNumber();
            // Prompt the user for the bus number and validate its format
            int busNumber = Integer.parseInt(busNumberString);
            ArrayList<Bus> buses = busStation.busByNumber(busNumber);
            busStation.displayAllBuses(buses, 1, busNumber, "");
        } else if (choice.equals("2")) {
            // Prompt user to enter the bus name
            System.out.print("\nEnter bus name: ");
            String busName = scanner.nextLine();
            ArrayList<Bus> buses = busStation.busesByName(busName);
            busStation.displayAllBuses(buses, 2, 0, busName);
        } else if (choice.equals("3")) {
            // Prompt user to enter the route name
            System.out.print("\nEnter route name: ");
            String routeName = scanner.nextLine();
            ArrayList<Bus> buses = busStation.busesByRoute(routeName);
            busStation.displayAllBuses(buses, 3, 0, routeName);
        }
        System.out.println();

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            searchBusMenu();
        }
    }

    public static void loadBusesFromTextFileMenu() {
        System.out.println("loadBusesFromTextFileMenu");
    }

    public static void replaceBusListFromTextFileMenu() {
        System.out.println("replaceBusListFromTextFileMenu");
    }

    public static void createBusStationMenuChoiceMenu(int choice) {

        System.out.print("""

                A Bus Station already exists. Creating a new one will delete the previous one.
                
                """);
        System.out.print("Are you sure? (yes/no): ");
        String confirmation = scanner.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            if (choice == 1) {
                System.out.println("\nNew Empty Bus Station was created.");
                busStation = new BusStation();
            } else if (choice == 2) {
                // Prompt user to enter the station name
                System.out.print("\nEnter station name: ");
                String stationName = scanner.nextLine();

                // Prompt user to enter the location
                System.out.print("Enter location: ");
                String location = scanner.nextLine();

                // Prompt user to enter the file link to the file with buses
                System.out.print("Enter the file link to the file containing bus information:");
                replaceBusListFromTextFileMenu();
                ArrayList<Bus> buses = new ArrayList<>();

                busStation = new BusStation(stationName, location, buses);
            } else {
                createBusStationWithPartialInfo();
            }
        }
    }

    public static void createBusStationWithPartialInfo() {
        String[] choices = {"1", "2", "3", "4", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                CREATE BUS STATION WITH PARTIAL INFO MENU:
                
                1. Enter only the station name
                2. Enter the station name and location
                3. Enter the station name and bus list
                4. Enter only the bus list
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                __________________________________________________________________________
                                
                Invalid choice. Please enter a number from 0 to 4.
                
                __________________________________________________________________________
                                    
                1. Enter only the station name
                2. Enter the station name and location
                3. Enter the station name and bus list
                4. Enter only the bus list
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            busStation = new BusStation(stationName);
        } else if (choice.equals("2")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Prompt user to enter the location
            System.out.print("Enter location: ");
            String location = scanner.nextLine();

            busStation = new BusStation(stationName, location);
        } else if (choice.equals("3")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Prompt user to enter the file link to the file with buses
            System.out.print("Enter the file link to the file containing bus information:");
            replaceBusListFromTextFileMenu();
            ArrayList<Bus> buses = new ArrayList<>();

            busStation = new BusStation(stationName, buses);
        }  else if (choice.equals("4")) {
            // Prompt user to enter the file link to the file with buses
            System.out.print("\nEnter the file link to the file containing bus information:");
            replaceBusListFromTextFileMenu();
            ArrayList<Bus> buses = new ArrayList<>();

            busStation = new BusStation(buses);
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createBusStationWithPartialInfo();
        }
    }

    private static boolean isValidChoice(String choice, String[] choices) {
        for (String validChoice : choices) {
            if (validChoice.equals(choice)) {
                return true;
            }
        }
        return false;
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
            System.out.print("\nEnter bus number: ");
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
                if (seatCapacityString.isEmpty()) {
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
}
