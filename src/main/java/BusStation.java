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

    }
    public void findBusByBusNumber(int bus_number) {

    }
    public void findBusByBusName(String bus_name) {

    }
    public void findBusesByRoute(String route_name) {

    }
    public String getBusDetails(int bus_number) {
        for (Bus bus : buses) {
            if (bus.getBusNumber() == bus_number) {
                return bus.toString();
            }
        }
        return "Bus not found";
    }
    public void displayAllBuses() {
        System.out.println("BUSES CURRENTLY IN " + stationName+":"+"\n" +
                "Bus Number\tBus Name");
        for (Bus bus : this.buses) {
            System.out.println(bus.getBusNumber()+"\t\t"+bus.getBusName());
        }
    }
    public void displayAllBuses(String route) {
        for (Bus bus : this.buses) {
            if (bus.getRouteName().equals(route)) {
                System.out.println(bus.getBusNumber() + ": " + bus.getBusName());
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
