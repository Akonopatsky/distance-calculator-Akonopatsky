package distancecalculator.utils;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

public class CalculateService {
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public static Distance calculate(City fromCity, City toCity) {

        double latitudeAInRad = Math.toRadians(fromCity.getLatitude());
        double latitudeBInRad = Math.toRadians(toCity.getLatitude());

        double deltaLongitude = toCity.getLongitude() - fromCity.getLongitude();
        double deltaLongitudeInRad = Math.toRadians(deltaLongitude);

        double sinLatitudeA = Math.sin(latitudeAInRad);
        double cosLatitudeA = Math.cos(latitudeAInRad);
        double sinLatitudeB = Math.sin(latitudeBInRad);
        double cosLatitudeB = Math.cos(latitudeBInRad);
        double cosDeltaLongitude = Math.cos(deltaLongitudeInRad);

        double distance =  Math.acos(
                cosLatitudeA * cosLatitudeB * cosDeltaLongitude +
                        sinLatitudeA * sinLatitudeB
        ) * AVERAGE_RADIUS_OF_EARTH_KM;

        Distance result = new Distance(fromCity, toCity, distance);
        return result;
    }

}
