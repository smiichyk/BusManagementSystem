import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusStation {

    // Fields:

    private String stationName;
    private String location;
    private ArrayList<Bus> buses;

    // Constructors:

    public BusStation() {
        this.stationName="none";
        this.location="none";
        this.buses=new ArrayList<>();
    }
    public BusStation(String stationName, String location, ArrayList<Bus> buses) {
        this.stationName=stationName;
        this.location=location;
        this.buses=buses;
    }
    public BusStation(String stationName, ArrayList<Bus> buses) {
        this.stationName=stationName;
        this.location="none";
        this.buses=buses;
    }
    public BusStation(String stationName, String location) {
        this.stationName=stationName;
        this.location=location;
        this.buses=new ArrayList<>();
    }
    public BusStation(String stationName) {
        this.stationName=stationName;
        this.location="none";
        this.buses=new ArrayList<>();
    }
    public BusStation(ArrayList<Bus> buses) {
        this.stationName="none";
        this.location="none";
        this.buses=buses;
    }

    // Getters:

    /**
     * Gets the name of the station.
     * @return The name of the station.
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Gets the location of the station.
     * @return The location of the station.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the list of buses at the station.
     * @return The list of buses.
     */
    public ArrayList<Bus> getBuses() {
        return buses;
    }

    // Setters:

    /**
     * Sets the name of the station.
     * @param stationName The name of the station to set.
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Sets the location of the station.
     * @param location The location of the station to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the list of buses at the station.
     * @param buses The list of buses to set.
     */
    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    // Methods:

    /**
     * Adds a bus to the station's bus list.
     * @param bus The bus to be added.
     */
    public void addBus(Bus bus) {
        buses.add(bus);
    }

    /**
     * Removes a bus from the station's bus list by its bus number.
     * @param bus_number The bus number of the bus to be removed.
     */
    public void removeBus(int bus_number) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                buses.add(bus);
            }
        }
        this.buses.removeAll(buses);
    }

    /**
     * Removes a bus from the station's bus list by its bus name.
     * @param bus_name The name of the bus to be removed.
     */
    public void removeBus(String bus_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                buses.add(bus);
            }
        }
        this.buses.removeAll(buses);
    }

    /**
     * Checks if a bus is present in the station's bus list by its bus number.
     * @param bus_number The bus number to search for.
     * @return true if the bus exists, false otherwise.
     */
    public boolean isBusInBusesByNumber(int bus_number) {
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a bus is present in the station's bus list by its bus name.
     * @param bus_name The bus name to search for.
     * @return true if the bus exists, false otherwise.
     */
    public boolean isBusInBusesByName(String bus_name) {
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a bus is present in the station's bus list by its route name.
     * @param route_name The route name to search for.
     * @return true if the bus exists, false otherwise.
     */
    public boolean isBusInBusesByRoute(String route_name) {
        for (Bus bus : this.buses) {
            if (bus.getRouteName().equals(route_name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a list of buses by their bus number.
     * @param bus_number The bus number to search for.
     * @return A list of buses that match the bus number.
     */
    public ArrayList<Bus> busByNumber(int bus_number) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                buses.add(bus);
            }
        }
        return buses;
    }

    /**
     * Retrieves a list of buses by their bus name.
     * @param bus_name The bus name to search for.
     * @return A list of buses that match the bus name.
     */
    public ArrayList<Bus> busesByName(String bus_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                buses.add(bus);
            }
        }
        return buses;
    }

    /**
     * Retrieves a list of buses by their route name.
     * @param route_name The route name to search for.
     * @return A list of buses that match the route name.
     */
    public ArrayList<Bus> busesByRoute(String route_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getRouteName().equals(route_name)) {
                buses.add(bus);
            }
        }
        return buses;
    }

    /**
     * Displays all buses at the station based on a search type (bus number, bus name, or route).
     * @param buses The list of buses to display.
     * @param type The type of search (0 for all buses, 1 for bus number, 2 for bus name, 3 for route).
     * @param searchByInt The integer parameter used for search (bus number).
     * @param searchByString The string parameter used for search (bus name or route).
     */
    public void displayAllBuses(ArrayList<Bus> buses, int type, int searchByInt, String searchByString) {
        this.sortBuses();
        if (type==0) {
            System.out.println("\nBUSES CURRENTLY IN " + stationName + ": " + buses.size());
            if (!buses.isEmpty()) {
                System.out.printf("%n %-15s %-15s %-15s", "Bus Number", "Bus Name", "Departure Time");
                for (Bus bus : buses) {
                    System.out.printf("%n %-15d %-15s %-15s", bus.getBusNumber(), bus.getBusName(), bus.getDepartureTime());
                }
            }
        } else if (type == 1) {
            if (isBusInBusesByNumber(searchByInt)) {
                System.out.println("\nALL BUSES BY BUS NUMBER: ");
                System.out.printf("%n %-15s %-15s %-15s", "Bus Number", "Bus Name", "Departure Time");
                for (Bus bus : buses) {
                    if (bus.getBusNumber() == searchByInt) {
                        System.out.printf("%n %-15d %-15s %-15s", bus.getBusNumber(), bus.getBusName(), bus.getDepartureTime());
                    }
                }
            } else {
                System.out.print("\nThere are no buses with bus number: "+searchByInt+".");
            }
        } else if (type == 2) {
            if (isBusInBusesByName(searchByString)) {
                System.out.println("\nALL BUSES BY BUS NAME: ");
                System.out.printf("%n %-15s %-15s %-15s", "Bus Number", "Bus Name", "Departure Time");
                for (Bus bus : buses) {
                    if (bus.getBusName().equals(searchByString)) {
                        System.out.printf("%n %-15d %-15s %-15s", bus.getBusNumber(), bus.getBusName(), bus.getDepartureTime());
                    }
                }
            } else {
                System.out.print("\nThere are no buses with bus name: "+searchByString+".");
            }
        } else {
            if (isBusInBusesByRoute(searchByString)) {
                System.out.println("\nALL BUSES BY ROUTE NAME: ");
                System.out.printf("%n %-15s %-15s %-15s", "Bus Number", "Bus Name", "Departure Time");
                for (Bus bus : buses) {
                    if (bus.getRouteName().equals(searchByString)) {
                        System.out.printf("%n %-15d %-15s %-15s", bus.getBusNumber(), bus.getBusName(), bus.getDepartureTime());
                    }
                }
            } else {
                System.out.print("\nThere are no buses with route name: "+searchByString+".");
            }
        }
    }

    /**
     * Loads buses from a text file.
     * @param fileLink The path to the file to load buses from.
     * @return A list of buses loaded from the file.
     * @throws FileNotFoundException If the file is not found.
     */
    public ArrayList<Bus> loadBusesFromTextFile(String fileLink) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileLink));
        String data = "";
        ArrayList<Bus> buses = new ArrayList<>();

        while (scanner.hasNext()) {
            data += scanner.nextLine();
        }

        int index = data.indexOf("{");
        while (index != -1) {
            int start = index + 1;

            int comma1 = data.indexOf(",", start);
            String bus_number = removeSpacesAndQuotes(data.substring(start, comma1), 0);

            int comma2 = data.indexOf(",", comma1 + 1);
            String bus_name = removeSpacesAndQuotes(data.substring(comma1 + 1, comma2), 0);

            int comma3 = data.indexOf(",", comma2 + 1);
            String route_name = removeSpacesAndQuotes(data.substring(comma2 + 1, comma3), 0);

            int comma4 = data.indexOf(",", comma3 + 1);
            String departure_time = removeSpacesAndQuotes(data.substring(comma3 + 1, comma4), 0);

            int comma5 = data.indexOf(",", comma4 + 1);
            String arrival_time = removeSpacesAndQuotes(data.substring(comma4 + 1, comma5), 0);

            int comma6 = data.indexOf(",", comma5 + 1);
            String seat_capacity = removeSpacesAndQuotes(data.substring(comma5 + 1, comma6), 0);

            int comma7 = data.indexOf("]", comma6 + 1);
            String[] stopsStr = removeSpacesAndQuotes(data.substring(comma6 + 1, comma7), 1).split(",");
            ArrayList<String> stops = new ArrayList<>();
            for (String time : stopsStr) {
                stops.add(time);
            }

            int comma8 = data.indexOf("]", comma7 + 1);
            String[] timesStr = removeSpacesAndQuotes(data.substring(comma7 + 2, comma8), 0).split(",");
            ArrayList<String> times = new ArrayList<>();
            for (String time : timesStr) {
                times.add(time);
            }

            index = data.indexOf("{", comma8);

            Bus bus = new Bus(Integer.parseInt(bus_number), bus_name, route_name, departure_time, arrival_time,
                    Integer.parseInt(seat_capacity), stops, times);
            buses.add(bus);
        }
        return buses;
    }

    /**
     * Removes spaces and quotes from a given string.
     * @param string The string to be processed.
     * @param type The type of removal operation (0 for a general, 1 for stops/times).
     * @return The cleaned string.
     */
    public String removeSpacesAndQuotes(String string, int type) {
        if (type == 1) {
            return string.replace("\"", "").replace("[", "").
                    replace("[", "");
        }
        return string.replace(" ", "").replace("\"", "")
                .replace("[", "").replace("[", "");
    }

    /**
     * Adds buses to the station's bus list from a text file.
     * @param fileName The name of the text file to load buses from.
     * @throws FileNotFoundException If the file is not found.
     */
    public void addBusesFromTextFile(String fileName) throws FileNotFoundException {
        this.buses.addAll(loadBusesFromTextFile(fileName));
    }

    /**
     * Replaces the current buses with buses loaded from a text file.
     * @param fileName The name of the text file to load buses from.
     * @throws FileNotFoundException If the file is not found.
     */
    public void replaceBusesFromTextFile(String fileName) throws FileNotFoundException {
        this.buses = loadBusesFromTextFile(fileName);
    }

    /**
     * Returns a string representation of the bus station.
     * @return A string representing the bus station information.
     */
    public String toString() {
        return "BUS STATION INFORMATION:\nStation Name: "+this.stationName+"\nLocation: "+this.location+"\nBuses: "+this.buses.size();
    }

    /**
     * Sorts the buses in ascending order.
     */
    public void sortBuses() {
        Collections.sort(this.buses);
    }
}
