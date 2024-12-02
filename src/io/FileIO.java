package io;

import model.Aluno;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {
    private final String pathArquivoAluno = "json/aluno.json";

    public void salvarAluno(Aluno aluno){
        //Cria JsonWriter
        JSONWriter jsonWriter = new JSONWriter(pathArquivoAluno);

        //Cria um Objeto JSON
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("id", aluno.getId());
        jsonObject.put("nome", aluno.getNome());
        jsonObject.put("email", aluno.getEmail());

        //Adiciona no arquivo sem apagar os outros
        jsonWriter.appendObjectInFileJSON(jsonObject);
    }

    public void editaAluno(Aluno aluno){
        //Recebe um aluno e edita ele no arquivo
    }

    public void excluiAluno(Aluno aluno){
        //Recebe um aluno e exclui ele do arquivo
    }

    public ArrayList<Aluno> getAlunosSalvos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        //escrever aqui como vai ser para retornar os alunos que estão salvos no arquivo
        return alunos;
    }
}
