package distancecalculator.rest.dto;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "CityDistanceList")
public class CitiesAndDistancesXML {

    private List<CityDto> cityList;
    private List<DistanceDto> distanceList;

    public CitiesAndDistancesXML() {
        this.cityList = new ArrayList<>();
        this.distanceList = new ArrayList<>();
    }

    public CitiesAndDistancesXML(List<City> cityList, List<Distance> distanceList) {
        this.cityList = cityList.stream()
                .map(city -> new CityDto(city)).collect(Collectors.toList());
        this.distanceList = distanceList.stream()
                .map(distance -> new DistanceDto(distance)).collect(Collectors.toList());
    }

    @XmlElement(name = "city")
    public void setCityList(List<CityDto> cityDtoList) {
        this.cityList = cityDtoList;
    }

    @XmlElement(name = "distance")
    public void setDistanceList(List<DistanceDto> distanceDtoList) {
        this.distanceList = distanceDtoList;
    }

    public void addCity(City city) {
        this.cityList.add(new CityDto(city));
    }

    public void addDistance(Distance distance) {
        this.distanceList.add(new DistanceDto(distance));
    }

    public List<CityDto> getCityList() {
        return cityList;
    }

    public List<DistanceDto> getDistanceList() {
        return distanceList;
    }

}
