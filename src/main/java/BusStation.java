public class BusStation {

    // Fields
    private String stationName;
    private String location;
    private Bus[] buses;

    // Constructors
    public BusStation() {
        this.stationName="";
        this.location="";
        this.buses=new Bus[0];
    }
    public BusStation(String stationName, String location, Bus[] buses) {
        this.stationName=stationName;
        this.location=location;
        this.buses=buses;
    }
    public BusStation(String stationName, Bus[] buses) {
        this.stationName=stationName;
        this.location="";
        this.buses=buses;
    }
    public BusStation(String stationName, String location) {
        this.stationName=stationName;
        this.location=location;
        this.buses=new Bus[0];
    }
    public BusStation(String stationName) {
        this.stationName=stationName;
        this.location="";
        this.buses=new Bus[0];
    }
    public BusStation(Bus[] buses) {
        this.stationName="";
        this.location="";
        this.buses=buses;
    }

    // Getters


    // Setters

}
