package valuable;
import Id.IdMetodoAvaliativo;

public class MetodoAvaliativoOutros implements IValuable {
    private int id;
    private final TipoAvaliacao tipoAvaliacao = TipoAvaliacao.OUTROS;
    private double valor;

    public MetodoAvaliativoOutros(double valor) {
        this.id = IdMetodoAvaliativo.getId();
        this.valor = valor;
    }

    public MetodoAvaliativoOutros(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return this.valor;
    }
}