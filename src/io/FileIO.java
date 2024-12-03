package io;

import io.json.AlunoJsonIO;
import io.json.TurmaJsonIO;

public class FileIO {
    private final static String FILE_PATH_ALUNO = "files/json/aluno.json";
    private final static String FILE_PATH_TURMA = "files/json/turma.json";

    public final static AlunoJsonIO ALUNO_JSON_IO = new AlunoJsonIO(FILE_PATH_ALUNO);
    public final static TurmaJsonIO TURMA_JSON_IO = new TurmaJsonIO(FILE_PATH_TURMA);
}
