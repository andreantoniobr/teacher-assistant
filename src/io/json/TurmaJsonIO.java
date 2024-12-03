package io.json;

import model.Turma;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class TurmaJsonIO {
    private final String filePath;

    public TurmaJsonIO(String filePath) {
        this.filePath = filePath;
    }

    public void salvarTurma(Turma turma){
        try{
            JSONWriter jsonWriter = new JSONWriter(filePath);
            JSONObject jsonObject = getJsonObjectFromTurma(turma);
            jsonWriter.appendObjectInFileJSON(jsonObject);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvarTurmas(ArrayList<Turma> turmas){
        try{
            JSONArray alunosJsonArray = new JSONArray();
            JSONWriter jsonWriter = new JSONWriter(filePath);
            for (Turma turma:turmas){
                JSONObject jsonObject = getJsonObjectFromTurma(turma);
                alunosJsonArray.add(jsonObject);
            }
            jsonWriter.writeArrayInFileJson(alunosJsonArray);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Turma> getTurmasSalvas(){
        ArrayList<Turma> turmas = new ArrayList<>();
        try{
            JSONReader jsonReader = new JSONReader(filePath);
            JSONArray jsonArray = jsonReader.getJSONArrayInFile();
            if(jsonArray != null){
                for (Object object : jsonArray) {
                    JSONObject jsonObject = (JSONObject) object;
                    Turma turma = getTurmaFromJsonObject(jsonObject);
                    turmas.add(turma);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return turmas;
    }

    public JSONObject getJsonObjectFromTurma(Turma turma){
        JSONObject jsonObject = new JSONObject();
        if(turma != null){
            jsonObject.put("id", turma.getId());
            jsonObject.put("nome", turma.getNome());
        }
        return  jsonObject;
    }

    public Turma getTurmaFromJsonObject(JSONObject jsonObject){
        Turma turma = null;
        if(jsonObject != null){
            int id = Integer.parseInt(jsonObject.get("id").toString());
            String nome = (String) jsonObject.get("nome");
            turma = new Turma(id, nome);
        }
        return turma;
    }
}
