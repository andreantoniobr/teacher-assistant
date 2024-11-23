package valuable;

public class Prova extends MetodoAvaliativo {
    public Prova() {
        super(TipoAvaliacao.PROVA);
    }

    public Prova(double valor) {
        super(TipoAvaliacao.PROVA, valor);
    }

    public Prova(int id, String descricao, double valor) {
        super(id, descricao, TipoAvaliacao.PROVA, valor);
    }
}
