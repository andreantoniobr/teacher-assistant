package model.valuable;

public class Simulado extends MetodoAvaliativo {

    public Simulado() {
        super(TipoAvaliacao.SIMULADO);
    }

    public Simulado(double valor) {
        super(TipoAvaliacao.SIMULADO, valor);
    }

    public Simulado(int id, String descricao, double valor) {
        super(id, descricao, TipoAvaliacao.SIMULADO, valor);
    }
}
