package challenges.Flights;

import java.util.HashSet;
import java.util.Set;

public class FlightDatabase {

    private Set<Flight> flightSet = new HashSet<>();

    public FlightDatabase() {
        flightSet.add(new Flight("WARSZAWA", "KRAKOW"));
        flightSet.add(new Flight("WARSZAWA", "POZNAN"));
        flightSet.add(new Flight("WARSZAWA", "WROCLAW"));
        flightSet.add(new Flight("WROCLAW", "POZNAN"));
        flightSet.add(new Flight("POZNAN", "KRAKOW"));
        flightSet.add(new Flight("SZCZECIN", "WARSZAWA"));
        flightSet.add(new Flight("KRAKOW", "SZCZECIN"));
        flightSet.add(new Flight("SZCZECIN", "POZNAN"));
    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }
}