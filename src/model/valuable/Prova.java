package model.valuable;

public class Prova extends MetodoAvaliativo {
    public Prova() {
        super("Prova", TipoAvaliacao.PROVA);
    }

    public Prova(double valor) {
        super("Prova", TipoAvaliacao.PROVA, valor);
    }

    public Prova(int id, String descricao, double valor) {
        super(id,"Prova", descricao, TipoAvaliacao.PROVA, valor);
    }
}
