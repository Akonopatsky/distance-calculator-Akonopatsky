package distancecalculator.rest.services;


import distancecalculator.dao.CityDistanceDao;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.CalculationType;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRestDto;
import distancecalculator.utils.Calculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistanceService {
    private final CityDistanceDao dao;

    public DistanceService(CityDistanceDao dao) {
        this.dao = dao;
    }

    public List<DistanceRestDto> getDistanceList(
            CalculationType calculationType,
            List<CityRestDto> fromCityRestList,
            List<CityRestDto> toCityRestList
    ) throws DistanceCalculatorException {

        List<DistanceRestDto> result = new ArrayList<>();
        List<City> fromCityList = getCityList(fromCityRestList);
        List<City> toCityList = getCityList(toCityRestList);
        for (City fromCity : fromCityList) {
            for (City toCity : toCityList) {
                if (!fromCity.equals(toCity)) {
                    if (calculationType == CalculationType.ALL) {
                        result.add(getDistanceMatrixRest(fromCity, toCity));
                        result.add(getCrowFlightRest(fromCity, toCity));
                    }
                    if (calculationType == CalculationType.CROW_FLIGHT) {
                        result.add(getCrowFlightRest(fromCity, toCity));
                    }
                    if (calculationType == CalculationType.DISTANCE_MATRIX) {
                        result.add(getDistanceMatrixRest(fromCity, toCity));
                    }
                }
            }
        }
        return result;
}

    private DistanceRestDto getCrowFlightRest(City fromCity, City toCity) throws DistanceCalculatorException {
        return new DistanceRestDto(CalculationType.CROW_FLIGHT, getCrowFlight(fromCity, toCity));
    }

    private DistanceRestDto getDistanceMatrixRest(City fromCity, City toCity) throws DistanceCalculatorException {
        return new DistanceRestDto(CalculationType.DISTANCE_MATRIX, getDistanceMatrix(fromCity, toCity));
    }

    public List<City> getCityList(List<CityRestDto> cityRestDtoList) throws DistanceCalculatorException {
        List<City> result = new ArrayList<>();
        for (CityRestDto cityRestDto : cityRestDtoList) {
            result.add(dao.getById(cityRestDto.getId()));
        }
        return result;
    }

    public Distance getCrowFlight(City fromCity, City toCity) {
        return Calculator.calculate(fromCity, toCity);
    }

    public Distance getDistanceMatrix(City fromCity, City toCity) throws DistanceCalculatorException {
        return dao.getDistance(fromCity, toCity)
                .orElseThrow(() ->new DistanceCalculatorException("there is no DistanceMatrix "+ fromCity.getName() + toCity.getName()));
    }
}
