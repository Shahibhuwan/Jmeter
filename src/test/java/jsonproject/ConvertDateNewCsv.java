package jsonproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConvertDateNewCsv {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String inputCsvFile = path + "\\csv\\second_url_response.csv";
        //Get current date
        LocalDate currentDate = LocalDate.now();
        List<String> itemList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fileName = "pipes_" + currentDate.format(dateFormatter) + ".csv";
            String outputCsvFile = path + "\\csv\\" + fileName;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFile))) {
                try (FileWriter writer = new FileWriter(outputCsvFile)) {
                    String line;
                    int index = 0;
                    while ((line = reader.readLine()) != null) {
                        if (index == 0) {
                            index++;
                        } else {
                            String[] fields = line.split(",");
                            for (String value : fields) {
                                itemList.add(value);
                            }
                            String datee = itemList.get(itemList.size() - 2);
                            System.out.println(datee);
                            writer.write(String.join("pipes", fields) + "\n");
                        }
                    }
                    writer.flush();
                    System.out.println("CSV file created successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}