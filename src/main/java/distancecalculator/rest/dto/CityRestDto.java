package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityRestDto {
    private  long id;
    private  String name;

    public CityRestDto() {
    }

    public CityRestDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityRestDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
