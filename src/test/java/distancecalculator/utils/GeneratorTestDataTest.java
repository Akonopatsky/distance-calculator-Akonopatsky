package distancecalculator.utils;

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
}