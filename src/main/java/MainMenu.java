import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainMenu {

    private static BusStation busStation = DundalkBusStation.getBusStation();
    public static final int busNumberLength = 6;
    private static boolean exit = false;

    /**
     * Displays a formatted menu with a header and choices, prompts the user for input,
     * and validates the input until a valid choice is entered.
     * @param choices An array of valid choices (strings representing numbers).
     * @param header The title or heading for the menu.
     * @param menu_choices The string containing formatted menu options to display.
     * @return The valid user choice as a String.
     */
    public static String displayMenuAndGetUserChoice(String[] choices, String header, String menu_choices) {

        // Print menu decoration line
        System.out.println("\n**************************************************************************\n");

        // Display the menu header (title)
        System.out.println(header+":\n");

        // Display the menu options
        System.out.println(menu_choices);

        // Prompt the user to enter a choice
        String choice = askAndReturn.choice();

        // Loop until the user enters a valid choice
        while (!isValidChoice(choice, choices)) {

            // Display an error message if the choice is invalid
            System.out.printf("""
                                    
                    --------------------------------------------------
                    Invalid choice. Please enter a number from 0 to %s.
                    --------------------------------------------------
                    %n""", choices[(choices.length)-2]);

            // Re-display menu options
            System.out.println(menu_choices);

            // Prompt the user again
            System.out.print("\nYour choice: ");
            choice = askAndReturn.choice();
        }

        // Return the validated user choice
        return choice;
    }


    // Main menu

    /**
     * 1
     * Displays the main menu and handles user input to navigate to different parts
     * of the program. Loops until the user chooses to exit.
     * @throws FileNotFoundException If the file is not found.
     */
    public static void mainMenu() throws FileNotFoundException {

        // Loop continues to display the main menu until the user chooses to exit
        while (!exit) {

            // Define valid menu choices
            String[] choices = {"1", "2", "0"};


            // Display the main menu and get user's validated choice
            String choice = displayMenuAndGetUserChoice(choices, "MAIN MENU",
                    """
                    1. Bus Station Management
                    2. Bus Management
                    0. Exit Program""");

            // Process user choice
            if (choice.equals("1")) {
                // Go to Bus Station Management menu
                busStationManagementMenu();
            }
            else if (choice.equals("2")) {
                // Go to Bus Management menu
                chooseBusMenu();
            }
            else {
                // Exit option selected - print exit message and end loop
                System.out.println("""

                    -------------------
                    Exiting program...
                    -------------------
                    
                    **************************************************************************""");
                exit = true;
            }
        }
    }


    // Private menus

    /**
     * 1.1
     * Displays the main Bus Station Management Menu and handles user interactions.
     * Based on the user's choice, this method navigates to different submenus or actions,
     * such as viewing, editing, or replacing bus station information, or managing buses.
     *
     * @throws FileNotFoundException If the file is not found.
     */
    private static void busStationManagementMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "BUS STATION MANAGEMENT MENU",
                """
                1. View full bus station information
                2. View information
                3. Edit bus station information
                4. Replace all bus station data
                5. Buses Management
                0. Main Menu""");

        // Process user choice
        if (choice.equals("1")) {
            // Display full bus station information
            System.out.printf("""

                    ----------------------------------
                    %s
                    ----------------------------------
                    """, busStation.toString());
        }
        else if (choice.equals("2")) {
            // Navigate to the view information menu
            viewBusStationInfoMenu();
        }
        else if (choice.equals("3")) {
            // Navigate to the edit bus station menu
            editBusStationInfoMenu();
        }
        else if (choice.equals("4")) {
            // Navigate to the replacing all bus station data menu
            createNewBusStationMenu();
        }
        else if (choice.equals("5")) {
            // Navigate to the buses management menu
            busesManagementMenu();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busStationManagementMenu();
        }
    }

    /**
     * 1.1.1
     * Displays the "View Information" menu and handles user interactions.
     * Allows the user to view the bus station name, location, or list of buses.
     */
    private static void viewBusStationInfoMenu() {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "VIEW INFORMATION MENU",
                """
                1. Station name
                2. Station location
                3. View buses
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Display station name
            System.out.printf("""

                    --------------------------------------
                    BUS STATION NAME: %s
                    --------------------------------------
                    """, busStation.getStationName());
        }
        else if (choice.equals("2")) {
            // Display station location
            System.out.printf("""

                    --------------------
                    LOCATION: %s
                    --------------------
                    """, busStation.getLocation());
        }
        else if (choice.equals("3")) {
            // Display buses table
            displayBusesTable();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            viewBusStationInfoMenu();
        }
    }

    /**
     * 1.1.3
     * Displays the "Edit Bus Station Info" menu and handles user interactions.
     * Allows changing the station name, location, or replacing the bus list with a file.
     *
     * @throws FileNotFoundException if the bus list file is not found
     */
    private static void editBusStationInfoMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "EDIT BUS STATION INFO MENU",
                """
                1. Change station name
                2. Change location
                3. Replace bus list from text file
                0. Return""");


        // Process user choice
        if (choice.equals("1")) {
            // Change station name
            busStation.setStationName(askAndReturn.stationName());
            System.out.println("""

                    -------------------------------------------
                    Station name has been changed successfully.
                    -------------------------------------------""");
        }
        else if (choice.equals("2")) {
            // Change location
            busStation.setLocation(askAndReturn.location());
            System.out.println("""

                    ---------------------------------------
                    Location has been changed successfully.
                    ---------------------------------------""");
        }
        else if (choice.equals("3")) {
            // Attempt to load and set buses from file
            busStation.setBusesFromTextFile(askAndReturn.fileName());
            System.out.println("""

                    --------------------------------------------
                    List of buses has been changed successfully.
                    --------------------------------------------""");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            editBusStationInfoMenu();
        }
    }

    /**
     * 1.1.4
     * Displays the "Create New Bus Station" menu and handles user selections.
     * Allows creation of a new bus station with empty, full, or partial data.
     *
     * @throws FileNotFoundException If the file is not found.
     */
    private static void createNewBusStationMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "CREATE NEW BUS STATION MENU",
                """
                1. Create an empty bus station
                2. Create a bus station with full details
                3. Create a bus station with partial information
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Call the method to create an empty bus station
            createBusStationMenuChoiceMenu(1);
        }
        else if (choice.equals("2")) {
            // Call the method to create a bus station with full details
            createBusStationMenuChoiceMenu(2);
        }
        else if (choice.equals("3")) {
            // Call the method to create a bus station with partial details
            createBusStationMenuChoiceMenu(3);
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createNewBusStationMenu();
        }
    }

    /**
     * 1.1.4.3
     * Creates a new bus station based on a user-selected creation option (empty/full/partial).
     * Prompts user for confirmation before replacing existing station data.
     *
     * @param choice the creation method to use (1 = empty, 2 = full, 3 = partial)
     * @throws FileNotFoundException If the file is not found.
     */
    private static void createBusStationMenuChoiceMenu(int choice) throws FileNotFoundException {

        // Inform the user that creating a new bus station will delete the existing one
        System.out.println("""
                
                ------------------------------------------------------------------------------
                A Bus Station already exists. Creating a new one will delete the previous one.
                ------------------------------------------------------------------------------
                """);

        // Proceed only if the user confirms
        if (askAndReturn.isConfirm()) {
            if (choice == 1) {
                // Create an empty bus station
                busStation = new BusStation();
                System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
            }
            else if (choice == 2) {
                // Prompt user to enter the station name
                String bus_station_name = askAndReturn.stationName();

                // Prompt user to enter the location
                String location = askAndReturn.location();

                // Prompt user to enter the file link to the file with buses
                ArrayList<Bus> buses = busStation.getBusesFromTextFile(askAndReturn.fileName());

                // Create new bus station
                busStation = new BusStation(bus_station_name, location, buses);
                System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
            }
            else {
                // Create a bus station with partial information
                createBusStationWithPartialInfoMenu();
            }
        } else {
            System.out.println("""
        
                --------------------
                Operation cancelled.
                --------------------""");
        }
    }

    /**
     * 1.1.4.3.x
     * Displays menu options to create a bus station with partial information.
     * Handles user input and creates a BusStation with the selected set of attributes.
     *
     * @throws FileNotFoundException If the file is not found.
     */
    private static void createBusStationWithPartialInfoMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "CREATE BUS STATION WITH PARTIAL INFO MENU",
                """
                1. Enter only the station name
                2. Enter the station name, location, and bus list
                3. Enter the station name and location
                4. Enter the station name and bus list
                5. Enter only the bus list
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Create a new bus station with just the station name
            busStation = new BusStation(askAndReturn.stationName());
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }
        else if (choice.equals("2")) {
            // Prompt user to enter the station name
            String stationName = askAndReturn.stationName();

            // Prompt user to enter the location
            String location = askAndReturn.location();

            // Prompt user to enter the file link to the file with buses
            String fileLink = askAndReturn.fileName();

            // Create a new bus station with full details, including buses loaded from the specified file
            busStation = new BusStation(stationName, location, busStation.getBusesFromTextFile(fileLink));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }
        else if (choice.equals("3")) {
            // Create a new bus station with just the name and location
            busStation = new BusStation(askAndReturn.stationName(), askAndReturn.location());
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }
        else if (choice.equals("4")) {
            // Create a new bus station with the name and buses loaded from the specified file
            busStation = new BusStation(askAndReturn.stationName(),
                    busStation.getBusesFromTextFile(askAndReturn.fileName()));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }
        else if (choice.equals("5")) {
            // Create a new bus station by loading buses from the specified file
            busStation = new BusStation(busStation.getBusesFromTextFile(askAndReturn.fileName()));
            System.out.println("""

                        ----------------------------
                        New Bus Station was created.
                        ----------------------------""");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            createBusStationWithPartialInfoMenu();
        }
    }

    /**
     * 1.1.5
     * Displays the "Buses Management" menu and handles related operations.
     * Includes adding, removing, searching, or viewing buses.
     *
     * @throws FileNotFoundException If the file is not found.
     */
    private static void busesManagementMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "6", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "BUSES MANAGEMENT MENU",
                """
                1. Add a new bus
                2. Add buses from text file
                3. Remove a bus(es)
                4. Remove all buses
                5. Search for a bus
                6. View all buses
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Call the method to allow the user to add a new bus
            addBusMenu();
        }
        else if (choice.equals("2")) {
            // Get the file name from the user to add buses from text file
            busStation.addBusesFromTextFile(askAndReturn.fileName());
            System.out.println("""

                --------------------------------------
                Buses from the file added to the list.
                --------------------------------------""");
        }
        else if (choice.equals("3")) {
            // Call the method to allow the user to remove a bus
            removeBusMenu();
        }
        else if (choice.equals("4")) {
            // Proceed only if user confirms with "yes"
            if (askAndReturn.isConfirm()) {
                busStation.clearBuses();
                System.out.println("""

                    ----------------------------
                    Buses removed from the list.
                    ----------------------------""");
            } else {
                System.out.println("""
        
                --------------------
                Operation cancelled.
                --------------------""");
            }
        }
        else if (choice.equals("5")) {
            // Call the method to allow the user to search for a bus
            searchBusMenu();
        }
        else if (choice.equals("6")) {
            // Display all buses in the bus station
            displayBusesTable();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busesManagementMenu();
        }
    }

    /**
     * 1.1.5.1
     * Prompts the user to enter details for a new bus and adds it to the bus station.
     * Validates and collects all necessary fields before creating the Bus object.
     */
    private static void addBusMenu() {

        // Prompt the user for the bus number and validate its format
        int busNumber = askAndReturn.busNumber();

        // Proceed only if a valid (non-zero) bus number was entered
        if (busNumber!=0) {

            // Prompt user to enter the bus name
            String busName = askAndReturn.busName();

            // Prompt user to enter the route name
            String routeName = askAndReturn.routeName();

            // Prompt the user for the departure and arrival times and validate their format
            String departureTime = askAndReturn.time("departure");
            String arrivalTime = askAndReturn.time("arrival");

            // Prompt the user for the seat capacity and validate its format
            int seatCapacity = askAndReturn.seatCapacity();

            // Create a new Bus object with the provided details and add the bus to the bus station
            Bus bus = new Bus(busNumber, busName, routeName, departureTime, arrivalTime, seatCapacity);
            busStation.addBus(bus);

            // Confirm that the bus has been added
            System.out.printf("""

                    --------------------------------------------
                    Bus %d added to the %s
                    --------------------------------------------
                    """, busNumber, busStation.getStationName());
        }
    }

    /**
     * 1.1.5.3
     * Displays the "Remove Bus" menu and handles bus removal.
     * Allows removal by bus number or name, with confirmation prompts.
     */
    private static void removeBusMenu() {

        // Define valid menu choices
        String[] choices = {"1", "2", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "REMOVE BUS(ES) MENU",
                """
                1. By bus number
                2. By bus name
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Prompt the user for the bus number and validate its format
            int busNumber = askAndReturn.busNumber();

            // Proceed only if a valid (non-zero) bus number was entered
            if (busNumber!=0) {

                // Check if the bus number exists in the list, and remove it if found
                if (busStation.isBusInBusesByNumber(busNumber)) {
                    if (askAndReturn.isConfirm()) {
                        busStation.removeBus(busNumber);
                        System.out.printf("""

                                -------------------------------------
                                Bus %d removed from the bus list.
                                -------------------------------------
                                """, busNumber);
                    }
                    else {
                        System.out.println("""
                    
                            --------------------
                            Operation cancelled.
                            --------------------""");
                    }
                } else {
                    // Inform the user if no bus was found with the given number
                    System.out.printf("""

                            ----------------------------------------------
                            There are no buses with the bus number %d.
                            ----------------------------------------------
                            """, busNumber);
                }
            }
        }
        else if (choice.equals("2")) {
            String busName = askAndReturn.busName();

            // Check if the bus name exists in the list, and remove it if found
            if (busStation.isBusInBusesByName(busName)) {
                if (askAndReturn.isConfirm()) {
                    busStation.removeBus(busName);
                    System.out.printf("""

                            ---------------------------------------
                            Bus(es) %s removed from the bus list.
                            ---------------------------------------
                            """, busName);
                }
                else {
                    System.out.println("""
        
                        --------------------
                        Operation cancelled.
                        --------------------""");
                }
            }
            else {
                // Inform the user if no bus was found with the given name
                System.out.printf("""

                        -------------------------------------------
                        There are no buses with the bus name: %s.
                        -------------------------------------------
                        """, busName);
            }
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            removeBusMenu();
        }
    }

    /**
     * 1.1.5.5
     * Displays the "Search Bus" menu and handles search functionality.
     * Allows searching for buses by number, name, or route and displays matched results.
     */
    private static void searchBusMenu() {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "SEARCH BUS MENU",
                """
                1. By number
                2. By name
                3. By route name
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Prompt the user for the bus number and validate its format
            int busNumber = askAndReturn.busNumber();

            // Proceed only if a valid (non-zero) bus number was entered
            if (busNumber!=0) {
                ArrayList<Bus> buses = busStation.getBusesByNumber(busNumber);

                // Display the buses that match the bus number
                System.out.println("\n-----------------------------------------------");
                busStation.displayAllBuses(buses, 1, busNumber, "");
                System.out.println("\n-----------------------------------------------");
            }
        }
        else if (choice.equals("2")) {
            // Prompt user to enter the bus name
            String busName = askAndReturn.busName();
            ArrayList<Bus> buses = busStation.getBusesByName(busName);

            // Display the buses that match the bus name
            System.out.println("\n-----------------------------------------------");
            busStation.displayAllBuses(buses, 2, 0, busName);
            System.out.println("\n-----------------------------------------------");
        }
        else if (choice.equals("3")) {
            // Prompt user to enter the route name
            String routeName = askAndReturn.routeName();
            ArrayList<Bus> buses = busStation.getBusesByRoute(routeName);

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

    /**
     * 1.2
     * Displays the "Choose Bus" menu, allowing the user to either enter a bus number,
     * view all buses, or return to the previous menu. If a valid bus number is entered,
     * the method navigates to the bus management menu for that specific bus.
     *
     * @throws FileNotFoundException If the file is not found.
     */
    private static void chooseBusMenu() throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "CHOOSE BUS MENU",
                """
                1. Enter bus number
                2. View buses
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Prompt the user for the bus number and validate its format
            int busNumber = askAndReturn.busNumber();

            // Proceed only if a valid (non-zero) bus number was entered
            if (busNumber!=0) {

                // Loop until a bus with the entered number exists in the system
                if (!busStation.isBusInBusesByNumber(busNumber)) {

                    // Inform the user if no bus was found with the given number
                    System.out.println("""
                                                
                            ----------------------------------------
                            There are no buses with this bus number.
                            ----------------------------------------""");
                }
                if (busStation.isBusInBusesByNumber(busNumber)) {
                    // If a valid bus is found, proceed to the bus management menu
                    Bus bus = busStation.getBusByNumber(busNumber);
                    busManagementMenu(bus);
                } else {
                    chooseBusMenu();
                }
            }
        }
        else if (choice.equals("2")) {
            // Display buses table
            displayBusesTable();
            chooseBusMenu();
        }
    }

    /**
     * 1.2.1
     * Displays the "Bus Management" menu for the selected bus. The user can choose
     * to view full or partial bus information, edit bus details, manage stops, or return
     * to the main menu.
     *
     * @param bus the Bus object currently selected.
     * @throws FileNotFoundException If the file is not found.
     */
    private static void busManagementMenu(Bus bus) throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "BUS MANAGEMENT MENU",
                """
                1. View full bus information
                2. View bus information
                3. Edit bus information
                4. Stops Management
                0. Main Menu""");

        // Process user choice
        if (choice.equals("1")) {
            // Display full bus information
            System.out.println("\n----------------------------\n"
                    + bus.toString());
            System.out.println("----------------------------");
        }
        else if (choice.equals("2")) {
            // Navigate to the view information menu
            viewBusInfoMenu(bus);
        }
        else if (choice.equals("3")) {
            // Navigate to the edit bus menu
            editBusInfoMenu(bus);
        }
        else if (choice.equals("4")) {
            // Navigate to the stops management menu
            stopsManagementMenu(bus);
        }
        else {
            mainMenu();
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            busManagementMenu(bus);
        }
    }

    /**
     * 1.2.1.2
     * Displays the "View Bus Information" menu. Allows the user to view specific details
     * about the selected bus such as its number, name, route, timings, seat capacity,
     * stops, and route duration.
     *
     * @param bus the Bus object for which information is displayed.
     */
    private static void viewBusInfoMenu(Bus bus) {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "VIEW BUS INFORMATION MENU",
                """
                1. Bus number
                2. Bus name
                3. Route name
                4. Departure time
                5. Arrival time
                6. Seat capacity
                7. Stops
                8. Route duration
                0. Main Menu""");

        // Process user choice
        if (choice.equals("1")) {
            // Display bus number
            System.out.printf("""

                -------------------
                BUS NUMBER: %s
                -------------------
                """, bus.getBusNumber());
        }
        else if (choice.equals("2")) {
            // Display bus name
            System.out.printf("""

                --------------------------
                BUS NAME FOR %d: %s
                --------------------------
                """, bus.getBusNumber(), bus.getBusName());
        }
        else if (choice.equals("3")) {
            // Display route name
            System.out.printf("""

                ------------------------------------------
                ROUTE NUMBER FOR %d: %s
                ------------------------------------------
                """, bus.getBusNumber(), bus.getRouteName());
        }
        else if (choice.equals("4")) {
            // Display departure time
            System.out.printf("""

                ---------------------------------
                DEPARTURE TIME FOR %d: %s
                ---------------------------------
                """, bus.getBusNumber(), bus.getDepartureTime());
        }
        else if (choice.equals("5")) {
            // Display arrival time
            System.out.printf("""

                -------------------------------
                ARRIVAL TIME FOR %d: %s
                -------------------------------
                """, bus.getBusNumber(), bus.getArrivalTime());
        }
        else if (choice.equals("6")) {
            // Display seat capacity
            System.out.printf("""

                -----------------------------
                SEAT CAPACITY FOR %d: %s
                -----------------------------
                """, bus.getBusNumber(), bus.getSeatCapacity());
        }
        else if (choice.equals("7")) {
            // Display stops table
            System.out.printf("""

                -----------------------------------------------------
                ALL STOPS FOR %d:
                
                """, bus.getBusNumber());
            bus.displayAllStops();
            System.out.println("-----------------------------------------------------");
        }
        else if (choice.equals("8")) {
            // Display route duration
            System.out.printf("""

                -----------------------------------------------------
                ROUTE DURATION FOR %d: %s
                -----------------------------------------------------
                """, bus.getBusNumber(), bus.getRouteDuration());
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            viewBusInfoMenu(bus);
        }
    }

    /**
     * 1.2.1.3
     * Displays the "Edit Bus Information" menu. Allows the user to edit various properties
     * of the selected bus, such as its number, name, route, departure/arrival time,
     * seat capacity, and list of stops (loaded from a file).
     *
     * @param bus the Bus object to be edited.
     * @throws FileNotFoundException If the file is not found.
     */
    private static void editBusInfoMenu(Bus bus) throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "6", "7", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "EDIT BUS INFO MENU",
                """
                1. Bus number
                2. Bus name
                3. Route name
                4. Departure time
                5. Arrival time
                6. Seat capacity
                7. Replace stops list from text file
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Prompt the user for the bus number and validate its format
            int bus_number = askAndReturn.busNumber();

            // Proceed only if a valid (non-zero) bus number was entered
            if (bus_number!=0) {

                // Change bus number
                bus.setBusNumber(bus_number);
                System.out.println("""

                        ---------------------
                        Bus number changed.
                        ---------------------""");
                bus.setBusNumber(bus_number);
            }
        }
        else if (choice.equals("2")) {
            // Change bus name
            bus.setBusName(askAndReturn.busName());
            System.out.println("""

                    -----------------
                    Bus name changed.
                    -----------------""");
        }
        else if (choice.equals("3")) {
            // Change route name
            bus.setRouteName(askAndReturn.routeName());
            System.out.println("""

                    -------------------
                    Route name changed.
                    -------------------""");
        }
        else if (choice.equals("4")) {
            // Change departure time
            bus.setDepartureTime(askAndReturn.time("departure"));
            System.out.println("""

                    -----------------------
                    Departure time changed.
                    -----------------------""");
        }
        else if (choice.equals("5")) {
            // Change arrival time
            bus.setArrivalTime(askAndReturn.time("arrival"));
            System.out.println("""

                    ---------------------
                    Arrival time changed.
                    ---------------------""");
        }
        else if (choice.equals("6")) {
            changeSeatCapacityMenu(bus);
        }
        else if (choice.equals("7")) {
            // Change stops
            bus.setStopsAndTimesFromTextFile(askAndReturn.fileName());
            System.out.println("""

                    ----------------------
                    List of stops changed.
                    ----------------------""");
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            editBusInfoMenu(bus);
        }
        else {
            busManagementMenu(bus);
        }
    }

    /**
     * 1.2.1.3.6
     * Displays the "Change Seat Capacity" menu for a selected bus.
     * Allows the user to manually set, increase, or decrease the seat capacity.
     * Ensures capacity does not go below 0.
     *
     * @param bus the Bus object whose seat capacity is being managed.
     * @throws FileNotFoundException If the file is not found.
     */
    private static void changeSeatCapacityMenu(Bus bus) throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "CHANGE SEAT CAPACITY MENU",
                """
                1. Change seat capacity
                2. Increase by 1
                3. Decrease by 1
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Prompt the user for the seat capacity and validate its format
            System.out.println();
            int seat_capacity = askAndReturn.seatCapacity();

            // Change seat capacity
            bus.setSeatCapacity(seat_capacity);
            System.out.println("""

                    ----------------------
                    Seat capacity changed.
                    ----------------------""");
        }
        else if (choice.equals("2")) {
            // Increase seat capacity
            bus.increaseCapacity();
            System.out.println("""

                    ------------------------
                    Seat capacity increased.
                    ------------------------""");
        }
        else if (choice.equals("3")) {
            // Decrease seat capacity
            bus.decreaseCapacity();

            // Check if the resulting seat capacity is greater than 0
            if (bus.getSeatCapacity()>0) {
                // If capacity is still positive, confirm the decrease to the user
                System.out.println("""

                        ------------------------
                        Seat capacity decreased.
                        ------------------------""");
            }
            else  {
                // If capacity is 0 or less, inform the user it can't be decreased further
                System.out.println("""

                        -----------------
                        Seat capacity cannot be decreased.
                        Reason: Current seat capacity is already 0.
                        -----------------""");
            }
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            editBusInfoMenu(bus);
        }

    }

    /**
     * 1.2.1.4
     * Displays the "Stops Management" menu. Enables operations like adding, updating,
     * replacing, or removing stops for a specific bus. Users can also search for stops
     * by index or name, and view all stops.
     *
     * @param bus the Bus object whose stops are being managed.
     * @throws FileNotFoundException If the file is not found.
     */
    private static void stopsManagementMenu(Bus bus) throws FileNotFoundException {

        // Define valid menu choices
        String[] choices = {"1", "2", "3", "4", "5", "6", "7", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "STOPS MANAGEMENT MENU",
                """
                1. Add a new stop
                2. Update stop by index
                3. Replace stops list from text file
                4. Remove a stop
                5. Remove all stops
                6. Search for a stop
                7. View all stops
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            addStopMenu(bus);
        }
        else if (choice.equals("2")) {
            String index = askAndReturn.stopIndexString("Enter stop index (see 'View all stops')");

            if (isValidIndex(index, bus)) {

                String stop_name = askAndReturn.stopName();

                // Prompt for arrival time
                String time = askAndReturn.time("");

                bus.updateStop(Integer.parseInt(index)-1, stop_name, time);


                System.out.println("""

                        ------------------------------
                        Stop was successfully removed.
                        ------------------------------""");
            }
        }
        else if (choice.equals("3")) {
            // Set all stops
            bus.setStopsAndTimesFromTextFile(askAndReturn.fileName());
            System.out.println("""

                    ----------------------
                    List of stops changed.
                    ----------------------""");
        }
        else if (choice.equals("4")) {
            String index = askAndReturn.stopIndexString("Enter stop index (see 'View all stops')");

            if (isValidIndex(index, bus)) {
                if (askAndReturn.isConfirm()) {
                    bus.removeStop(Integer.parseInt(index) - 1);
                    System.out.println("""

                            ------------------------------
                            Stop was successfully removed.
                            ------------------------------""");
                }
                else {
                    System.out.println("""
        
                        --------------------
                        Operation cancelled.
                        --------------------""");
                }
            }
        }
        else if (choice.equals("5")) {
            if (askAndReturn.isConfirm()) {
                bus.clearStops();
                System.out.println("""

                        ----------------------------
                        Stops removed from the list.
                        ----------------------------""");
            } else {
                System.out.println("""
        
                --------------------
                Operation cancelled.
                --------------------""");
            }
        }
        else if (choice.equals("6")) {
            // Call the method to allow the user to search for a stop
            searchStopMenu(bus);
        }
        else if (choice.equals("7")) {
            // Display stops table
            displayStopsTable(bus);
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            stopsManagementMenu(bus);
        }
    }

    /**
     * 1.2.1.4.1
     * Prompts the user to add a new stop to the specified bus.
     * Allows choosing the position (above or below a specific index) where the stop should be inserted.
     *
     * @param bus the Bus object to which a stop will be added.
     */
    private static void addStopMenu(Bus bus) {
        // Prompt for stop name
        String stop_name = askAndReturn.stopName();

        // Prompt for arrival time
        String time = askAndReturn.time("");

        // Ask for index
        String index = askAndReturn.stopIndexString("Enter index where you want to insert the stop near");

        // Validate index input
        if (isValidIndex(index, bus)) {
            int parsedIndex = Integer.parseInt(index);

            // Ask for direction: above or below
            String position = askAndReturn.position();

            if (position.equals("1")) {
                // Insert before (above)
                bus.addStop(parsedIndex-1, stop_name, time);
            } else if (position.equals("2")) {
                // Insert after (below)
                bus.addStop(parsedIndex, stop_name, time);
                parsedIndex++;
            }
            System.out.printf("""

                    -----------------------
                    Stop added to index %d
                    -----------------------
                    """, parsedIndex);
        }
    }

    /**
     * 1.2.1.4.5
     * Displays the "Search Stop" menu. Allows the user to search for a stop either by index or name.
     * If a match is found, displays the stop's details.
     *
     * @param bus the Bus object whose stops are being searched.
     */
    private static void searchStopMenu(Bus bus) {
        // Define valid menu choices
        String[] choices = {"1", "2", "0"};

        // Display the main menu and get user's validated choice
        String choice = displayMenuAndGetUserChoice(choices, "SEARCH STOP MENU",
                """
                1. By index
                2. By name
                0. Return""");

        // Process user choice
        if (choice.equals("1")) {
            // Ask for stop index
            String index = askAndReturn.stopIndexString("Enter index");

            // Validate index input
            if (isValidIndex(index, bus)) {
                int parsedIndex = Integer.parseInt(index)-1;

                // Display stop that match the stop number
                System.out.println("\n-----------------------------------------------");
                bus.displayStop(parsedIndex);
                System.out.println("-----------------------------------------------");
            }
            else {
                System.out.println("""
                        
                        ---------------------------------
                        There are no stop with this number.
                        ---------------------------------""");
            }
        } else if (choice.equals("2")) {
            // Ask for stop name
            String stop_name = askAndReturn.stopName();

            // Validate name input
            if (bus.hasStop(stop_name)) {
                // Display stop that match the stop name
                System.out.println("\n-----------------------------------------------");
                bus.displayStop(stop_name);
                System.out.println("-----------------------------------------------");
            }
            else {
                System.out.println("""
                        
                        ---------------------------------
                        There are no stop with this name.
                        ---------------------------------""");
            }
        }

        // Call the menu again if choice not 0
        if (!choice.equals("0")) {
            searchStopMenu(bus);
        }
    }


    // Display tables

    /**
     * Displays a formatted table of all buses in the bus station.
     */
    private static void displayBusesTable() {
        System.out.println("\n------------------------------------------------");
        busStation.displayAllBuses(busStation.getBuses(), 0, 0, "");
        System.out.println("\n------------------------------------------------");
    }

    /**
     * Displays a formatted table of all stops for a given bus.
     *
     * @param bus the Bus object whose stops are displayed.
     */
    private static void displayStopsTable(Bus bus) {
        System.out.printf("""

                -----------------------------------------------------
                ALL STOPS FOR %d:
                
                """, bus.getBusNumber());
        bus.displayAllStops();
        System.out.println("-----------------------------------------------------");
    }


    // Is valid forms

    /**
     * Checks whether the provided choice exists in the list of valid choices.
     *
     * @param choice the user's choice to validate
     * @param choices an array of valid choice strings
     * @return true if the choice is valid, false otherwise
     */
    private static boolean isValidChoice(String choice, String[] choices) {
        for (String validChoice : choices) {
            if (choice.equals(validChoice)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates whether the provided string consists only of digits and matches a specified length.
     *
     * @param str the string to validate
     * @param length the required exact length
     * @return true if the string is composed of digits and has the specified length, false otherwise
     */
    public static boolean isDigitsWithExactLength(String str, int length) {
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

    /**
     * Validates if the provided stop index is a valid number and falls within the range of stops in the bus route.
     *
     * @param index the index entered by the user as a string
     * @param bus the Bus object containing stop information
     * @return true if the index is numeric and within bounds of the stop list, false otherwise
     */
    private static boolean isValidIndex(String index, Bus bus) {
        for (int i=0; i<index.length(); i++) {
            if (!Character.isDigit(index.charAt(i))) {
                System.out.println("""

                    --------------------------------------------------------------------
                    Invalid input. Please enter a number corresponding to a stop index.
                    --------------------------------------------------------------------""");
                return false;
            }
        }
        return Integer.parseInt(index) >= 0 && Integer.parseInt(index)-1 < bus.getStopCount();
    }
}
