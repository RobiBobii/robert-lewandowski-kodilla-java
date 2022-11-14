package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
    public List<Double> temperaturesToList() {  //extracting temperatures from Map to ArrayList
        List<Double> listOfTemp = new ArrayList<>();
        for (Map.Entry<String, Double> temp : temperatures.getTemperatures().entrySet()) {
            listOfTemp.add(temp.getValue());
        }
        return listOfTemp;
    }

    public Double averageTemp() {
        List<Double> listOfTemp = temperaturesToList();
        Double sum = 0.0;       //calculating sum of temperatures
        for (Double i : listOfTemp) {
            sum += i;
        }
        return sum / listOfTemp.size();    //calculating average temperature
    }

    public Double median() {
        List<Double> listOfTemp = temperaturesToList();
        Collections.sort(listOfTemp);   //sort temperatures
        Double median = 0.0;
        if (listOfTemp.size() % 2 == 0) {
            //(even amount of measurements) taking the 2 measurements from the middle of the list
            Double sum = listOfTemp.get(listOfTemp.size() / 2) + listOfTemp.get((listOfTemp.size() / 2) - 1);
            median = sum / 2;
        } else {
            //(odd amount of measurements) taking the measurement from the middle of the list
            median = listOfTemp.get(Math.round(listOfTemp.size() / 2));
        }
        return median;
    }
}