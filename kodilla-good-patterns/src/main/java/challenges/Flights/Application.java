package challenges.Flights;

public class Application {

    public static void main(String[] args) {

        FlightFinderFrom flightFinderFrom = new FlightFinderFrom();
        flightFinderFrom.findFlightFrom("WARSZAWA");

        FlightFinderTo flightFinderTo = new FlightFinderTo();
        flightFinderTo.findFlightTo("POZNAN");

        FlightFinderVia flightFinderVia = new FlightFinderVia();
        flightFinderVia.findFlightVia("WARSZAWA", "POZNAN");

    }
}