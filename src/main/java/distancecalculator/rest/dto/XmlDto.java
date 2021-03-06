package distancecalculator.rest.dto;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "CityDistanceList")
public class XmlDto {

    private Map<Long, CityLoadDto> cityDtoMap = new HashMap<>();
    private List<DistanceLoadDto> distanceList = new ArrayList<>();

    public XmlDto() {
    }

    public XmlDto(List<City> cityList, List<Distance> distanceList) throws DistanceCalculatorException {
        insertCityList(cityList);
        insertDistanceList(distanceList);
    }

    @XmlElement(name = "city")
    public void setCityDtoMap(Map<Long, CityLoadDto> cityDtoMap) {
        this.cityDtoMap = cityDtoMap;
    }

    @XmlElement(name = "distance")
    public void setDistanceDtoList(List<DistanceLoadDto> distanceDtoList) {
        this.distanceList = distanceDtoList;
    }

    public void addCity(City city) throws DistanceCalculatorException {
        if (city.getId() == 0) {
            throw new DistanceCalculatorException("add city id = 0, id is necessary for XML DTO");
        }
        this.cityDtoMap.put(city.getId(), new CityLoadDto(city));
    }

    private void addDistance(Distance distance) throws DistanceCalculatorException {
        if (!this.cityDtoMap.containsKey(distance.getFromCity().getId())) {
            throw new DistanceCalculatorException("There is no city ID "
                    + distance.getFromCity().getId()
                    + " in cityDtoMap ");
        }
        distanceList.add(new DistanceLoadDto(distance));
    }

    public void insertDistanceList(List<Distance> list) throws DistanceCalculatorException {
        for (Distance distance : list) {
            addDistance(distance);
        }
    }

    public void insertCityList(List<City> list) throws DistanceCalculatorException {
        for (City city : list) {
            addCity(city);
        }
    }

    public Map<Long, CityLoadDto> getCityDtoMap() {
        return cityDtoMap;
    }

    public List<DistanceLoadDto> getDistanceDtoList() {
        return distanceList;
    }
}
