package distancecalculator.rest.controllers;

import distancecalculator.rest.services.DistanceCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@RequestMapping("/api/stream")
@RestController
public class CityStreamRestController {
    private static final Logger logger = LoggerFactory.getLogger(CityStreamRestController.class);
    private final DistanceCalculatorService distanceCalculatorService;

    public CityStreamRestController(DistanceCalculatorService distanceCalculatorService) {
        this.distanceCalculatorService = distanceCalculatorService;
    }

    @GetMapping({"/cities"})
    public ResponseEntity<StreamingResponseBody> getAllCitiesStream() {
        logger.info("get cities stream");
        StreamingResponseBody responseBody = response -> {
            distanceCalculatorService.writeCitiesToStream(response);
            response.flush();
        };
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(responseBody);

    }
}
