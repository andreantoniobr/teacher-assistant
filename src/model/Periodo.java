package model;

import java.util.ArrayList;

public class Periodo {
    private int id;
    private String nome;
    private ArrayList<Nota> notas = new ArrayList<>();

    public Periodo(String nome) {
        this.nome = nome;
    }

    public Periodo(String nome, ArrayList<Nota> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public Periodo(int id, String nome, ArrayList<Nota> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void adicionarNota(Nota nota) {
        notas.add(nota);
    }

    public void removerNota(Nota nota) {
        notas.remove(nota);
    }
}
