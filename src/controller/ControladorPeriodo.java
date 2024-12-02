package controller;

import model.MetodologiaNota;
import model.Periodo;

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

    public ArrayList<Object[]>  getMetodologiasPorId(int id) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        ArrayList<Object[]> dadosMetodologias = new ArrayList<>();
        for (MetodologiaNota metodologia: periodo.getNotas()){
            Object[] dadoMetodoAvaliativo = {metodologia.getId(), metodologia.getNome(), metodologia.getHashCode()};
            dadosMetodologias.add(dadoMetodoAvaliativo);
        }
        return dadosMetodologias;
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

    public void inserirPeriodo(Periodo periodo) throws Exception {
        if(periodo == null){
            throw new Exception("Objeto periodo não existe!");
        }
        periodos.add(periodo);
    }

    public void excluirPeriodo(int id) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        periodos.remove(periodo);
        //Applicantion.fileIO.excluiPeriodo(periodo);
    }

    public void editarPeriodo(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do período não pode ser vazio!");
        }
        Periodo periodo = getPeriodoPorId(id);
        periodo.setNome(nome);
        //Applicantion.fileIO.editarPeriodo(periodo);
    }

    public void inserirMetodologiaPorID(int id, int idMetodologia) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        periodo.adicionarMetodologiaNota(Applicantion.controlladorMetodologiaNota.getCloneMetodologiaPorId(idMetodologia));
    }

    public void removerMetodologiaPorHashCode(int id, String metodologiaHashCode) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        periodo.removerMetodologiaPorHashCode(metodologiaHashCode);
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
        if(periodo == null){
            throw new Exception("Período não encontrado!");
        }
        return periodo;
    }

    public Periodo getClonePeriodoPorId(int id) throws Exception {
        Periodo periodo = getPeriodoPorId(id);
        System.out.println("PeriodoOriginal: " + periodo.toString());
        return (Periodo) periodo.clone();
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
