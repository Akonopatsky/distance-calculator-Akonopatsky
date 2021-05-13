package distancecalculator.utils;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

public class CalculateService {
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public static Distance calculate(City cityA, City cityB) {
/*        double latDistance = Math.toRadians(fromCity.getLatitude() - toCity.getLatitude());
        double lngDistance = Math.toRadians(fromCity.getLongitude() - toCity.getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(fromCity.getLatitude())) * Math.cos(Math.toRadians(toCity.getLatitude()))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = AVERAGE_RADIUS_OF_EARTH_KM * c;*/
        double latitudeAInRad = Math.toRadians(cityA.getLatitude());
        double latitudeBInRad = Math.toRadians(cityB.getLatitude());

        // Variation of longitudes
        double deltaLongitude = cityB.getLongitude() - cityA.getLongitude();
        double deltaLongitudeInRad = Math.toRadians(deltaLongitude);

        // Calculates the sine and cosine
        double sinLatitudeA = Math.sin(latitudeAInRad);
        double cosLatitudeA = Math.cos(latitudeAInRad);
        double sinLatitudeB = Math.sin(latitudeBInRad);
        double cosLatitudeB = Math.cos(latitudeBInRad);
        double cosDeltaLongitude = Math.cos(deltaLongitudeInRad);



        // Calculates the distance between the coordinates
        double distance =  Math.acos(
                cosLatitudeA * cosLatitudeB * cosDeltaLongitude +
                        sinLatitudeA * sinLatitudeB
        ) * AVERAGE_RADIUS_OF_EARTH_KM;

        Distance result = new Distance(cityA, cityB, distance);
        return result;
    }

}
