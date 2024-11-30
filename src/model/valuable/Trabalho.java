package model.valuable;

public class Trabalho extends MetodoAvaliativo{
    public Trabalho() {
        super("Trabalho", TipoAvaliacao.TRABALHO);
    }

    public Trabalho(double valor) {
        super("Trabalho", TipoAvaliacao.TRABALHO, valor);
    }

    public Trabalho(int id, String descricao, double valor) {
        super(id, "Trabalho", descricao, TipoAvaliacao.TRABALHO, valor);
    }
}
