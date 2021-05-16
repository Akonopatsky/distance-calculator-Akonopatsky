package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class CityRestDtoList {
    private List<CityRestDto> CityRestDtoList = new ArrayList<>();

    public CityRestDtoList() {
    }

    public List<CityRestDto> getCityRestDtoList() {
        return CityRestDtoList;
    }

    @XmlElement
    public void setCityRestDtoList(List<CityRestDto> cityRestDtoList) {
        this.CityRestDtoList = cityRestDtoList;
    }

    public void add(City city) {
        CityRestDtoList.add(new CityRestDto(city));
    }
}


/*@XmlRootElement
public class CityRestDtoList {
    private List<CityRestDto> CityRestDtoList = new ArrayList<>();

    public CityRestDtoList() {
    }

    public List<CityRestDto> getCityRestDtoList() {
        return CityRestDtoList;
    }

    @XmlElement
    public void setCityRestDtoList(List<CityRestDto> cityRestDtoList) {
        this.CityRestDtoList = cityRestDtoList;
    }

    public void add(City city) {
        CityRestDtoList.add(new CityRestDto(city));
    }
}*/
