package challenges.Flights;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFinderVia {

    private final FlightDatabase flightDatabase = new FlightDatabase();
    private final List<Flight> resultList = new LinkedList<>();

    public void findFlightVia(String departureAirport, String arrivalAirport) {

        flightDatabase.getFlightSet().stream()
                .filter(f -> f.getDepartureAirport().equals(departureAirport))
                .forEach(f -> {
                    List<Flight> tempList = flightDatabase.getFlightSet().stream()
                            .filter(flight -> (f.getArrivalAirport().equals(flight.getDepartureAirport())) && flight.getArrivalAirport().equals(arrivalAirport))
                            .collect(Collectors.toList());
                    if(tempList.size()>0) {
                        for(Flight tf:tempList) {
                            resultList.add(tf);
                        }
                    }
                });

        if(resultList.size()>0) {
            System.out.println("List of flights from " + departureAirport + " to " + arrivalAirport + " through a connecting airport:");
            for(Flight flight:resultList) {
                System.out.println(departureAirport + "->" + flight);
            }
        } else {
            System.out.println("No flights found.");
        }



    }
}