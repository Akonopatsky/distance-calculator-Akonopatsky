package distancecalculator.rest.services;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.rest.dto.CityLoadDto;
import distancecalculator.rest.dto.DistanceLoadDto;


import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UploadService {
    private final CityDistanceDao dao;

    public UploadService(CityDistanceDao dao) {
        this.dao = dao;
    }

    public void uploadData(XmlDto xmlDto) {
        Map<Long, City> cityMap = getLoadCityMap(xmlDto);
        List<Distance> distanceList = getLoadDistanceList(xmlDto, cityMap);
        dao.saveDistanceList(distanceList);
    }

    private Map<Long, City> getLoadCityMap(XmlDto xmlDto) {
        Map<Long, City> cityMap = new HashMap<>(xmlDto.getCityDtoMap().size());
        List<City> saveList = new ArrayList<>();
        for (Map.Entry<Long, CityLoadDto> entry : xmlDto.getCityDtoMap().entrySet()) {
            CityLoadDto loadCityDto = entry.getValue();
            Optional<City> cityOptional =  dao.getByIdOptional(entry.getKey());
            if (cityOptional.isPresent()) {
                if (cityOptional.get().getName().equals(loadCityDto.getName())) {
                    cityMap.put(cityOptional.get().getId(), cityOptional.get());
                    continue;
                }
            }
            City loadCity = loadCityDto.createCity();
            cityMap.put(entry.getKey(), loadCity);
            saveList.add(loadCity);
        }
        dao.saveCityList(new ArrayList<>(cityMap.values()));
        return cityMap;
    }

    private List<Distance> getLoadDistanceList(XmlDto xmlDto, Map<Long, City> cityMap) {
        List<Distance> distanceList = new ArrayList<>(xmlDto.getDistanceDtoList().size());
        for (DistanceLoadDto distanceDto : xmlDto.getDistanceDtoList()) {
            City fromCity = cityMap.get(distanceDto.getFromCity());
            City toCity = cityMap.get(distanceDto.getToCity());
            Optional<Distance> distance = dao.getDistance(fromCity, toCity);
            if (distance.isPresent()) {
                if (distance.get().getId() == distanceDto.getId()) {
                    continue;
                }
            }
            distanceList.add(new Distance(fromCity, toCity, distanceDto.getDistance()));
        }
        return distanceList;
    }
}
