import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusStation {

    // Fields
    private String stationName;
    private String location;
    private ArrayList<Bus> buses;

    // Constructors
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

    // Getters
    public String getStationName() {
        return stationName;
    }
    public String getLocation() {
        return location;
    }
    public ArrayList<Bus> getBuses() {
        return buses;
    }

    // Setters
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    // Methods
    public void addBus(Bus bus) {
        buses.add(bus);
    }
    public void removeBus(int bus_number) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                buses.add(bus);
            }
        }
        this.buses.removeAll(buses);
    }
    public void removeBus(String bus_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                buses.add(bus);
            }
        }
        this.buses.removeAll(buses);
    }
    public boolean isBusInBusesByNumber(int bus_number) {
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                return true;
            }
        }
        return false;
    }
    public boolean isBusInBusesByName(String bus_name) {
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                return true;
            }
        }
        return false;
    }
    public boolean isBusInBusesByRoute(String route_name) {
        for (Bus bus : this.buses) {
            if (bus.getRouteName().equals(route_name)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Bus> busByNumber(int bus_number) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                buses.add(bus);
            }
        }
        return buses;
    }
    public ArrayList<Bus> busesByName(String bus_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getBusName().equals(bus_name)) {
                buses.add(bus);
            }
        }
        return buses;
    }
    public ArrayList<Bus> busesByRoute(String route_name) {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Bus bus : this.buses) {
            if (bus.getRouteName().equals(route_name)) {
                buses.add(bus);
            }
        }
        return buses;
    }
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
    public String removeSpacesAndQuotes(String string, int type) {
        if (type == 1) {
            return string.replace("\"", "").replace("[", "").
                    replace("[", "");
        }
        return string.replace(" ", "").replace("\"", "")
                .replace("[", "").replace("[", "");
    }
    public void addBusesFromTextFile(String fileName) throws FileNotFoundException {
        this.buses.addAll(loadBusesFromTextFile(fileName));
    }
    public void replaceBusesFromTextFile(String fileName) throws FileNotFoundException {
        this.buses = loadBusesFromTextFile(fileName);
    }
    public String toString() {
        return "BUS STATION INFORMATION:\nStation Name: "+this.stationName+"\nLocation: "+this.location+"\nBuses: "+this.buses.size();
    }
    public void sortBuses() {
        Collections.sort(this.buses);
    }
}
