package jsonproject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Semicolon_csv {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String inputCsvFile = path + "\\csv\\first_url_response.csv";
        //Get current date
        LocalDate currentDate = LocalDate.now();
        // Define date format for file name
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "semicolon_" + currentDate.format(dateFormatter) + ".csv";
        String outputCsvFile = path + "\\csv\\" + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFile))) {
            try (FileWriter writer = new FileWriter(outputCsvFile)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    writer.write(String.join(";", fields) + "\n");
                }
                writer.flush();
                System.out.println("CSV file created successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





