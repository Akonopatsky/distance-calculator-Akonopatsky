package distancecalculator.rest.dto;

import com.sun.xml.txw2.annotation.XmlElement;
import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityResponseDto {
    private long id;
    private String name;

    public CityResponseDto() {
    }

    public CityResponseDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
