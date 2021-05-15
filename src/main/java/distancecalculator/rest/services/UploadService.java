package distancecalculator.rest.services;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.rest.dto.CityDto;
import distancecalculator.rest.dto.DistanceDto;


import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadService {
    private final CityDistanceDao dao;

    public UploadService(CityDistanceDao dao) {
        this.dao = dao;
    }

    public void uploadData(XmlDto xmlDto) {
        Map<Long, City> cityMap = new HashMap<>(xmlDto.getCityDtoMap().size());
        for (Map.Entry<Long, CityDto> entry : xmlDto.getCityDtoMap().entrySet()) {
            cityMap.put(entry.getKey(), entry.getValue().getCity());
        }
        List<Distance> distanceList = new ArrayList<>(xmlDto.getDistanceDtoList().size());
        for (DistanceDto distanceDto : xmlDto.getDistanceDtoList()) {
            City fromCity = cityMap.get(distanceDto.getFromCity());
            City toCity = cityMap.get(distanceDto.getToCity());
            distanceList.add(new Distance(fromCity, toCity, distanceDto.getDistance()));
        }
        dao.saveCityList(new ArrayList<City>(cityMap.values()));
        dao.saveDistanceList(distanceList);

    }



}
