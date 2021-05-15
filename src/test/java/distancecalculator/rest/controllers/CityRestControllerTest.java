package distancecalculator.rest.controllers;

import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.services.RestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class CityRestControllerTest {

    private MockMvc mvc;

    @Mock
    private RestService restService;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new CityRestController(restService)).build();
    }

    @Test
    void getAllCities() throws Exception {
        given(restService.getAllCities()).willReturn(
                Arrays.asList(
                        new CityRestDto(1, "London"),
                        new CityRestDto(2, "Samara"))
        );
        mvc.perform(get("/api/cities"))
                .andExpect(status().isOk());
        mvc.perform(get("/api/city/list"))
                .andExpect(status().isOk());
    }

    @Test
    void calculateDistances() throws Exception {
/*        given(distanceCalculateService.calculateDistance(
                "all",
                Arrays.asList("London"),
                Arrays.asList("Samara")
        ))
                .willReturn(Arrays.asList(new DistanceRestDto("CROWFLIGHT", "London", "Samara", 3300))
        );
        mvc.perform(get("/api/distances")
                .param("calculationType", "all")
                .param("fromCities", "London")
                .param("toCities", "Samara")
        ).andExpect(status().isOk());*/
    }

    @Test
    void uploadXmlFile() throws Exception {
        mvc.perform(get("/api/upload"))
                .andExpect(status().isOk());
    }
}