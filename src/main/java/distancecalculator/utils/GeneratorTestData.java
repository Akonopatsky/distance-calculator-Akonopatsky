package distancecalculator.utils;

import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.utils.converters.CsvFileLoader;

import javax.xml.bind.JAXBException;
import java.util.*;

public class GeneratorTestData {
    public static void main(String[] args) throws JAXBException {
        List<City> city500list = CsvFileLoader.readFromCSV("cities.csv", ';');
/*        List<Distance> randDistanceList = GeneratorTestData.getRandomSet(city500list, city500list.size()/2);
        CitiesAndDistancesXML citiesAndDistancesXML = new CitiesAndDistancesXML();
        citiesAndDistancesXML.insertCities(city500list);
        citiesAndDistancesXML.insertDistances(randDistanceList);
        File file = new File("bigtest.xml");
        XmlService.marshal(citiesAndDistancesXML, file );*/
        City a = new City();
        City b = new City();
        List<City> londons = new ArrayList<>();
        for (City city : city500list) {
            if (city.getName().equals("London")) {
                a = city;
                londons.add(city);
            }
            if (city.getName().equals("Paris")) b = city;
        }
        londons.forEach(System.out::println);
        Distance distance = CalculateService.calculate(a, b);
        System.out.println(distance);
    }

    private static List<Distance> getRandomSet(List<City> list, int quantity) {
        List<Distance> distanceList = new ArrayList<>(quantity);
        List<City> fromList = new ArrayList<>(list);
        List<City> toList = new ArrayList<>(list);
        Collections.shuffle(fromList);
        Collections.shuffle(toList);
        for (int i = 0; i < quantity; i++) {
            int fromIndex = toList.size() - 1;
            int toIndex = toList.size() - 1;
            City fromCity = fromList.get(fromIndex);
            City toCity = toList.get(toIndex);
            while (fromCity.equals(toCity)) {
                toIndex--;
                toCity = toList.get(toIndex);
            }
            distanceList.add(CalculateService.calculate(fromCity, toCity));
            fromList.remove(fromIndex);
            toList.remove(toIndex);
        }
        return distanceList;
    }
}
