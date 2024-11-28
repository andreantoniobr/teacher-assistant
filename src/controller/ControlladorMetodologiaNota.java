package controller;

import model.MetodologiaNota;
import model.Turma;

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
            if(nome.equals(metodologiaNota.getNome())){
                throw new Exception("Nome de metodologia não foi alterado, pois é igual ao anterior!");
            }
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

            inserirMetodologia(m1.getNome());
            inserirMetodologia(m2.getNome());
            inserirMetodologia(m3.getNome());
            //this.metodologias.addAll(Applicantion.fileIO.getMetodologiasSalvas());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
