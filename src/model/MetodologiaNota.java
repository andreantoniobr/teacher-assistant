package model;

import id.IdMetodologiaNota;
import model.valuable.IValuable;
import java.util.ArrayList;

public class MetodologiaNota implements Cloneable {
    private int id;
    private String nome;
    private ArrayList<IValuable> avaliaveis = new ArrayList<>();
    private String idHash;

    public MetodologiaNota(String nome){
        this.id = IdMetodologiaNota.getId();
        this.nome = nome;
    }

    public MetodologiaNota(int id, String nome) {
        this.id = id;
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

    public void removerMetodoAvaliativoPorHashCode(String hashCode) {
        for (IValuable avaliavel: avaliaveis){
            if(hashCode.equals(avaliavel.getHashCode())){
                this.avaliaveis.remove(avaliavel);
                break;
            }
        }
    }

    public IValuable getMetodoAvaliativoPorHashCode(String hashCode) {
        for (IValuable avaliavel: avaliaveis){
            if(hashCode.equals(avaliavel.getHashCode())){
                return avaliavel;
            }
        }
        return null;
    }

    public double valorTotal() {
        double total = 0;
        for (IValuable avaliavel : avaliaveis){
            total += avaliavel.getValor();
        }
        return total;
    }

    public void setHashCode(String hashcode){
        this.idHash = hashcode;
    }

    public String getHashCode(){
        if(idHash == null || idHash.isEmpty()){
            idHash = Integer.toHexString(this.hashCode());
        }
        return idHash;
    }

    public MetodologiaNota clone() throws CloneNotSupportedException
    {
        MetodologiaNota m = (MetodologiaNota) super.clone();
        return m;
    }
}
