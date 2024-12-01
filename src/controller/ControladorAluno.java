package controller;

import model.Aluno;
import model.MetodologiaNota;
import model.Periodo;
import model.Turma;

import java.util.ArrayList;

public class ControladorAluno {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public ControladorAluno() {
        addStartContent();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Object[]> getDadosAlunos() {
        ArrayList<Object[]> dadosAlunos = new ArrayList<>();
        for (Aluno aluno: alunos){
            String turmaNome = "";
            Turma turma = aluno.getTurma();
            if (turma != null){
                turmaNome = turma.getNome();
            }
            Object[] dadoAluno = {aluno.getId(), aluno.getNome(), aluno.getEmail(), turmaNome};
            dadosAlunos.add(dadoAluno);
        }
        return dadosAlunos;
    }

    public Object[] getDadosAlunoPorId(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        if(aluno != null){
            int idTurma = -1;
            if(aluno.getTurma() != null){
                idTurma = aluno.getTurma().getId();
            }
            Object[] dadoAluno = {aluno.getNome(), aluno.getEmail(), idTurma};
            return dadoAluno;
        } else {
            throw new Exception("Aluno não encontrado!");
        }
    }

    public ArrayList<Object[]> getNotasAlunoPorId(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        if(aluno != null){
            ArrayList<Object[]> notas = new ArrayList<>();
            for (Periodo periodo: aluno.getPeriodos()) {
                for(MetodologiaNota metodologiaNota: periodo.getNotas()){
                    Object[] nota = {periodo.getNome(), metodologiaNota.getNome(), metodologiaNota.valorTotal()};
                    notas.add(nota);
                }
            }
            return notas;
        } else {
            throw new Exception("Aluno não encontrado!");
        }
    }

    public void inserirAluno(String nome, String email) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do aluno não pode ser vazio!");
        }
        Aluno aluno = new Aluno(nome, email);
        inserirAluno(aluno);
        Applicantion.fileIO.salvarAluno(aluno);
    }

    public void inserirAluno(Aluno aluno) throws Exception {
        if(aluno == null){
            throw new Exception("Objeto aluno não existe!");
        }
        alunos.add(aluno);
    }

    public void excluirAluno(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        if(aluno != null){
            alunos.remove(aluno);
            Applicantion.fileIO.excluiAluno(aluno);
        } else {
            throw new Exception("Aluno não encontrado!");
        }
    }

    public void editarAluno(int id, String nome, String email, int idTurma) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de aluno não pode ser vazio!");
        }
        Aluno aluno = getAlunoPorId(id);
        if(aluno != null){
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setTurma(Applicantion.controladorTurma.getTurmaPorId(idTurma));
            Applicantion.fileIO.editaAluno(aluno);
        } else {
            throw new Exception("Aluno não encontrado!");
        }
    }

    private Aluno getAlunoPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de aluno inválido!");
        }
        Aluno aluno = null;
        for(Aluno a: alunos){
            if(a.getId() == id){
                aluno = a;
                break;
            }
        }
        return aluno;
    }

    public void addStartContent(){
        try {
            Aluno a1 = new Aluno("Andre Antonio Bezerra");
            Aluno a2 = new Aluno("Paulo Kaike");
            Aluno a3 = new Aluno("Junior Silva");
            inserirAluno(a1);
            inserirAluno(a2);
            inserirAluno(a3);
            this.alunos.addAll(Applicantion.fileIO.getAlunosSalvos());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
