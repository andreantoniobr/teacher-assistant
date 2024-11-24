package App;

import java.util.ArrayList;

public class Aplicantion {
    ArrayList<Aluno> alunos = new ArrayList<>();

    public Aplicantion() {


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

    public String GetTodosAlunos(){
        StringBuilder listaAlunosText = new StringBuilder();

        for (Aluno aluno: alunos){
            String emailText;
            if(aluno.getEmail() == null || aluno.getEmail().isEmpty()){
                emailText = " | Sem e-mail Cadastrado.";
            } else {
                emailText = " | E-mail: " + aluno.getEmail();
            }

            listaAlunosText.append(aluno.getNome()).append(emailText).append("\n");
        }
        return listaAlunosText.toString();
    }
}
