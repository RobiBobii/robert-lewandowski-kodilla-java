package challenges.Flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinderTo {

    private final FlightDatabase flightDatabase = new FlightDatabase();

    public void findFlightTo(String airport) {

        List<Flight> resultList = flightDatabase.getFlightSet().stream()
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .collect(Collectors.toList());

        if(resultList.size()>0) {
            System.out.println("List of flights to " + airport + ":");
            for(Flight flight:resultList) {
                System.out.println(flight);
            }
        } else {
            System.out.println("No flights found.");
        }

    }
}