package model;

import id.IdAluno;
import id.IdPeriodo;
import model.valuable.IValuable;

import java.util.ArrayList;

public class Periodo implements Cloneable{
    private int id;
    private String nome;
    private ArrayList<MetodologiaNota> metodologiaNotas = new ArrayList<>();

    public Periodo(String nome) {
        this.id = IdPeriodo.getId();
        this.nome = nome;
    }

    public Periodo(int id, String nome) {
        this.id = id;
        this.nome = nome;
        IdPeriodo.setId(id);
    }

    public Periodo(String nome, ArrayList<MetodologiaNota> metodologiaNotas) {
        this.id = IdPeriodo.getId();
        this.nome = nome;
        this.metodologiaNotas = metodologiaNotas;
    }

    public Periodo(int id, String nome, ArrayList<MetodologiaNota> metodologiaNotas) {
        this.id = id;
        this.nome = nome;
        this.metodologiaNotas = metodologiaNotas;
        IdPeriodo.setId(id);
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

    public void setMetodologiaNotasNotas(ArrayList<MetodologiaNota> metodologiaNotas) {
        this.metodologiaNotas = metodologiaNotas;
    }

    public ArrayList<MetodologiaNota> getNotas() {
        return metodologiaNotas;
    }

    public void removerTodasMetodologias() {
        metodologiaNotas.clear();
    }

    public void adicionarMetodologiaNota(MetodologiaNota metodologiaNota) {
        metodologiaNotas.add(metodologiaNota);
    }

    public void removerMetodologiaNota(MetodologiaNota metodologiaNota) {
        metodologiaNotas.remove(metodologiaNota);
    }

    public void removerMetodologiaPorHashCode(String hashCode) {
        for (MetodologiaNota metodologiaNota: metodologiaNotas){
            if(hashCode.equals(metodologiaNota.getHashCode())){
                this.metodologiaNotas.remove(metodologiaNota);
                break;
            }
        }
    }

    public MetodologiaNota getMetodologiaPorHashCode(String hashCode) {
        for (MetodologiaNota metodologiaNota: metodologiaNotas){
            if(hashCode.equals(metodologiaNota.getHashCode())){
                return metodologiaNota;
            }
        }
        return null;
    }

    public String getHashCode(){
        return Integer.toHexString(this.hashCode());
    }

    public Object clone() throws CloneNotSupportedException
    {
        Periodo p = (Periodo) super.clone();
        ArrayList<MetodologiaNota> newMetodologiaNotas = new ArrayList<>();
        for (int i = 0; i < metodologiaNotas.size() ; i++) {
            newMetodologiaNotas.add(metodologiaNotas.get(i).clone());
        }
        metodologiaNotas = newMetodologiaNotas;
        return p;
    }
}
