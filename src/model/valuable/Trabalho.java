package model.valuable;

public class Trabalho extends MetodoAvaliativo{
    public Trabalho() {
        super(TipoAvaliacao.TRABALHO);
    }

    public Trabalho(double valor) {
        super(TipoAvaliacao.TRABALHO, valor);
    }

    public Trabalho(int id, String descricao, double valor) {
        super(id, descricao, TipoAvaliacao.TRABALHO, valor);
    }
}
