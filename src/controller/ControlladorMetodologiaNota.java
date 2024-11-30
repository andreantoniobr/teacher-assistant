package controller;

import model.MetodologiaNota;
import model.Turma;
import model.valuable.IValuable;
import model.valuable.MetodoAvaliativo;

import java.util.ArrayList;

public class ControlladorMetodologiaNota {
    private ArrayList<MetodologiaNota> metodologias = new ArrayList<>();

    public ControlladorMetodologiaNota() {
        addStartContent();
    }

    public ArrayList<Object[]>  getDadosMetodologias() {
        ArrayList<Object[]> dadosMetodologias = new ArrayList<>();
        for (MetodologiaNota metodologiaNota: metodologias){
            Object[] dadoMetodologias = {metodologiaNota.getId(), metodologiaNota.getNome()};
            dadosMetodologias.add(dadoMetodologias);
        }
        return dadosMetodologias;
    }

    public ArrayList<Object[]>  getMetodosAvaliativosPorId(int id) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        if(metodologiaNota == null){
            throw new Exception("Objeto metodologia não existe!");
        }
        ArrayList<Object[]> dadosMetodosAvaliativos = new ArrayList<>();
        for (IValuable avaliavel: metodologiaNota.getAvaliaveis()){
            Object[] dadoMetodoAvaliativo = {avaliavel.getId(), avaliavel.getNome()};
            dadosMetodosAvaliativos.add(dadoMetodoAvaliativo);
        }
        return dadosMetodosAvaliativos;
    }

    public void setMetodologias(ArrayList<MetodologiaNota> metodologias) {
        this.metodologias = metodologias;
    }

    public void inserirMetodologia(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome da metodologia não pode ser vazio!");
        }
        MetodologiaNota metodologiaNota = new MetodologiaNota(nome);
        metodologias.add(metodologiaNota);
        //Applicantion.fileIO.salvarMetodologia(metodologiaNota);
    }

    public void excluirMedotologia(int id) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        if(metodologiaNota != null){
            metodologias.remove(metodologiaNota);
            //Applicantion.fileIO.excluiMetodologia(metodologiaNota);
        } else {
            throw new Exception("Metodologia não encontrada!");
        }
    }

    public void editarMetodologia(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de metodologia não pode ser vazio!");
        }
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        if(metodologiaNota != null){
            metodologiaNota.setNome(nome);
            //Applicantion.fileIO.editarMetodologia(metodologiaNota);
        } else {
            throw new Exception("Metodologia não encontrada!");
        }
    }

    public void inserirMetodoAvaliativoPorID(int id, int idMetodoAvaliativo) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        if(metodologiaNota != null){
            metodologiaNota.adicionarMedotoAvaliativo(Applicantion.controladorMetodoAvaliativo.getMetodoAvaliativoPorId(idMetodoAvaliativo));
            //Applicantion.fileIO.excluiMetodologia(metodologiaNota);
        } else {
            throw new Exception("Metodologia não encontrada!");
        }

    }

    private MetodologiaNota getMetodologiaPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de metodologia inválido!");
        }
        MetodologiaNota metodologiaNota = null;
        for(MetodologiaNota a: metodologias){
            if(a.getId() == id){
                metodologiaNota = a;
                break;
            }
        }
        return metodologiaNota;
    }

    public void addStartContent(){
        try {
            MetodologiaNota m1 = new MetodologiaNota("Metodologia A");
            MetodologiaNota m2 = new MetodologiaNota("Metodologia B");
            MetodologiaNota m3 = new MetodologiaNota("Metodologia C");

            metodologias.add(m1);
            metodologias.add(m2);
            metodologias.add(m3);
            //this.metodologias.addAll(Applicantion.fileIO.getMetodologiasSalvas());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
