package jsonproject;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class ProductTitleandAvg {
    private static Float getAvg(List<Float> list) {
        Float sum = 02f;
        if (!list.isEmpty() && list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                sum += (list.get(i));
            }
        }
        Float avg = sum / list.size();
        return avg;
    }

    public static void main(String[] args) {

        String temp;
        String temp1;
        int counter = 0;
        String path = System.getProperty("user.dir");
        try {
            //Instantiating the CSV reader class for reading the cs
            CSVReader reader = new CSVReader(new FileReader(path + "\\csv\\first_url_response.csv"));
            //to get the tile after re -iteration using max discountPercentage
            CSVReader reader1 = new CSVReader(new FileReader(path + "\\csv\\first_url_response.csv"));

            //reading the data of the CSV file
            StringBuffer buffer = new StringBuffer();
            String data[];
            StringBuffer buffer1 = new StringBuffer();
            String data1[];
            List<Float> csvList = new ArrayList<>();

            // to exclude the first item of list
            int index = 0;
            while ((data = reader.readNext()) != null) {
                temp = data[data.length - 1];
                if (index == 0) {
                    index++;
                    //do nothing
                } else {
                    //Type cast
                    csvList.add(Float.valueOf(temp));
                    index++;
                }

            }
// find maz number on the list of discountedpercentage
            Float max_number = Collections.max(csvList);
            int index1 = 0;
            while ((data1 = reader1.readNext()) != null) {
                temp1 = data1[data1.length - 1];
                if (index1 == 0) {
                    index1++;
                    //do nothing
                }
                else
                {
                    if (Float.parseFloat(temp1) == max_number) {
                        String title = data1[2];
                        System.out.println("title:" + title);
                    }
                }
            }
            System.out.println("Average" + ProductTitleandAvg.getAvg(csvList));

        } catch (Exception e) {
            e.getMessage();
        }

    }
}