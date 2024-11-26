package controller;

import model.Aluno;
import java.util.ArrayList;

public class ControladorAluno {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public ControladorAluno() {
        addStartContent();
    }

    public ArrayList<Object[]> getDadosAlunos() {
        ArrayList<Object[]> dadosAlunos = new ArrayList<>();
        for (Aluno aluno: alunos){
            Object[] dadoAluno = {aluno.getId(), aluno.getNome(), aluno.getEmail()};
            dadosAlunos.add(dadoAluno);
        }
        return dadosAlunos;
    }

    public void inserirAluno(String nome, String email) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do aluno não pode ser vazio!");
        }
        Aluno aluno = new Aluno(nome, email);
        alunos.add(aluno);
        Applicantion.fileIO.salvarAluno(aluno);
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

    public void editarAluno(int id, String nome, String email) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de aluno não pode ser vazio!");
        }
        Aluno aluno = getAlunoPorId(id);
        if(aluno != null){
            if(nome.equals(aluno.getNome())){
                throw new Exception("Nome de aluno não foi alterado, pois é iqual ao anterior!");
            }
            aluno.setNome(nome);
            aluno.setEmail(email);
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
            inserirAluno(a1.getNome(), a1.getEmail());
            inserirAluno(a2.getNome(), a2.getEmail());
            inserirAluno(a3.getNome(), a3.getEmail());
            this.alunos.addAll(Applicantion.fileIO.getAlunosSalvos());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
