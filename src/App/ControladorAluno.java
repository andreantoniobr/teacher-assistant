package App;

import java.util.ArrayList;

public class ControladorAluno {
    ArrayList<Aluno> alunos = new ArrayList<>();

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
    }

    public boolean excluirAluno(int id){
        boolean excluiuAluno = false;
        for(Aluno aluno: alunos){
            if(aluno.getId() == id){
                alunos.remove(aluno);
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
                aluno.setNome(nome);
                aluno.setEmail(email);
                editouAluno = true;
                break;
            }
        }
        return editouAluno;
    }

    public void addStartContent(){
        inserirAluno(new Aluno("Andre Antonio Bezerra"));
        inserirAluno(new Aluno("Paulo Kaike"));
        inserirAluno(new Aluno("Junior Silva"));
    }
}
