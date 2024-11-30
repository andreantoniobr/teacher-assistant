package model.valuable;

public class Simulado extends MetodoAvaliativo {

    public Simulado() {
        super("Simulado", TipoAvaliacao.SIMULADO);
    }

    public Simulado(double valor) {
        super("Simulado",TipoAvaliacao.SIMULADO, valor);
    }

    public Simulado(int id, String descricao, double valor) {
        super(id, "Simulado", descricao, TipoAvaliacao.SIMULADO, valor);
    }
}
