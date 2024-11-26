package model;

import id.IdProfessor;

public class Professor extends Pessoa {
    public Professor(String nome) {
        super(IdProfessor.getId(), nome, Perfil.PROFESSOR);
    }
}
