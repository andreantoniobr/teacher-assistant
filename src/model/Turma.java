package model;

import id.IdAluno;
import id.IdTurma;

public class Turma {
    private final int id;
    private String nome;

    public Turma(String nome) {
        this.id = IdTurma.getId();
        this.nome = nome;
    }

    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
        IdTurma.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
}
