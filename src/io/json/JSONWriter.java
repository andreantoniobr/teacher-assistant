package io.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter {
    private String filePath;

    public JSONWriter(String filePath){
        this.filePath  = filePath;
    }

    public void writeArrayInFileJson(JSONArray jsonArray){
        createFileIfNotExist();
        try{
            writeFile(jsonArray.toJSONString());
        }
        catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void writeObjectInFileJson(JSONObject jsonObject){
        createFileIfNotExist();
        try{
            writeFile(jsonObject.toString());
        }
        catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void appendObjectInFileJSON(JSONObject jsonObject){
        createFileIfNotExist();
        try{
            JSONReader jsonReader = new JSONReader(filePath);
            JSONArray jsonArray = jsonReader.getJSONArrayInFile();
            if(jsonArray != null){
                jsonArray.add(jsonObject);
                writeFile(jsonArray.toString());
            } else {
                writeObjectInFileJson(jsonObject);
            }
        }
        catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    private void writeFile(String str) {
        try{
            BufferedWriter writeFile = new BufferedWriter(new FileWriter(filePath));
            writeFile.write(str);
            writeFile.close();
        }
        catch(IOException e){
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    private void clearFile(){
        writeFile("[]");
    }

    public void createFileIfNotExist(){
        try{
            File file = new File(filePath);
            boolean exists = file.exists();
            if(!exists){
                file.createNewFile();
            }
        }
        catch(IOException e){
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}