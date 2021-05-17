package distancecalculator.rest.controllers;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.*;
import distancecalculator.rest.services.DistanceCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CityRestController {
    private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
    private final DistanceCalculatorService distanceCalculatorService;

    public CityRestController(DistanceCalculatorService distanceCalculatorService) {
        this.distanceCalculatorService = distanceCalculatorService;
    }

    @GetMapping({"/cities", "/api/city/list"})
    public List<CityRestDto> getAllCities() {
        logger.info("get cities");
        return distanceCalculatorService.getAllCities();
    }

    @GetMapping("/distances")
    public List<DistanceRestDto> calculateDistances(
            @RequestBody DistanceRequest distanceRequest
            ) throws DistanceCalculatorException {
        logger.info("get distances: type {} from cities {} to cities {} ", distanceRequest.getCalculationType(),
                distanceRequest.getFromCities(), distanceRequest.getToCities());
        CalculationType calculationType = CalculationType.valueOf(distanceRequest.getCalculationType().toUpperCase());
        List<CityRestDto> fromCities = distanceRequest.getFromCities();
        List<CityRestDto> toCities = distanceRequest.getToCities();
        return distanceCalculatorService.calculateDistance(calculationType, fromCities, toCities);
    }


    @PostMapping("/upload")
    public ResponseEntity uploadXmlFile(
            @RequestParam(name = "file") MultipartFile file
    ) throws Exception {
        logger.info("post request /upload ");
        if (file != null) {
            logger.info("upload xml file {}, size {}, isEmpty {} ", file.getName(), file.getSize(), file.isEmpty());
            distanceCalculatorService.upload(file);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
