package controller;


import model.valuable.*;
import java.util.ArrayList;

public class ControladorMetodoAvaliativo {
    private ArrayList<MetodoAvaliativo> metodosAvaliativos = new ArrayList<>();

    public ControladorMetodoAvaliativo() {
        addStartContent();
    }

    public ArrayList<Object[]>  getDadosMetodosAvaliativos() {
        ArrayList<Object[]> dadosMetodosAvaliativos = new ArrayList<>();
        for (MetodoAvaliativo metodoAvaliativo: metodosAvaliativos){
            Object[] dadoMetodoAvaliativo = {metodoAvaliativo.getId(), metodoAvaliativo.getTipoAvaliacao(), metodoAvaliativo.getHashCode()};
            dadosMetodosAvaliativos.add(dadoMetodoAvaliativo);
        }
        return dadosMetodosAvaliativos;
    }

    public Object[]  getDadosMetodoAvaliativoPorId(int id) throws Exception {
        MetodoAvaliativo metodoAvaliativo = getCloneMetodoAvaliativoPorId(id);
        Object[] dadosMetodoAvaliativo = {metodoAvaliativo.getId(), metodoAvaliativo.getTipoAvaliacao().toString(), metodoAvaliativo.getValor()};
        return dadosMetodoAvaliativo;
    }

    public void inseirMetodoAvaliativo(MetodoAvaliativo metodoAvaliativo) throws Exception {
        if(metodoAvaliativo != null){
            metodosAvaliativos.add(metodoAvaliativo);
        } else {
            throw new Exception("Objeto metodo Avaliativo não existe!");
        }
    }

    public MetodoAvaliativo getCloneMetodoAvaliativoPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de metodo Avaliativo inválido!");
        }
        MetodoAvaliativo metodoAvaliativo = null;
        for(MetodoAvaliativo a: metodosAvaliativos){
            if(a.getId() == id){
                metodoAvaliativo = a;
                break;
            }
        }
        return (MetodoAvaliativo) metodoAvaliativo.clone();
    }

    public void addStartContent(){
        try {
            Prova prova = new Prova();
            Trabalho trabalho = new Trabalho();
            Apresentacao apresentacao = new Apresentacao();
            Simulado simulado = new Simulado();

            metodosAvaliativos.add(prova);
            metodosAvaliativos.add(trabalho);
            metodosAvaliativos.add(apresentacao);
            metodosAvaliativos.add(simulado);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
