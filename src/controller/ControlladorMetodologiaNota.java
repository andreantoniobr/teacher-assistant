package controller;

import model.MetodologiaNota;
import model.valuable.IValuable;

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
            Object[] dadoMetodoAvaliativo = {avaliavel.getId(), avaliavel.getNome(), avaliavel.getHashCode()};
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

    public void inserirMetodologiaNota(MetodologiaNota metodologiaNota) throws Exception {
        if(metodologiaNota == null){
            throw new Exception("Objeto metodologia não existe!");
        }
        metodologias.add(metodologiaNota);
    }

    public void excluirMedotologia(int id) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        metodologias.remove(metodologiaNota);
        //Applicantion.fileIO.excluiMetodologia(metodologiaNota);
    }

    public void editarMetodologia(int id, String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de metodologia não pode ser vazio!");
        }
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        metodologiaNota.setNome(nome);
        //Applicantion.fileIO.editarMetodologia(metodologiaNota);
    }

    public void inserirMetodoAvaliativoPorID(int id, int idMetodoAvaliativo) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        metodologiaNota.adicionarMedotoAvaliativo(Applicantion.controladorMetodoAvaliativo.getCloneMetodoAvaliativoPorId(idMetodoAvaliativo));
        //Applicantion.fileIO.excluiMetodologia(metodologiaNota);
    }

    public void removerMetodoAvaliativoPorHashCode(int id, String metodoAvaliativoHashCode) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        metodologiaNota.removerMetodoAvaliativoPorHashCode(metodoAvaliativoHashCode);
        //Applicantion.fileIO.excluiMetodoAvalitativo(metodologiaNota);
    }

    public MetodologiaNota getMetodologiaPorId(int id) throws Exception {
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
        if(metodologiaNota == null){
            throw new Exception("Metodologia não encontrada!");
        }
        return metodologiaNota;
    }

    public MetodologiaNota getCloneMetodologiaPorId(int id) throws Exception {
        MetodologiaNota metodologiaNota = getMetodologiaPorId(id);
        return (MetodologiaNota) metodologiaNota.clone();
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
