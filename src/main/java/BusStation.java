import java.util.ArrayList;

public class BusStation {

    // Fields
    private String stationName;
    private String location;
    private ArrayList<Bus> buses;

    // Constructors
    public BusStation() {
        this.stationName="";
        this.location="";
        this.buses=new ArrayList<>();
    }
    public BusStation(String stationName, String location, ArrayList<Bus> buses) {
        this.stationName=stationName;
        this.location=location;
        this.buses=buses;
    }
    public BusStation(String stationName, ArrayList<Bus> buses) {
        this.stationName=stationName;
        this.location="";
        this.buses=buses;
    }
    public BusStation(String stationName, String location) {
        this.stationName=stationName;
        this.location=location;
        this.buses=new ArrayList<>();
    }
    public BusStation(String stationName) {
        this.stationName=stationName;
        this.location="";
        this.buses=new ArrayList<>();
    }
    public BusStation(ArrayList<Bus> buses) {
        this.stationName="";
        this.location="";
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
        for (Bus bus : this.buses) {
            if (bus.getBusNumber()==bus_number) {
                this.buses.remove(bus);
            }
        }
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
    public String getBusDetails(int bus_number) {
        for (Bus bus : buses) {
            if (bus.getBusNumber() == bus_number) {
                return bus.toString();
            }
        }
        return "Bus not found";
    }
    public void displayAllBuses(ArrayList<Bus> buses, int type, int searchByInt, String searchByString) {
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
    public void loadBusesFromTextFile(String fileName) {

    }
    public void replaceBusListFromTextFile(String fileName) {

    }

    public String toString() {
        return "BUS STATION INFORMATION:\nStation Name: "+this.stationName+"\nLocation: "+this.location+"\nBuses: "+this.buses.size();
    }
}
