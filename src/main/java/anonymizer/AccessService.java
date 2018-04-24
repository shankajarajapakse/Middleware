package anonymizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AccessService
{
    public static void importCDR() throws IOException {
        Reader in = new FileReader("C:\\Users\\Sankaja\\IdeaProjects\\parallel\\resources\\calls.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .parse(in);
        for (CSVRecord record : records)
        {
            System.out.println(record.get(0) +"->"+record.get(1));
            if (Mappings.getInstance().isAlreadyMapped(record.get(0)))
            {

            }
            else
            {

            }

        }

    }
}
