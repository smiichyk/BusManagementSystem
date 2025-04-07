import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    /**
     * Adds a stop and its corresponding time at the specified index.
     *
     * @param index The index at which the stop and time should be added.
     * @param stop_name The name of the stop to be added.
     * @param time The time associated with the stop.
     */
    public void addStop(int index, String stop_name, String time) {
        stops.add(index, stop_name);
        times.add(index, time);
    }

    /**
     * Removes the stop and its corresponding time at the specified index.
     *
     * @param index The index of the stop and time to remove.
     */
    public void removeStop(int index) {
        stops.remove(index);
        times.remove(index);
    }

    /**
     * Reads stop names from a text file. Each line is expected to contain a stop name and time separated by a comma.
     *
     * @param fileLink The path to the text file containing stop data.
     * @return A list of stop names.
     * @throws FileNotFoundException If the file is not found.
     */
    public ArrayList<String> getStopsFromTextFile(String fileLink) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileLink));
        ArrayList<String> stops = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            stops.add(data.substring(0, data.indexOf(",")));
        }

        return stops;
    }

    /**
     * Reads stop times from a text file. Each line is expected to contain a stop name and time separated by a comma.
     *
     * @param fileLink The path to the text file containing stop data.
     * @return A list of stop times.
     * @throws FileNotFoundException If the file is not found.
     */
    public ArrayList<String> getTimesFromTextFile(String fileLink) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileLink));
        ArrayList<String> times = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            times.add(data.substring(data.indexOf(",")+1));
        }

        return times;
    }


    /**
     * Populates the internal lists of stops and times from a text file.
     * Each line in the file should contain a stop and time separated by a comma.
     *
     * @param fileLink The path to the text file.
     * @throws FileNotFoundException If the file is not found.
     */
    public void setStopsAndTimesFromTextFile(String fileLink) throws FileNotFoundException {
        this.stops = getStopsFromTextFile(fileLink);
        this.times = getTimesFromTextFile(fileLink);
    }

    /**
     * Clears all stored stops and their corresponding times.
     */
    public void clearStops() {
        stops.clear();
        times.clear();
    }

    /**
     * Returns the number of stops currently stored.
     *
     * @return The total number of stops.
     */
    public int getStopCount() {
        return stops.size();
    }

    /**
     * Updates the stop and time at the specified index.
     *
     * @param index The index of the stop to update.
     * @param new_stop The new stop name.
     * @param new_time The new stop time.
     */
    public void updateStop(int index, String new_stop, String new_time) {
        stops.set(index, new_stop);
        times.set(index, new_time);
    }

    /**
     * Checks if the route contains a stop with the specified name.
     *
     * @param stop_name The name of the stop to search for.
     * @return true if a matching stop is found; false otherwise.
     */
    public boolean hasStop(String stop_name) {
        // Check if the current stop contains the given stop_name (case-insensitive)
        for (String stop : stops) {
            if (stop.toLowerCase().contains(stop_name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays information for the stop at the specified index.
     *
     * @param index The index of the stop to display.
     */
    public void displayStop(int index) {
        System.out.printf("%-7s %-7s  %s %n", "#", "Time", "Stop");
        for (int i = 0; i < getStopCount(); i++) {
            if (i==index) {
                if (i > 8) {
                    System.out.printf("%-7d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                } else {
                    System.out.printf("0%-6d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                }
            }
        }
    }

    /**
     * Displays information for all stops that match the given name.
     *
     * @param name The name or part of the stop name to search for.
     */
    public void displayStop(String name) {
        System.out.printf("%-7s %-7s  %s %n", "#", "Time", "Stop");
        for (int i = 0; i < getStopCount(); i++) {
            if (stops.get(i).toLowerCase().contains(name.toLowerCase())) {
                if (i > 8) {
                    System.out.printf("%-7d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                } else {
                    System.out.printf("0%-6d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                }
            }
        }
    }

    /**
     * Displays all stops with their corresponding times in a formatted table.
     * If there are no stops, it prints a message indicating that.
     */
    public void displayAllStops() {
        if (getStopCount()!=0) {
            // Print the header of the table with column names aligned
            System.out.printf("%-7s %-7s  %s %n", "#", "Time", "Stop");
            for (int i = 0; i < getStopCount(); i++) {
                if (i > 8) {
                    System.out.printf("%-7d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                } else {
                    System.out.printf("0%-6d %-7s  %s %n", (i + 1), times.get(i), stops.get(i));
                }
            }
        } else {
            System.out.println("There are no stops!");
        }
    }

    /**
     * Calculates and returns the duration of the route in hours and minutes,
     * based on the departure and arrival times in "HH:mm" format.
     *
     * @return A string representing the route duration, e.g., "1 hour(s) and 30 minute(s)".
     */
    public String getRouteDuration() {
        // Convert departure time from "HH:mm" format to total minutes since midnight
        int departureTimeInMinutes = (Integer.parseInt(departureTime.split(":")[0])*60)
                + Integer.parseInt(departureTime.split(":")[1]);

        // Convert arrival time from "HH:mm" format to total minutes since midnight
        int arrivalTimeInMinutes = (Integer.parseInt(arrivalTime.split(":")[0])*60)
                + Integer.parseInt(arrivalTime.split(":")[1]);

        // Calculate the difference in minutes between arrival and departure times
        int minutes = arrivalTimeInMinutes - departureTimeInMinutes;

        // Initialize hours variable (this will store the hours of the time difference)
        int hours = 0;

        // Loop to convert minutes to hours and remaining minutes
        while (minutes>=60) {
            minutes -=60;
            hours++;
        }

        // Return the result in the format "X hour(s) and Y minute(s)"
        return hours+" hour(s) and "+minutes+" minute(s)";
    }


    /**
     * Increases the bus's seat capacity by one.
     */
    public void increaseCapacity() {
        seatCapacity++;
    }

    /**
     * Decreases the bus's seat capacity by one, ensuring it does not go below zero.
     */
    public void decreaseCapacity() {
        if (seatCapacity>0) {
            seatCapacity--;
        }
    }

    /**
     * Returns a string representation of the bus object, including its number,
     * name, route name, departure and arrival times, seat capacity, and stop count.
     *
     * @return A formatted string with the bus information.
     */
    @Override
    public String toString() {
        return "BUS INFORMATION:\n" +
                "\nBus number: "+this.busNumber+"\nBus name: "+this.busName+"\nRoute name: "+this.routeName+
                "\nDeparture time: "+this.departureTime+"\nArrival time: "+this.arrivalTime+
                "\nSeat capacity: "+this.seatCapacity+"\nStops: "+getStopCount();
    }


    /**
     * Compares this bus with another based on their bus numbers.
     *
     * @param other The other Bus object to compare against.
     * @return 1 if this bus number is greater, -1 if less, 0 if equal.
     */
    public int compareTo(Bus other) {
        if (this.busNumber > other.busNumber) {
            return 1;
        }
        else if (this.busNumber < other.busNumber) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
