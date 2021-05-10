package distancecalculator.calculator.Utils;

import distancecalculator.calculator.model.City;
import distancecalculator.calculator.model.Distance;

public class CalculateServiceImpl {
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public Distance calculate(City fromCity, City toCity) {
        double latDistance = Math.toRadians(fromCity.getLatitude() - toCity.getLatitude());
        double lngDistance = Math.toRadians(fromCity.getLongitude() - toCity.getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(fromCity.getLatitude())) * Math.cos(Math.toRadians(toCity.getLatitude()))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = AVERAGE_RADIUS_OF_EARTH_KM * c;
        Distance result = new Distance(fromCity, toCity, distance);
        return result;
    }

}
