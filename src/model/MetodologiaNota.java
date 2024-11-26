package model;

import id.IdMetodologiaNota;
import model.valuable.IValuable;
import java.util.ArrayList;

public class MetodologiaNota {
    private int id;
    private String nome;
    private ArrayList<IValuable> avaliaveis = new ArrayList<>();

    public MetodologiaNota(String nome){
        this.id = IdMetodologiaNota.getId();
        this.nome = nome;
    }

    public MetodologiaNota(String nome, ArrayList<IValuable> avaliaveis) {
        this.id = IdMetodologiaNota.getId();
        this.nome = nome;
        this.avaliaveis = avaliaveis;
    }

    public MetodologiaNota(int id, String nome, ArrayList<IValuable> avaliaveis) {
        this.id = id;
        this.nome = nome;
        this.avaliaveis = avaliaveis;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<IValuable> getAvaliaveis() {
        return avaliaveis;
    }

    public void adicionarMedotoAvaliativo(IValuable avaliavel) {
        this.avaliaveis.add(avaliavel);
    }

    public void removerMetodoAvaliativo(IValuable avaliavel) {
        this.avaliaveis.remove(avaliavel);
    }

    public double valorTotal() {
        double total = 0;
        for (IValuable avaliavel : avaliaveis){
            total += avaliavel.getValor();
        }
        return total;
    }
}
