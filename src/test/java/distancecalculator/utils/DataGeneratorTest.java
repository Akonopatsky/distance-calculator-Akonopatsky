package distancecalculator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import distancecalculator.DataGenerator;
import distancecalculator.exceptions.DistanceCalculatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DataGeneratorTest {
    @Autowired
    DataGenerator dataGenerator;

    @Test
    void generate() throws Exception {
        dataGenerator.generate();
    }

    @Test
    void createFelt() throws Exception {
        dataGenerator.createFileFrom("./citiest.csv");
    }

    @Test
    void generateJson() throws JsonProcessingException, DistanceCalculatorException {
        System.out.println("generatorTestData JSON _________________________");
        System.out.println(dataGenerator.jsonT());
        System.out.println("generatorTestData JSON _________________________");
    }
}