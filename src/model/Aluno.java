package model;

import id.IdAluno;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int id;
    private Turma turma;
    private ArrayList<Periodo> periodos = new ArrayList<>();

    public Aluno(int id, String nome) {
        super(id, nome, Perfil.ALUNO);
    }

    public Aluno(String nome) {
        super(IdAluno.getId(), nome, Perfil.ALUNO);
    }

    public Aluno(String nome, String email) {
        super(IdAluno.getId(), nome, email, Perfil.ALUNO);
    }

    public Aluno(int id, String nome, String email) {
        super(id, nome, email, Perfil.ALUNO);
    }

    public ArrayList<Periodo> getPeriodos() {
        return periodos;
    }

    public Periodo getPeriodoPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de Período inválido!");
        }
        Periodo periodo = null;
        for(Periodo a: periodos){
            if(a.getId() == id){
                periodo = a;
                break;
            }
        }
        return periodo;
    }

    public void setPeriodoPorId(int id, Periodo novoPeriodo) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        periodo = novoPeriodo;
    }

    public Turma getTurma(){
        return this.turma;
    }

    public void setTurma(Turma turma){
        this.turma = turma;
    }

    public void adicionarPeriodo(Periodo periodo) {
        periodos.add(periodo);
    }

    public void removerPeriodo(Periodo periodo) {
        periodos.remove(periodo);
    }
}
