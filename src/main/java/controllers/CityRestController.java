package controllers;

import dto.CalculationType;
import dto.CityIdName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.DistanceCalculateService;

import java.util.List;

@RestController
public class CityRestController {
    private final DistanceCalculateService distanceCalculateService;

    public CityRestController(DistanceCalculateService distanceCalculateService) {
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping({"/cities", "/city/list"})
    public List<CityIdName> getAllCities() {
        return distanceCalculateService.getAllCities();
    }

    @GetMapping("/calculate")
    public List<Double> calculateDistances(
            @RequestParam(name = "calculationType") String calculationType,
            @RequestParam(name = "fromCities") List<String> fromCities,
            @RequestParam(name = "toCities") List<String> toCities
    ) {
        return distanceCalculateService.calculateDistance(calculationType, fromCities, toCities);
    }

}
