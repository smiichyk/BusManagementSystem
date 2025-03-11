import java.util.ArrayList;
import java.util.Arrays;

public class Bus {

    // Fields
    private int busNumber;
    private String busName;
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private int seatCapacity;
    ArrayList<String> stops;
    ArrayList<String> times;

    // Constructors
    public Bus() {
        this.busNumber=0;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime, int seatCapacity, ArrayList<String> stops, ArrayList<String> times) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.seatCapacity=seatCapacity;
        this.stops=stops;
        this.times=times;
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime, int seatCapacity) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.seatCapacity=seatCapacity;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String routeName, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String departureTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime=departureTime;
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(int busNumber, String busName, int seatCapacity) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=seatCapacity;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(String busName, String routeName) {
        this.busNumber=0;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=new ArrayList<>();
        this.times=new ArrayList<>();
    }
    public Bus(String routeName, int busNumber, ArrayList<String> stops, ArrayList<String> times) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName=routeName;
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=stops;
        this.times=times;
    }
    public Bus(ArrayList<String> stops, ArrayList<String> times) {
        this.busNumber=0;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.seatCapacity=0;
        this.stops=stops;
        this.times=times;
    }

    // Getters
    public int getBusNumber() {
        return busNumber;
    }
    public String getBusName() {
        return busName;
    }
    public String getRouteName() {
        return routeName;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public int getSeatCapacity() {
        return seatCapacity;
    }
    public ArrayList<String> getStops() {
        return stops;
    }
    public ArrayList<String> getTimes() {
        return times;
    }

    // Setters
    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }
    public void setBusName(String busName) {
        this.busName = busName;
    }
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setSeatCapacity(int capacity) {
        this.seatCapacity = capacity;
    }
    public void setStops(ArrayList<String> stops) {
        this.stops = stops;
    }
    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    // Methods
    public void addStop(String stop_name, String time) {

    }
    public void addMultipleStops( String[] stops, String[] time) {

    }
    public void removeStop(String stop_name) {

    }
    public void removeStopAtIndex(int index) {

    }
    public void clearStops() {

    }
    public void getStopCount() {

    }
    public void updateStop(int index, String new_stop, String new_time) {

    }
    public void hasStop(String stop_name) {

    }
    public void displayRoute() {

    }
    public void getRouteDuration() {

    }
    public void increaseCapacity(int seats) {

    }
    public void decreaseCapacity(int seats) {

    }
    public String toString() {
        return "Bus: {busNumber: "+this.busNumber+"; busName: "+this.busName+"; routeName: "+this.routeName+
                "; departureTime: "+this.departureTime+"; arrivalTime: "+this.arrivalTime+
                "; seatCapacity: "+this.seatCapacity+"; stops: "+this.stops+
                "; times: "+this.times+ "}";
    }
}
