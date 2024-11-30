package model.valuable;

public class Apresentacao extends MetodoAvaliativo {
    public Apresentacao() {
        super("Apresentação", TipoAvaliacao.APRESENTACAO);
    }

    public Apresentacao(double valor) {
        super("Apresentação", TipoAvaliacao.APRESENTACAO, valor);
    }

    public Apresentacao(int id, String descricao, double valor) {
        super(id, "Apresentação", descricao, TipoAvaliacao.APRESENTACAO, valor);
    }
}
