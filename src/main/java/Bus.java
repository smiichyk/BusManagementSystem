import java.util.ArrayList;

public class Bus implements Comparable<Bus> {

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
        stops.add(stop_name);
        times.add(time);
    }
    public void addStop(int index, String stop_name, String time) {
        stops.add(index, stop_name);
        times.add(index, time);
    }
    public void addMultipleStops(ArrayList<String> stops, ArrayList<String> times) {
        this.stops.addAll(stops);
        this.times.addAll(times);
    }
    public void removeStop(String stop_name) {
        for (String stop : stops) {
            if (stop.equals(stop_name)) {
                stops.remove(stop);
                times.remove(stop);
            }
        }
    }
    public void removeStop(int index) {
        stops.remove(index);
        times.remove(index);
    }
    public void clearStops() {
        stops.clear();
        times.clear();
    }
    public int getStopCount() {
        return stops.size();
    }
    public void updateStop(int index, String new_stop, String new_time) {
        stops.set(index, new_stop);
        times.set(index, new_time);
    }
    public boolean hasStop(String stop_name) {
        for (String stop : stops) {
            if (stop.equals(stop_name)) {
                return true;
            }
        }
        return false;
    }
    public void displayRoute() {
        for (int i=0; i<stops.size(); i++) {
            System.out.printf("%-15s  %-15s %n", "Stop", "Time");
            System.out.printf("%-15s  %-15s %n", stops.get(i), times.get(i));
        }
    }
    public String getRouteDuration() {
        int departureTimeInMinutes = (Integer.parseInt(departureTime.split(":")[0])*60)
                + Integer.parseInt(departureTime.split(":")[1]);
        int arrivalTimeInMinutes = (Integer.parseInt(arrivalTime.split(":")[0])*60)
                + Integer.parseInt(arrivalTime.split(":")[1]);
        int differenceInMinutes = arrivalTimeInMinutes - departureTimeInMinutes;
        int difference = 0;
        while (differenceInMinutes>=60) {
            differenceInMinutes -=60;
            difference++;
        }
        return difference+" hour(s) and "+differenceInMinutes+" minute(s)";
    }
    public void increaseCapacity(int seats) {
        seatCapacity++;
    }
    public void decreaseCapacity(int seats) {
        if (seatCapacity>0) {
            seatCapacity--;
        }
    }
    public String toString() {
        return "Bus: {busNumber: "+this.busNumber+"; busName: "+this.busName+"; routeName: "+this.routeName+
                "; departureTime: "+this.departureTime+"; arrivalTime: "+this.arrivalTime+
                "; seatCapacity: "+this.seatCapacity+"; stops: "+this.stops.size()+
                "; times: "+this.times.size()+ "}\n";
    }
    public int compareTo(Bus other) {
        if (this.busNumber > other.busNumber) {
            return 1;
        } else if (this.busNumber < other.busNumber) {
            return -1;
        } else {
            return 0;
        }
    }
}
