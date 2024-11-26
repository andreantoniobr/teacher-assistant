package model;

import java.util.ArrayList;

public class Periodo {
    private int id;
    private String nome;
    private ArrayList<MetodologiaNota> metodologiaNotas = new ArrayList<>();

    public Periodo(String nome) {
        this.nome = nome;
    }

    public Periodo(String nome, ArrayList<MetodologiaNota> metodologiaNotas) {
        this.nome = nome;
        this.metodologiaNotas = metodologiaNotas;
    }

    public Periodo(int id, String nome, ArrayList<MetodologiaNota> metodologiaNotas) {
        this.id = id;
        this.nome = nome;
        this.metodologiaNotas = metodologiaNotas;
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

    public void adicionarMetodologiaNota(MetodologiaNota metodologiaNota) {
        metodologiaNotas.add(metodologiaNota);
    }

    public void removerMetodologiaNota(MetodologiaNota metodologiaNota) {
        metodologiaNotas.remove(metodologiaNota);
    }
}
