package app;

import java.util.ArrayList;

public class ControladorAluno {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public ControladorAluno() {
        addStartContent();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void inserirAluno(Aluno aluno){
        alunos.add(aluno);
        Applicantion.fileIO.salvarAluno(aluno);
    }

    public boolean excluirAluno(int id){
        boolean excluiuAluno = false;
        for(Aluno aluno: alunos){
            if(aluno.getId() == id){
                alunos.remove(aluno);
                Applicantion.fileIO.excluiAluno(aluno);
                excluiuAluno = true;
                break;
            }
        }
        return excluiuAluno;
    }

    public boolean editarAluno(int id, String nome, String email){
        boolean editouAluno = false;
        for(Aluno aluno: alunos){
            if(aluno.getId() == id){
                if(nomeValido(nome, aluno)){
                    aluno.setNome(nome);
                    aluno.setEmail(email);
                    Applicantion.fileIO.editaAluno(aluno);
                    editouAluno = true;
                    break;
                }
            }
        }
        return editouAluno;
    }

    private boolean nomeValido(String nome, Aluno aluno) {
        return nome != null && !nome.isEmpty() && !aluno.getNome().equals(nome);
    }

    public void addStartContent(){
        inserirAluno(new Aluno("Andre Antonio Bezerra"));
        inserirAluno(new Aluno("Paulo Kaike"));
        inserirAluno(new Aluno("Junior Silva"));
        this.alunos.addAll(Applicantion.fileIO.getAlunosSalvos());
    }
}
