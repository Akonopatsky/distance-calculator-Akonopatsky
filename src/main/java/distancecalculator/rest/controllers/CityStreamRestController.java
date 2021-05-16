package distancecalculator.rest.controllers;

import distancecalculator.rest.services.RestService;
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
    private final RestService restService;

    public CityStreamRestController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping({"/cities"})
    public ResponseEntity<StreamingResponseBody> getAllCitiesStream() {
        logger.info("get cities stream");
        StreamingResponseBody responseBody = response -> {
            restService.writeCitiesToStream(response);
            response.flush();
        };
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(responseBody);

    }
}
