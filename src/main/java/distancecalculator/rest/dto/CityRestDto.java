package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public void setId(String id) {
        this.id = Long.parseLong(id);
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

    @Override
    public String toString() {
        return "CityRestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
