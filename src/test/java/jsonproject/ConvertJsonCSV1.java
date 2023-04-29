package jsonproject;

import com.opencsv.CSVWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class ConvertJsonCSV1 {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        try {
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(path + "\\json\\first_url_response.json");
            CSVWriter writer = new CSVWriter(new FileWriter(path + "\\csv\\first_url_response.csv"));
            Object obj = jsonparser.parse(reader);
            JSONObject recordobj = (JSONObject) obj;

            JSONArray arrayObj = (JSONArray) recordobj.get("products");
            String[] header = {"id", "title", "description", "price", "rating", "stock", "brand", "discountPercentage"};
            writer.writeNext(header);
            for (int i = 0; i < arrayObj.size(); i++) {
                JSONObject products = (JSONObject) arrayObj.get(i);
                String id = products.get("id").toString();
                String title = products.get("title").toString();
                String description = products.get("description").toString();
                String price = products.get("price").toString();
                String rating = products.get("rating").toString();
                String stock = products.get("stock").toString();
                String brand = products.get("brand").toString();
                String discountPercentage = products.get("discountPercentage").toString();
                String[] lineAll = {id, title, description, price, rating, stock, brand, discountPercentage};
                writer.writeNext(lineAll);
// Flush data to create CSV file data
                writer.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
