package distancecalculator.rest.controllers;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.CalculationType;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRestDto;
import distancecalculator.rest.services.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CityRestController {
    private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
    private final RestService restService;

    public CityRestController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping({"/api/cities", "/api/city/list"})
    public List<CityRestDto> getAllCities() {
        logger.info("get cities");
        return restService.getAllCities();
    }

    @GetMapping("/api/distances")
    public List<DistanceRestDto> calculateDistances(
            @RequestParam(name = "calculationType") String calculationType,
            @RequestParam(name = "fromCities") List<CityRestDto> fromCities,
            @RequestParam(name = "toCities") List<CityRestDto> toCities
    ) throws DistanceCalculatorException {
        logger.info("get distances: type {} from cities {} to cities {} ", calculationType, fromCities, toCities);
        return restService.calculateDistance(CalculationType.valueOf(calculationType.toUpperCase()), fromCities, toCities);
    }

    @PutMapping("/api/upload")
    public ResponseEntity uploadXmlFile(
            @RequestParam(name = "file") MultipartFile file
    ) throws Exception {
        logger.info("post request /upload ");
        if (file != null) {
            logger.info("upload xml file {} ", file.getName());
            restService.upload(file);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping({"/api/post/cities"})
    public List<CityRestDto> getAllCitiesPost() {
        logger.info("get cities");
        return restService.getAllCities();
    }

}
