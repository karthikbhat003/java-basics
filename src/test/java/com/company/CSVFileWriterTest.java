package com.company;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import com.company.domain.User;

public class CSVFileWriterTest {
    @Test
    public void csvFileTest() throws IOException {
        String[] headers1 = { "Id", "Name", "Score" };
        User user = new User();
        user.setId(12L);
        user.setName("karthik");
        user.setScore(123);

        FileWriter fileWriter = new FileWriter("example.csv");
        CSVFormat csvFormat = CSVFormat.RFC4180.withHeader(headers1);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);

        csvPrinter.print(user.getId());
        csvPrinter.print(user.getName());
        csvPrinter.print(user.getScore());

        csvPrinter.close();
    }
}
