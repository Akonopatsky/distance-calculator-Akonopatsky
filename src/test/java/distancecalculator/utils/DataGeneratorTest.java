package distancecalculator.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DataGeneratorTest {
    @Autowired
    DataGenerator dataGenerator;

    @Test
    void generate() throws Exception {
        dataGenerator.generate();
    }
}