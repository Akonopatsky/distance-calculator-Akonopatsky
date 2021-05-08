package distancecalculator.rest.dto;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "CityDistanceList")
public class CityDistanceListXml {

    private List<CityXml> cityXmlList;
    private List<DistanceXml> distanceXmlList;

    public CityDistanceListXml() {
        this.cityXmlList = new ArrayList<>();
        this.distanceXmlList = new ArrayList<>();
    }

    public CityDistanceListXml(List<City> cityList, List<Distance> distanceList) {
        this.cityXmlList = cityList.stream()
                .map(city -> new CityXml(city)).collect(Collectors.toList());
        this.distanceXmlList = distanceList.stream()
                .map(distance -> new DistanceXml(distance)).collect(Collectors.toList());
    }

    @XmlElement(name = "city")
    public void setCityXmlList(List<CityXml> cityXmlList) {
        this.cityXmlList = cityXmlList;
    }

    @XmlElement(name = "distance")
    public void setDistanceXmlList(List<DistanceXml> distanceXmlList) {
        this.distanceXmlList = distanceXmlList;
    }

    public void addCity(City city) {
        this.cityXmlList.add(new CityXml(city));
    }

    public void addDistance(Distance distance) {
        this.distanceXmlList.add(new DistanceXml(distance));
    }

    public List<CityXml> getCityXmlList() {
        return cityXmlList;
    }

    public List<DistanceXml> getDistanceXmlList() {
        return distanceXmlList;
    }

}
