package model.valuable;
import id.IdMetodoAvaliativo;

public class MetodoAvaliativoOutros implements IValuable {
    private int id;
    private String nome;
    private final TipoAvaliacao tipoAvaliacao = TipoAvaliacao.OUTROS;
    private double valor;

    public MetodoAvaliativoOutros(String nome) {
        this.id = IdMetodoAvaliativo.getId();
        this.nome = nome;
    }

    public MetodoAvaliativoOutros(String nome, double valor) {
        this.id = IdMetodoAvaliativo.getId();
        this.nome = nome;
        this.valor = valor;
    }

    public MetodoAvaliativoOutros(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public String getHashCode(){
        return Integer.toHexString(this.hashCode());
    }
}
