import java.util.Scanner;

public class askAndReturn {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to make a selection by displaying a message and then
     * captures their input from the console.
     *
     * @return The user's choice as a string, which is the input entered by the user.
     */
    public static String choice() {
        System.out.print("\nYour choice: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a station name.
     *
     * @return the entered station name as a String
     */
    public static String stationName() {
        System.out.print("\nEnter station name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a location.
     *
     * @return the entered location as a String
     */
    public static String location() {
        System.out.print("\nEnter location: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a file name.
     *
     * @return the entered file name as a String
     */
    public static String fileName() {
        System.out.print("\nEnter the file name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a bus number and validates it against the required format.
     *
     * @return a valid bus number as an integer, or 0 if the user wants to return
     */
    public static int busNumber() {
        while (true) {
            System.out.print("\nEnter bus number (0 to return): ");
            String bus_number = scanner.nextLine();

            if (!bus_number.equals("0")) {
                if (MainMenu.isDigitsWithExactLength(bus_number, MainMenu.busNumberLength)) {
                    return Integer.parseInt(bus_number);
                }

                System.out.printf("""

                        --------------------------------------
                        Invalid bus number! Must be %d digits.
                        --------------------------------------
                        """, MainMenu.busNumberLength);
            } else {
                return 0;
            }
        }
    }

    /**
     * Prompts the user to enter a bus name.
     *
     * @return the entered bus name as a String
     */
    public static String busName() {
        System.out.print("\nEnter bus name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a route name.
     *
     * @return the entered route name as a String
     */
    public static String routeName() {
        System.out.print("\nEnter route name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a seat capacity and validates it.
     * The valid range is from 0 to 85.
     *
     * @return a valid seat capacity as an integer
     */
    public static int seatCapacity() {
        while (true) {
            boolean isValidFormat = true;

            System.out.print("\nEnter seat capacity: ");
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

                int parsedSeatCapacity = Integer.parseInt(seatCapacityString);

                // Valid range check
                if (parsedSeatCapacity > 85) {
                    System.out.print("""
        
                        ------------------------------------------------
                        Invalid seat capacity! Must be between 0 and 85.
                        ------------------------------------------------
        
                        """);
                }
                else {
                    // Convert the valid seat capacity string to an integer and return
                    return Integer.parseInt(seatCapacityString);
                }
            }

            System.out.print("""

                -------------------------------------------------------
                Invalid seat capacity! Must be digits between 0 and 85.
                -------------------------------------------------------

                """);
        }
    }

    /**
     * Prompts the user to enter a time in hh:mm format and validates it.
     *
     * @param timeType a label for the type of time (e.g. "departure", "arrival", or "")
     * @return the entered time as a valid String in hh:mm format
     */
    public static String time(String timeType) {
        while (true) {
            boolean validFormat = true;

            System.out.printf("\nEnter %s time (hh:mm): ", timeType);
            String time = scanner.nextLine();

            if (time.length() != 5 || time.charAt(2) != ':') {
                validFormat = false;
            }
            else {
                for (int i = 0; i < time.length(); i++) {
                    if (i != 2 && !Character.isDigit(time.charAt(i))) {
                        validFormat = false;
                    }
                    else {
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
                """, timeType);
        }
    }

    /**
     * Prompts the user to enter a stop name.
     *
     * @return the entered stop name as a String
     */
    public static String stopName() {
        System.out.print("\nEnter stop name: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a stop index with a custom message.
     *
     * @param message the custom message to display
     * @return the entered stop index as a String
     */
    public static String stopIndexString(String message) {
        System.out.print("\n"+message+": ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to choose the position (above or below) where a new stop
     * should be added relative to a given index.
     *
     * @return A string representing the user's choice: "1" for above, "2" for below.
     */
    public static String position() {
        System.out.print("Add (1) above or (2) below this index? ");
        return scanner.nextLine();
    }

    /**
     * Asks the user to confirm an operation.
     *
     * @return true if user confirms with "yes", false otherwise
     */
    public static boolean isConfirm() {
        System.out.print("\nAre you sure? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}
