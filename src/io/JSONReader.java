package io;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JSONReader {
    private String filePath;

    public JSONReader(String filePath){
        this.filePath  = filePath;
    }


    public JSONArray getJsonObjects2(){
        JSONParser parser = new JSONParser();
        JSONArray jsonObjects = null;
        try{
            jsonObjects = (JSONArray) parser.parse(new FileReader(filePath));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return jsonObjects;
    }

    public JSONArray getJSONArrayInFile(){
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        try{
            String jsonFileStr = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            jsonArray.add(parser.parse(jsonFileStr));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return jsonArray;
    }
}
