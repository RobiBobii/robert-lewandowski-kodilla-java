package challenges.Flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinderFrom {

    private final FlightDatabase flightDatabase = new FlightDatabase();

    public void findFlightFrom(String airport) {

        List<Flight> resultList = flightDatabase.getFlightSet().stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .collect(Collectors.toList());

        if(resultList.size()>0) {
            System.out.println("List of flights from " + airport + ":");
            for(Flight flight:resultList) {
                System.out.println(flight);
            }
        } else {
            System.out.println("No flights found.");
        }

    }
}