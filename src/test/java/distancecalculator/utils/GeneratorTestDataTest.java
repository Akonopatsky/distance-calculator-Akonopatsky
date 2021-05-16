package distancecalculator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import distancecalculator.exceptions.DistanceCalculatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GeneratorTestDataTest {
    @Autowired
    GeneratorTestData generatorTestData;

    @Test
    void generate() throws Exception {
        generatorTestData.generate();
    }

    @Test
    void createFelt() throws Exception {
        generatorTestData.createFileFrom("./citiest.csv");
    }

    @Test
    void generateJson() throws JsonProcessingException, DistanceCalculatorException {
        System.out.println("generatorTestData JSON _________________________");
        System.out.println(generatorTestData.jsont());
        System.out.println("generatorTestData JSON _________________________");
    }
}