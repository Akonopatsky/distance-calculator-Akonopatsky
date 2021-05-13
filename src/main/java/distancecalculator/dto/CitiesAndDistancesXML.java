package distancecalculator.dto;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "CityDistanceList")
public class CitiesAndDistancesXML {

    private List<CityDto> cityDtoList;
    private List<DistanceDto> distanceList;

    public CitiesAndDistancesXML() {
        this.cityDtoList = new ArrayList<>();
        this.distanceList = new ArrayList<>();
    }

    public CitiesAndDistancesXML(List<City> cityList, List<Distance> distanceList) {
        this.cityDtoList = cityList.stream()
                .map(city -> new CityDto(city)).collect(Collectors.toList());
        this.distanceList = distanceList.stream()
                .map(distance -> new DistanceDto(distance)).collect(Collectors.toList());
    }

    @XmlElement(name = "city")
    public void setCityDtoList(List<CityDto> cityDtoList) {
        this.cityDtoList = cityDtoList;
    }

    @XmlElement(name = "distance")
    public void setDistanceDtoList(List<DistanceDto> distanceDtoList) {
        this.distanceList = distanceDtoList;
    }

    public void addCity(City city) {
        this.cityDtoList.add(new CityDto(city));
    }

    public void addDistance(Distance distance) {
        this.distanceList.add(new DistanceDto(distance));
    }

    public void insertDistanceList(List<Distance> list) {
        list.forEach(distance -> addDistance(distance));
    }

    public void insertCityList(List<City> list) {
        list.forEach(city -> addCity(city));
    }

    public List<CityDto> getCityDtoList() {
        return cityDtoList;
    }

    public List<DistanceDto> getDistanceDtoList() {
        return distanceList;
    }

    public List<City> getCityList() {
        return this.cityDtoList.stream()
                .map(city -> city.getCity()).collect(Collectors.toList());
    }





}
