package App;

import Id.IdProfessor;

public class Professor extends Pessoa {
    public Professor(String nome) {
        super(IdProfessor.getId(), nome, Perfil.PROFESSOR);
    }
}
