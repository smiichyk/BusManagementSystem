public class Bus {

    // Fields
    private int busNumber;
    private String busName;
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private int capacity;
    private String[] stops;

    // Constructors
    public Bus() {
        this.busNumber=0;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime, int capacity, String[] stops) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.capacity=capacity;
        this.stops=stops;
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime, int capacity) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.capacity=capacity;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String busName, String routeName, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String routeName, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName=routeName;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String departureTime, String arrivalTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String departureTime) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime=departureTime;
        this.arrivalTime="";
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(int busNumber, String busName, int capacity) {
        this.busNumber=busNumber;
        this.busName=busName;
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=capacity;
        this.stops=new String[0];
    }
    public Bus(String busName, String routeName) {
        this.busNumber=0;
        this.busName=busName;
        this.routeName=routeName;
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=0;
        this.stops=new String[0];
    }
    public Bus(String routeName, int busNumber, String[] stops) {
        this.busNumber=busNumber;
        this.busName="";
        this.routeName=routeName;
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=0;
        this.stops=stops;
    }
    public Bus(String[] stops) {
        this.busNumber=0;
        this.busName="";
        this.routeName="";
        this.departureTime="";
        this.arrivalTime="";
        this.capacity=0;
        this.stops=stops;
    }

    // Getters


    // Setters

}
