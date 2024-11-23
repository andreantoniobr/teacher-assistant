package valuable;

public class Apresentacao extends MetodoAvaliativo {
    public Apresentacao() {
        super(TipoAvaliacao.APRESENTACAO);
    }

    public Apresentacao(double valor) {
        super(TipoAvaliacao.APRESENTACAO, valor);
    }

    public Apresentacao(int id, String descricao, double valor) {
        super(id, descricao, TipoAvaliacao.APRESENTACAO, valor);
    }
}
