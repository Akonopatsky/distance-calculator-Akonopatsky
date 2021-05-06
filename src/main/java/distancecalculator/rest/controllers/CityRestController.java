package distancecalculator.rest.controllers;

import distancecalculator.rest.dto.CityDto;
import distancecalculator.rest.dto.DistanceDto;
import distancecalculator.rest.services.DistanceCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CityRestController {
    private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
    private final DistanceCalculateService distanceCalculateService;

    public CityRestController(DistanceCalculateService distanceCalculateService) {
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping({"/api/cities", "/api/city/list"})
    public List<CityDto> getAllCities() {
        logger.info("get cities");
        return distanceCalculateService.getAllCities();
    }

    @GetMapping("/api/distances")
    public List<DistanceDto> calculateDistances(
            @RequestParam(name = "calculationType") String calculationType,
            @RequestParam(name = "fromCities") List<String> fromCities,
            @RequestParam(name = "toCities") List<String> toCities
    ) {
        logger.info("get distances type {} from cities {} to cities {} ", calculationType, fromCities, toCities);
        return distanceCalculateService.calculateDistance(calculationType, fromCities, toCities);
    }

    @PutMapping("/api/upload")
    public ResponseEntity uploadXmlFile(
            @RequestParam(name = "file") MultipartFile file
    ) {
        logger.info("post request /upload ");
        if (file != null) {
            logger.info("upload xml file {} ", file.getName());
            distanceCalculateService.upload(file);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
