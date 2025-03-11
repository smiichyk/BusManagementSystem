import java.util.ArrayList;
import java.util.Arrays;

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

    }
    public void removeBus(int bus_number) {

    }
    public void findBusByBusNumber(int bus_number) {

    }
    public void findBusByBusName(String bus_name) {

    }
    public void findBusesByRoute(String route_name) {

    }
    public void getBusDetails(int bus_number) {

    }
    public void getAllBuses() {

    }

    public String toString() {
        return "BusStation: {stationName: "+this.stationName+"; location: "+this.location+"; buses: "+this.buses+"}";
    }
}
