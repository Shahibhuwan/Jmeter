package jsonproject;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TitleonDueDate {
    public static void main(String[] args) {

        String temp;
        String temp1;
        String path = System.getProperty("user.dir");
        try {
            //Instantiating the CSV reader class for reading the cs
            CSVReader reader = new CSVReader(new FileReader(path + "\\csv\\second_url_response.csv"));
            //to get the tile after re -iteration using max discountPercentage
            CSVReader reader1 = new CSVReader(new FileReader(path + "\\csv\\first_url_response.csv"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

            //reading the data of the CSV file

            String data[];

            String data1[];
            List<LocalDateTime> csvList = new ArrayList<>();

            // to exclude the first item of list
            int index = 0;
            while ((data = reader.readNext()) != null) {
                temp = data[data.length - 2];
                System.out.println("3");
                if (index == 0) {
                    index++;
                    System.out.println("4");
                    //do nothing
                } else {
                    //Type cast
                    System.out.println("1");
                    System.out.println(temp);
                    LocalDateTime dateTime = LocalDateTime.parse(temp);
                    System.out.println(dateTime);
                    csvList.add(dateTime);


                }

            }
            System.out.println("1");
            System.out.println(csvList);
// find maz number on the list of discountedpercentage
            LocalDateTime max_number = Collections.max(csvList);
            System.out.println(max_number);
            int index1 = 0;
            while ((data1 = reader1.readNext()) != null) {
                temp1 = data1[data1.length - 1];
                if (index1 == 0) {
                    index1++;
                    //do nothing
                } else {
                    LocalDateTime local = LocalDateTime.parse(temp1, formatter);
                    if (local == max_number) {
                        String title = data1[2];
                        System.out.println("title:" + title);
                    }
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }
}
