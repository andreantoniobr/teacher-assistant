package model.valuable;

import id.IdMetodoAvaliativo;

public class MetodoAvaliativo implements IValuable {
    private int id;
    private String descricao;
    private TipoAvaliacao tipoAvaliacao;
    private double valor;

    public MetodoAvaliativo(TipoAvaliacao tipoAvaliacao) {
        this.id = IdMetodoAvaliativo.getId();
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public MetodoAvaliativo(TipoAvaliacao tipoAvaliacao, double valor) {
        this.id = IdMetodoAvaliativo.getId();
        this.tipoAvaliacao = tipoAvaliacao;
        this.valor = valor;
    }

    public MetodoAvaliativo(int id, String descricao, TipoAvaliacao tipoAvaliacao, double valor) {
        this.id = id;
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
}
