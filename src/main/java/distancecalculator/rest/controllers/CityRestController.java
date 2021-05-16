package distancecalculator.rest.controllers;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.*;
import distancecalculator.rest.services.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import static distancecalculator.rest.dto.CalculationType.CROW_FLIGHT;

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
            @RequestBody DistanceRequest distanceRequest
            ) throws DistanceCalculatorException {
        logger.info("get distances: type {} from cities {} to cities {} ", distanceRequest.getCalculationType(),
                distanceRequest.getFromCities(), distanceRequest.getToCities());
        CalculationType calculationType = CalculationType.valueOf(distanceRequest.getCalculationType().toUpperCase());
        List<CityRestDto> fromCities = distanceRequest.getFromCities();
        List<CityRestDto> toCities = distanceRequest.getToCities();
        return restService.calculateDistance(calculationType, fromCities, toCities);
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

}
