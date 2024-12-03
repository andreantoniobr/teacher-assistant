package io;

import model.Aluno;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class FileIO {
    private final static String filePathAluno = "files/json/aluno.json";

    public final static AlunoIO alunoIO = new AlunoIO(filePathAluno);
}
