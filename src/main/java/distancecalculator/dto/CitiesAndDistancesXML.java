package distancecalculator.dto;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@XmlRootElement(name = "CityDistanceList")
public class CitiesAndDistancesXML {

    private Map<Long, CityDto> cityDtoMap;
    private List<DistanceDto> distanceList;

    public CitiesAndDistancesXML() {
        this.cityDtoMap = new HashMap<>();
        this.distanceList = new ArrayList<>();
    }

    public CitiesAndDistancesXML(List<City> cityList, List<Distance> distanceList) throws DistanceCalculatorDtoException {
        insertCityList(cityList);
        insertDistanceList(distanceList);
    }

    @XmlElement(name = "city")
    public void setCityDtoMap(Map<Long, CityDto> cityDtoMap) {
        this.cityDtoMap = cityDtoMap;
    }

    @XmlElement(name = "distance")
    public void setDistanceDtoList(List<DistanceDto> distanceDtoList) {
        this.distanceList = distanceDtoList;
    }

    public void addCity(City city) throws DistanceCalculatorDtoException {
        if (city.getId() == 0) {
            throw new DistanceCalculatorDtoException("add city id = 0, id is necessary for XML DTO");
        }
        this.cityDtoMap.put(city.getId(), new CityDto(city));
    }

    public void addDistance(Distance distance) {
        this.distanceList.add(new DistanceDto(distance));
    }

    public void insertDistanceList(List<Distance> list) {
        list.forEach(this::addDistance);
    }

    public void insertCityList(List<City> list) throws DistanceCalculatorDtoException {
        for (City city : list) {
            addCity(city);
        }
    }

    public Map<Long, CityDto> getCityDtoMap() {
        return cityDtoMap;
    }

    public List<DistanceDto> getDistanceDtoList() {
        return distanceList;
    }

/*    public List<City> getCityList() {
        List<City> result = new ArrayList<>(cityDtoMap.size());
        for (Map.Entry<Long, CityDto> entry : cityDtoMap.entrySet()) {
            result.add(new City())
        }
        return this.cityDtoMap.stream()
                .map(city -> city.getCity()).collect(Collectors.toList());
    }*/


}
