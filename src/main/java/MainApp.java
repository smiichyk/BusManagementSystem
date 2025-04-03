import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static BusStation busStation = getDundalkBusStation();
    private static final int busNumberLength = 6;

    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
    }

    public static BusStation getDundalkBusStation() {
        // Create a new BusStation object for Dundalk
        BusStation dundalkBusStation = new BusStation("Dundalk Bus Station", "Dundalk");

        // Add various bus routes to the Dundalk Bus Station
        dundalkBusStation.addBus(getRoute100_314645());
        dundalkBusStation.addBus(getRoute100_314682());
        dundalkBusStation.addBus(getRoute100_314569());
        dundalkBusStation.addBus(getRoute100X_314654());

        // Return the fully initialised bus station object
        return dundalkBusStation;
    }
    public static ArrayList<String> getRoute100Stops() {
        return new ArrayList<>(Arrays.asList(
                "Dundalk (Bus Station - Long Walk)", "Dundalk (Dublin Rd McDonalds)",
                "Dundalk (Opp County Louth Hospital)", "Dundalk I.T (Main Gate)", "Haggardstown (Sextons)",
                "Greengates Cross (Southbound)", "Castlebellingham (The Village Store)",
                "Kilsaran (Opp St Olivers Park)", "Kilsaran (Opp St Marys Villas)",
                "Mullins Cross (Southbound)", "Dunleer (The Dunleer Inn)", "Dunleer (Wogans Hardware)",
                "Mullary (Southbound)", "Tinure (Southbound)", "Monasterboice (Monasterboice Inn)",
                "Killeneer (Cockle Rd Cross Sbound)", "Killeneer (Killeneer Cottages)",
                "Drogheda Hospital (NorthGate East)", "Drogheda (Bus Station)"
        ));
    }
    public static Bus getRoute100_314682() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "06:15", "06:17", "06:19", "06:20", "06:23", "06:24", "06:30", "06:31", "06:32", "06:35",
                "06:39", "06:40", "06:43", "06:45", "06:49", "06:49", "06:50", "06:56", "07:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314682, "100", "Dundalk-Drogheda", "06:15",
                "07:06", 55, getRoute100Stops(), times);
    }
    public static Bus getRoute100_314645() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "07:15", "07:17", "07:19", "07:20", "07:23", "07:24", "07:30", "07:31", "07:32", "07:35",
                "07:39", "07:40", "07:43", "07:45", "07:49", "07:49", "07:50", "07:56", "08:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314645, "100", "Dundalk-Drogheda", "07:15",
                "08:06", 55, getRoute100Stops(), times);
    }
    public static Bus getRoute100_314569() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "08:15", "08:17", "08:19", "08:20", "08:23", "08:24", "08:30", "08:31", "08:32", "08:35",
                "08:39", "08:40", "08:43", "08:45", "08:49", "08:49", "08:50", "08:56", "09:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314569, "100", "Dundalk-Drogheda", "08:15",
                "09:06", 48, getRoute100Stops(), times);
    }
    public static Bus getRoute100X_314654() {

        // Define the stops
        ArrayList<String> stops = new ArrayList<>(Arrays.asList(
                "Dundalk (Bus Station- Long Walk)", "Dundalk (Dublin Rd McDonalds)",
                "Dundalk (Opp County Louth Hospital)", "Dundalk I.T (Main Gate)",
                "Drogheda (Donore Rd FBD)", "Drogheda (Bus Station)", "Drogheda (Donore Rd The Thatch Pub)",
                "Dublin Airport (Terminal Two)", "Dublin Airport - Maldron Hotel",
                "Dublin (East Wall Rd Opp 3Arena)", "Dublin (Opp Convention Centre)",
                "Custom House Qy (Op Hilton Garden Inn)", "South Townsend St",
                "Westland Row Church", "Merrion Square West (Jct Clare St)", "Merrion Square South"
        ));

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "06:30", "06:33", "06:35", "06:37", "07:02", "07:10", "07:14",
                "07:46", "07:48", "08:02", "08:04", "08:06", "08:09", "08:12", "08:16", "08:20"
        ));

        // Return a new Bus object with route details
        return new Bus(314654, "100X", "Dundalk-Dublin", "06:30",
                "08:20", 55, stops, times);
    }

    public static void mainMenu() throws FileNotFoundException {

        // Define valid menu choices
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
                    
                    --------------------------------------------------
                    Invalid choice. Please enter a number from 0 to 2.
                    --------------------------------------------------
                    
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

    public static void busStationManagementMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                BUS STATION MANAGEMENT MENU:
                
                1. View full bus station information
                2. View information
                3. Edit bus station information
                4. Create a new bus station
                5. Buses Management
                0. Main Menu""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 5.
                --------------------------------------------------
                                
                1. View full bus station information
                2. View information
                3. Edit bus station information
                4. Create a new bus station
                5. Buses Management
                0. Main Menu""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Display full bus station information
            System.out.println("\n----------------------------------\n"
                    +busStation.toString());
            System.out.println("----------------------------------");
        } else if (choice.equals("2")) {
            // Navigate to the view information menu
            viewBusStationInfoMenu();
        } else if (choice.equals("3")) {
            // Navigate to the edit bus station menu
            editBusStationInfoMenu();
        } else if (choice.equals("4")) {
            // Navigate to the creation new bus station menu
            createNewBusStationMenu();
        }  else if (choice.equals("5")) {
            // Navigate to the buses management menu
            busesManagementMenu();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busStationManagementMenu();
        }
    }
    public static void viewBusStationInfoMenu() {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                VIEW INFORMATION MENU:
                
                1. Station name
                2. Station location
                3. View buses
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 3.
                --------------------------------------------------
                                
                1. Station name
                2. Station location
                3. View buses
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Display station name
            System.out.println("\n--------------------------------------\nBUS STATION NAME: "+busStation.getStationName()+
                    "\n--------------------------------------");
        } else if (choice.equals("2")) {
            // Display station location
            System.out.println("\n--------------------\nLOCATION: "+busStation.getLocation()+
                    "\n--------------------");
        } else if (choice.equals("3")) {
            // Display a buses list
            System.out.println("\n------------------------------------------------");
            busStation.displayAllBuses(busStation.getBuses(), 0, 0, "");
            System.out.println("\n------------------------------------------------\n");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            viewBusStationInfoMenu();
        }
    }
    public static void editBusStationInfoMenu() throws FileNotFoundException {

        // Define valid menu choices
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
                                    
                    --------------------------------------------------
                    Invalid choice. Please enter a number from 0 to 3.
                    --------------------------------------------------
                                    
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
            System.out.println("""

                    ---------------------
                    Station name changed.
                    ---------------------""");
        } else if (choice.equals("2")) {
            // Prompt user to enter the location
            System.out.print("\nEnter location: ");
            String location = scanner.nextLine();

            // Change location
            busStation.setLocation(location);
            System.out.println("""

                    -----------------
                    Location changed.
                    -----------------""");
        } else if (choice.equals("3")) {
            System.out.print("\nEnter the file name: ");
            String fileLink = scanner.nextLine();
            busStation.replaceBusesFromTextFile(fileLink);
            System.out.println("""

                    ----------------------
                    List of buses changed.
                    ----------------------""");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            editBusStationInfoMenu();
        }
    }
    public static void createNewBusStationMenu() throws FileNotFoundException {

        // Define valid menu choices
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
                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 3.
                --------------------------------------------------
                                
                1. Create an empty bus station
                2. Create a bus station with full details
                3. Create a bus station with partial information
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Call the method to create an empty bus station
            createBusStationMenuChoiceMenu(1);
        } else if (choice.equals("2")) {
            // Call the method to create a bus station with full details
            createBusStationMenuChoiceMenu(2);
        } else if (choice.equals("3")) {
            // Call the method to create a bus station with partial details
            createBusStationMenuChoiceMenu(3);
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createNewBusStationMenu();
        }
    }
    public static void createBusStationMenuChoiceMenu(int choice) throws FileNotFoundException {

        // Inform the user that creating a new bus station will delete the existing one
        System.out.print("""
                ------------------------------------------------------------------------------
                A Bus Station already exists. Creating a new one will delete the previous one.
                ------------------------------------------------------------------------------
                
                """);
        System.out.print("Are you sure? (yes/no): ");
        String confirmation = scanner.nextLine().toLowerCase();

        // Proceed only if the user confirms
        if (confirmation.equals("yes")) {
            if (choice == 1) {
                // Create an empty bus station
                busStation = new BusStation();
                System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
            } else if (choice == 2) {
                // Prompt user to enter the station name
                System.out.print("\nEnter station name: ");
                String stationName = scanner.nextLine();
                busStation.setStationName(stationName);

                // Prompt user to enter the location
                System.out.print("Enter location: ");
                String location = scanner.nextLine();
                busStation.setLocation(location);

                // Prompt user to enter the file link to the file with buses
                System.out.print("Enter the file name: ");
                String fileLink = scanner.nextLine();

                // Create the bus station
                busStation.replaceBusesFromTextFile(fileLink);
                System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
            } else {
                // Create a bus station with partial information
                createBusStationWithPartialInfo();
            }
        }
    }
    public static void createBusStationWithPartialInfo() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                CREATE BUS STATION WITH PARTIAL INFO MENU:
                
                1. Enter only the station name
                2. Enter the station name, location, and bus list
                3. Enter the station name and location
                4. Enter the station name and bus list
                5. Enter only the bus list
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 5.
                --------------------------------------------------
                                    
                1. Enter only the station name
                2. Enter the station name, location, and bus list
                3. Enter the station name and location
                4. Enter the station name and bus list
                5. Enter only the bus list
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Create a new bus station with just the station name
            busStation = new BusStation(stationName);
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        } else if (choice.equals("2")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Prompt user to enter the location
            System.out.print("Enter location: ");
            String location = scanner.nextLine();

            // Prompt user to enter the file link to the file with buses
            System.out.print("Enter the file name: ");
            String fileLink = scanner.nextLine();

            // Create a new bus station with full details, including buses loaded from the specified file
            busStation = new BusStation(stationName, location, busStation.loadBusesFromTextFile(fileLink));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        } else if (choice.equals("3")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Prompt user to enter the location
            System.out.print("Enter location: ");
            String location = scanner.nextLine();

            // Create a new bus station with just the name and location
            busStation = new BusStation(stationName, location);
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        } else if (choice.equals("4")) {
            // Prompt user to enter the station name
            System.out.print("\nEnter station name: ");
            String stationName = scanner.nextLine();

            // Prompt user to enter the file link to the file with buses
            System.out.print("Enter the file name: ");
            String fileLink = scanner.nextLine();

            // Create a new bus station with the name and buses loaded from the specified file
            busStation = new BusStation(stationName, busStation.loadBusesFromTextFile(fileLink));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }  else if (choice.equals("5")) {
            // Prompt user to enter the file link to the file with buses
            System.out.print("\nEnter the file name: ");
            String fileLink = scanner.nextLine();

            // Create a new bus station by loading buses from the specified file
            busStation = new BusStation(busStation.loadBusesFromTextFile(fileLink));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createBusStationWithPartialInfo();
        }
    }
    public static void busesManagementMenu() throws FileNotFoundException {

        // Define valid menu choices
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
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 6.
                --------------------------------------------------
                                
                1. Add a new bus
                2. Add buses from text file
                3. Remove a bus
                4. Remove all buses
                5. Search for a bus
                6. View all buses
                0. Return""");
            System.out.print("\nYour choice: ");
            choice = scanner.nextLine();
        }

        // Process user choice
        if (choice.equals("1")) {
            // Call the method to allow the user to add a new bus
            addBusMenu();
        } else if (choice.equals("2")) {
            // Get the file name from the user to add buses from text file
            System.out.print("\nEnter the file name: ");
            String fileLink = scanner.nextLine();
            busStation.addBusesFromTextFile(fileLink);
            System.out.println("""

                    --------------------------------------
                    Buses from the file added to the list.
                    --------------------------------------""");
        } else if (choice.equals("3")) {
            // Call the method to allow the user to remove a bus
            removeBusMenu();
        } else if (choice.equals("4")) {
            // Set the list of buses to a new empty list, effectively removing all buses
            busStation.setBuses(new ArrayList<>());
            System.out.print("\nAre you sure? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();
            if (confirmation.equals("yes")) {
                System.out.println("""

                        ----------------------------
                        Buses removed from the list.
                        ----------------------------""");
            }
        } else if (choice.equals("5")) {
            // Call the method to allow the user to search for a bus
            searchBusMenu();
        } else if (choice.equals("6")) {
            // Display all buses in the bus station
            System.out.println("\n------------------------------------------------");
            busStation.displayAllBuses(busStation.getBuses(), 0, 0, "");
            System.out.println("\n------------------------------------------------\n");
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
        System.out.println("\n--------------------------------------------\nBus "+busNumber
                +" added to the "+busStation.getStationName()
                +"\n--------------------------------------------");
    }
    public static void removeBusMenu() {

        // Define valid menu choices
        String[] choices = {"1", "2", "0"};

        // Display the menu options
        System.out.println("""
                
                **************************************************************************
                
                REMOVE BUS MENU:
                
                1. By bus number
                2. By bus name
                0. Return""");

        // Read user input
        System.out.print("\nYour choice: ");
        String choice = scanner.nextLine();

        // Validate user input to ensure it is one of the allowed choices
        while (!isValidChoice(choice, choices)) {
            System.out.println("""
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 2.
                --------------------------------------------------
                                
                1. By bus number
                2. By bus name
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

            // Check if the bus number exists in the list, and remove it if found
            if (busStation.isBusInBusesByNumber(busNumber)) {
                busStation.removeBus(busNumber);
                System.out.println("\n-------------------------------------\n" +
                        "Bus "+busNumber+" removed from the bus list.\n" +
                        "-------------------------------------");
            } else {
                // Inform the user if no bus was found with the given number
                System.out.println("\n----------------------------------------------\n" +
                        "There are no buses with the bus number "+busNumber+".\n" +
                        "----------------------------------------------");
            }
        } else if (choice.equals("2")) {
            // Prompt user to enter the bus name
            System.out.print("\nEnter bus name: ");
            String busName = scanner.nextLine();

            // Check if the bus name exists in the list, and remove it if found
            if (busStation.isBusInBusesByName(busName)) {
                busStation.removeBus(busName);
                System.out.println("\n---------------------------------------\n" +
                        "Bus(es) "+busName+" removed from the bus list.\n" +
                        "---------------------------------------");
            } else {
                // Inform the user if no bus was found with the given name
                System.out.println("\n-------------------------------------------\n" +
                        "There are no buses with the bus name: "+busName+".\n" +
                        "-------------------------------------------");
            }
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            removeBusMenu();
        }
    }
    public static void searchBusMenu() {

        // Define valid menu choices
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
                                
                --------------------------------------------------
                Invalid choice. Please enter a number from 0 to 3.
                --------------------------------------------------
                                
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

            // Display the buses that match the bus number
            System.out.println("\n-----------------------------------------------");
            busStation.displayAllBuses(buses, 1, busNumber, "");
            System.out.println("\n-----------------------------------------------");
        } else if (choice.equals("2")) {
            // Prompt user to enter the bus name
            System.out.print("\nEnter bus name: ");
            String busName = scanner.nextLine();
            ArrayList<Bus> buses = busStation.busesByName(busName);

            // Display the buses that match the bus name
            System.out.println("\n-----------------------------------------------");
            busStation.displayAllBuses(buses, 2, 0, busName);
            System.out.println("\n-----------------------------------------------");
        } else if (choice.equals("3")) {
            // Prompt user to enter the route name
            System.out.print("\nEnter route name: ");
            String routeName = scanner.nextLine();
            ArrayList<Bus> buses = busStation.busesByRoute(routeName);

            // Display the buses that match the route name
            System.out.println("\n------------------------------------------------------");
            busStation.displayAllBuses(buses, 3, 0, routeName);
            System.out.println("\n------------------------------------------------------");
        }
        System.out.println();

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            searchBusMenu();
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

    private static boolean isValidChoice(String choice, String[] choices) {
        for (String validChoice : choices) {
            if (choice.equals(validChoice)) {
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

                --------------------------------------
                Invalid bus number! Must be %d digits.
                --------------------------------------

                """, busNumberLength);
        }
    }
    public static String validateTime(String str) {
        while (true) {
            boolean validFormat = true;

            System.out.printf("Enter %s time (hh:mm): ", str);
            String time = scanner.nextLine();

            if (time.length() != 5 || time.charAt(2) != ':') {
                validFormat = false;
            } else {
                for (int i = 0; i < time.length(); i++) {
                    if (i != 2 && !Character.isDigit(time.charAt(i))) {
                        validFormat = false;
                    } else {
                        int hours = Integer.parseInt(time.substring(0, 2));
                        int minutes = Integer.parseInt(time.substring(3));

                        if (hours>24 || hours<1 || minutes>59) {
                            validFormat = false;
                        }
                    }
                }
            }

            if (validFormat) {
                return time;
            }

            System.out.printf("""

                --------------------------------------------------------------
                Invalid %s! Must be in hh:mm format (e.g., 24:00).
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

                --------------------------------------
                Invalid seat capacity! Must be digits.
                --------------------------------------

                """);
        }
    }
}
