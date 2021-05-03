package distancecalculator.controllers;

import distancecalculator.dto.CityIdName;
import distancecalculator.services.DistanceCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestController {
    private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
    private final DistanceCalculateService distanceCalculateService;

    public CityRestController(DistanceCalculateService distanceCalculateService) {
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping({"/cities", "/city/list"})
    public List<CityIdName> getAllCities() {
        logger.info("get cities");
        return distanceCalculateService.getAllCities();
    }

    @GetMapping("/distances")
    public List<Double> calculateDistances(
            @RequestParam(name = "calculationType") String calculationType,
            @RequestParam(name = "fromCities") List<String> fromCities,
            @RequestParam(name = "toCities") List<String> toCities
    ) {
        logger.info("get distances type {} from {} to {} ", calculationType, fromCities, toCities);
        return distanceCalculateService.calculateDistance(calculationType, fromCities, toCities);
    }

}
