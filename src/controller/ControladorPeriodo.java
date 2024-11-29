package controller;

import model.Periodo;
import model.Turma;

import java.util.ArrayList;

public class ControladorPeriodo {
    private ArrayList<Periodo> periodos = new ArrayList<>();

    public ControladorPeriodo() {
        addStartContent();
    }

    public ArrayList<Object[]>  getDadosPeriodos() {
        ArrayList<Object[]> dadosPeriodos = new ArrayList<>();
        for (Periodo periodo: periodos){
            Object[] dadoPeriodo = {periodo.getId(), periodo.getNome()};
            dadosPeriodos.add(dadoPeriodo);
        }
        return dadosPeriodos;
    }

    public void setPeriodos(ArrayList<Periodo> periodos) {
        this.periodos = periodos;
    }

    public void inserirPeriodo(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do período não pode ser vazio!");
        }
        Periodo periodo = new Periodo(nome);
        periodos.add(periodo);
        //Applicantion.fileIO.salvarPeriodo(periodo);
    }

    public void excluirPeriodo(int id) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        if(periodo != null){
            periodos.remove(periodo);
            //Applicantion.fileIO.excluiPeriodo(periodo);
        } else {
            throw new Exception("Período não encontrado!");
        }
    }

    public void editarPeriodo(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do período não pode ser vazio!");
        }
        Periodo periodo = getPeriodoPorId(id);
        if(periodo != null){
            if(nome.equals(periodo.getNome())){
                throw new Exception("Nome do período não foi alterado, pois é igual ao anterior!");
            }
            periodo.setNome(nome);
            //Applicantion.fileIO.editarPeriodo(periodo);
        } else {
            throw new Exception("Período não encontrado!");
        }
    }

    private Periodo getPeriodoPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de Turma inválido!");
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

    public void addStartContent(){
        try {
            inserirPeriodo("P1");
            inserirPeriodo("P2");
            //this.periodos.addAll(Applicantion.fileIO.getPeriodosSalvos());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
