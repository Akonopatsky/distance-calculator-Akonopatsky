package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class CityResponseDtoList {
    private List<CityResponseDto> CityResponsetoList = new ArrayList<>();

    public CityResponseDtoList() {
    }

    public List<CityResponseDto> getCityResponseDtoList() {
        return CityResponsetoList;
    }

    @XmlElement
    public void setCityResponseDtoList(List<CityResponseDto> cityResponsetoList) {
        this.CityResponsetoList = cityResponsetoList;
    }

    public void add(City city) {
        CityResponsetoList.add(new CityResponseDto(city));
    }
}

