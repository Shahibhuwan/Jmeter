package jsonproject;

import com.opencsv.CSVWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class ConvertJsonCSV2 {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        try {
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(path + "\\json\\second_url_response.json");
            CSVWriter writer = new CSVWriter(new FileWriter(path + "\\csv\\second_url_response.csv"));
            Object obj = jsonparser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            String[] header = {"id", "user_id", "title", "due_on", "status"};
            writer.writeNext(header);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String id = jsonObject.get("id").toString();
                String user_id = jsonObject.get("user_id").toString();
                String title = jsonObject.get("title").toString();
                String due_on = jsonObject.get("due_on").toString();
                String status = jsonObject.get("status").toString();
                String[] lineAll = {id, user_id, title, due_on, status};
                writer.writeNext(lineAll);
            }
            //Flush data to create CSV file data
            writer.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
