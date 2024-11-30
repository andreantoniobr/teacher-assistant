package model.valuable;

import id.IdMetodoAvaliativo;

public class MetodoAvaliativo implements IValuable, Cloneable {
    private int id;
    private String nome;
    private String descricao;
    private TipoAvaliacao tipoAvaliacao;
    private double valor;

    public MetodoAvaliativo(String nome, TipoAvaliacao tipoAvaliacao) {
        this.id = IdMetodoAvaliativo.getId();
        this.nome = nome;
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public MetodoAvaliativo(String nome, TipoAvaliacao tipoAvaliacao, double valor) {
        this.id = IdMetodoAvaliativo.getId();
        this.nome = nome;
        this.tipoAvaliacao = tipoAvaliacao;
        this.valor = valor;
    }

    public MetodoAvaliativo(int id, String nome, String descricao, TipoAvaliacao tipoAvaliacao, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoAvaliacao = tipoAvaliacao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getHashCode(){
        return Integer.toHexString(this.hashCode());
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
