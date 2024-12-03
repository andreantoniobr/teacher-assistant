package io;

import model.Aluno;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class AlunoIO {
    private final String filePath;

    public AlunoIO(String filePath) {
        this.filePath = filePath;
    }

    public void salvarAluno(Aluno aluno){
        try{
            JSONWriter jsonWriter = new JSONWriter(filePath);
            JSONObject jsonObject = getJsonObjectFromAluno(aluno);
            jsonWriter.appendObjectInFileJSON(jsonObject);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvarTodosAlunos(ArrayList<Aluno> alunos){
        try{
            JSONArray alunosJsonArray = new JSONArray();
            JSONWriter jsonWriter = new JSONWriter(filePath);
            for (Aluno aluno:alunos){
                JSONObject jsonObject = getJsonObjectFromAluno(aluno);
                alunosJsonArray.add(jsonObject);
            }
            jsonWriter.writeArrayInFileJson(alunosJsonArray);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Aluno> getAlunosSalvos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        try{
            JSONReader jsonReader = new JSONReader(filePath);
            JSONArray jsonArray = jsonReader.getJSONArrayInFile();
            if(jsonArray != null){
                for (Object object : jsonArray) {
                    JSONObject jsonObject = (JSONObject) object;
                    Aluno aluno = getAlunoFromJsonObject(jsonObject);
                    alunos.add(aluno);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return alunos;
    }

    public JSONObject getJsonObjectFromAluno(Aluno aluno){
        JSONObject jsonObject = new JSONObject();
        if(aluno != null){
            jsonObject.put("id", aluno.getId());
            jsonObject.put("nome", aluno.getNome());
            jsonObject.put("email", aluno.getEmail());
        }
        return  jsonObject;
    }

    public Aluno getAlunoFromJsonObject(JSONObject jsonObject){
        Aluno aluno = null;
        if(jsonObject != null){
            int alunoId = Integer.parseInt(jsonObject.get("id").toString());
            String alunoNome = (String) jsonObject.get("nome");
            String alunoEmail = (String) jsonObject.get("email");
            aluno = new Aluno(alunoId, alunoNome, alunoEmail);
        }
        return aluno;
    }
}
