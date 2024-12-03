package controller;

import io.FileIO;
import model.Turma;
import java.util.ArrayList;

public class ControladorTurma {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public ControladorTurma() {
        addStartContent();
    }

    public ArrayList<Turma> getTurmas(){
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public ArrayList<Object[]>  getDadosTurmas() {
        ArrayList<Object[]> dadosTurmas = new ArrayList<>();
        for (Turma turma: turmas){
            Object[] dadoTurma = {turma.getId(), turma.getNome()};
            dadosTurmas.add(dadoTurma);
        }
        return dadosTurmas;
    }

    public Object[] getDadosTurmaPorId(int id) throws Exception {
        Turma turma = getTurmaPorId(id);
        Object[] dadoTurma = {turma.getId(), turma.getNome()};
        return dadoTurma;
    }

    public void inserirTurma(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome da turma não pode ser vazio!");
        }
        Turma turma = new Turma(nome);
        turmas.add(turma);
        FileIO.TURMA_JSON_IO.salvarTurma(turma);
    }

    public void inserirTurma(Turma turma) throws Exception {
        if(turma == null){
            throw new Exception("Objeto turma não existe!");
        }
        turmas.add(turma);
    }

    public void excluirTurma(int id) throws Exception {
        Turma turma = getTurmaPorId(id);
        turmas.remove(turma);
        FileIO.TURMA_JSON_IO.salvarTurmas(turmas);
    }

    public void editarTurma(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de turma não pode ser vazio!");
        }
        Turma turma = getTurmaPorId(id);
        if(nome.equals(turma.getNome())){
            throw new Exception("Nome de turma não foi alterado, pois é igual ao anterior!");
        }
        turma.setNome(nome);
        FileIO.TURMA_JSON_IO.salvarTurmas(turmas);
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
        if(turma == null){
            throw new Exception("Turma não encontrada!");
        }
        return turma;
    }

    public void addStartContent(){
        try {
            this.turmas.addAll(FileIO.TURMA_JSON_IO.getTurmasSalvas());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
