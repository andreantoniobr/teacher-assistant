package controller;

import model.Turma;
import java.util.ArrayList;

public class ControladorTurma {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public ControladorTurma() {
        addStartContent();
    }

    public ArrayList<Object[]>  getDadosTurmas() {
        ArrayList<Object[]> dadosTurmas = new ArrayList<>();
        for (Turma turma: turmas){
            Object[] dadoTurma = {turma.getId(), turma.getNome()};
            dadosTurmas.add(dadoTurma);
        }
        return dadosTurmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public void inserirTurma(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome da turma não pode ser vazio!");
        }
        Turma turma = new Turma(nome);
        turmas.add(turma);
        //Applicantion.fileIO.salvarTurma(turma);
    }

    public void excluirTurma(int id) throws Exception {
        Turma turma = getTurmaPorId(id);
        if(turma != null){
            turmas.remove(turma);
            //Applicantion.fileIO.excluiTurma(turma);
        } else {
            throw new Exception("Turma não encontrada!");
        }
    }

    public void editarTurma(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de turma não pode ser vazio!");
        }
        Turma turma = getTurmaPorId(id);
        if(turma != null){
            if(nome.equals(turma.getNome())){
                throw new Exception("Nome de turma não foi alterado, pois é igual ao anterior!");
            }
            turma.setNome(nome);
            //Applicantion.fileIO.editarTurma(turma);
        } else {
            throw new Exception("Turma não encontrada!");
        }
    }

    public Turma getTurmaPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de Turma inválido!");
        }
        Turma turma = null;
        for(Turma a: turmas){
            if(a.getId() == id){
                turma = a;
                break;
            }
        }
        return turma;
    }

    public void addStartContent(){
        try {
            inserirTurma("Turma A");
            inserirTurma("Turma B");
            //this.turmas.addAll(Applicantion.fileIO.getTurmasSalvas());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
