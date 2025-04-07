import java.util.ArrayList;
import java.util.Arrays;

public class DundalkBusStation {

    /**
     * Creates and returns a BusStation object for Dundalk, preloaded with available bus routes.
     *
     * @return a fully initialized BusStation for Dundalk containing several bus routes.
     */
    public static BusStation getBusStation() {
        // Create a new BusStation object for Dundalk
        BusStation busStation = new BusStation("Dundalk Bus Station", "Dundalk");

        // Add various bus routes to the Dundalk Bus Station
        busStation.addBus(getRoute100_314645());
        busStation.addBus(getRoute100_314682());
        busStation.addBus(getRoute100_314569());
        busStation.addBus(getRoute100X_314654());

        // Return the fully initialised bus station object
        return busStation;
    }

    /**
     * Returns the list of bus stops for the 100 route from Dundalk to Drogheda.
     *
     * @return an ArrayList of stop names on the 100 route.
     */
    private static ArrayList<String> getRoute100Stops() {
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

    /**
     * Returns a Bus object representing route 100 (number: 314682).
     *
     * @return a Bus with departure time 06:15 and arrival time 07:06.
     */
    private static Bus getRoute100_314682() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "06:15", "06:17", "06:19", "06:20", "06:23", "06:24", "06:30", "06:31", "06:32", "06:35",
                "06:39", "06:40", "06:43", "06:45", "06:49", "06:49", "06:50", "06:56", "07:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314682, "100", "Dundalk-Drogheda", "06:15",
                "07:06", 55, getRoute100Stops(), times);
    }

    /**
     * Returns a Bus object representing route 100 (number: 314645).
     *
     * @return a Bus with departure time 07:15 and arrival time 08:06.
     */
    private static Bus getRoute100_314645() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "07:15", "07:17", "07:19", "07:20", "07:23", "07:24", "07:30", "07:31", "07:32", "07:35",
                "07:39", "07:40", "07:43", "07:45", "07:49", "07:49", "07:50", "07:56", "08:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314645, "100", "Dundalk-Drogheda", "07:15",
                "08:06", 55, getRoute100Stops(), times);
    }

    /**
     * Returns a Bus object representing route 100 (number: 314645).
     *
     * @return a Bus with departure time 08:15 and arrival time 09:06.
     */
    private static Bus getRoute100_314569() {

        // Define the departure times corresponding to each stop
        ArrayList<String> times = new ArrayList<>(Arrays.asList(
                "08:15", "08:17", "08:19", "08:20", "08:23", "08:24", "08:30", "08:31", "08:32", "08:35",
                "08:39", "08:40", "08:43", "08:45", "08:49", "08:49", "08:50", "08:56", "09:06"
        ));

        // Return a new Bus object with route details
        return new Bus(314569, "100", "Dundalk-Drogheda", "08:15",
                "09:06", 48, getRoute100Stops(), times);
    }

    /**
     * Returns a Bus object representing route 100X (ID: 314654).
     *
     * @return a Bus with departure time 06:30 and arrival time 08:20.
     */
    private static Bus getRoute100X_314654() {

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
}
