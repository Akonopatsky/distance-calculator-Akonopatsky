package distancecalculator.Dao.Services;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import distancecalculator.rest.dto.CityDto;
import distancecalculator.rest.dto.DistanceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileLoader {
    private static final Logger logger = LoggerFactory.getLogger(CsvFileLoader.class);
    public static List<CityDto> readFromCSV(String fileName, char CsvSeparator) {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(
                    Paths.get(ClassLoader.getSystemResource(fileName).toURI()), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(CsvSeparator)
                .withIgnoreQuotations(true)
                .build();
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();
        List<CityDto> distanceList = new ArrayList<>();
        for (String[] nextLine : csvReader) {
            try {
                CityDto city = new CityDto(
                        nextLine[0],
                        Double.parseDouble(nextLine[1]),
                        Double.parseDouble(nextLine[2])
                );
                distanceList.add(city);
            } catch (NumberFormatException e) {
                logger.error(nextLine[0].toString());
            }
        }
        return distanceList;

    }
}
