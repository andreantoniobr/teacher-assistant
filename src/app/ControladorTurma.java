package app;

import java.util.ArrayList;

public class ControladorTurma {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public ControladorTurma() {
        addStartContent();
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public void inserirTurma(Turma turma){
        turmas.add(turma);
    }

    public boolean excluirTurma(int id){
        boolean excluiuTurma = false;
        for(Turma turma: turmas){
            if(turma.getId() == id){
                turmas.remove(turma);
                excluiuTurma = true;
                break;
            }
        }
        return excluiuTurma;
    }

    public boolean editarTurma(int id, String nome){
        boolean editouTurma = false;

        for(Turma turma: turmas){
            if(turma.getId() == id){
                if(nome != null && !nome.isEmpty() && !turma.getNome().equals(nome)){
                    turma.setNome(nome);
                    editouTurma = true;
                    break;
                }
            }
        }
        return editouTurma;
    }

    public void addStartContent(){
        Turma t1 = new Turma("Turma A");
        Turma t2 = new Turma("Turma B");
        inserirTurma(t1);
        inserirTurma(t2);
    }
}
