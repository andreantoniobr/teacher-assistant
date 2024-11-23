public class MetodoAvaliativo {
    private String descricao;
    private TipoAvaliacao tipoAvaliacao;
    private double valor;

//---------------------------------------------------
//Setters.
    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {

        this.tipoAvaliacao = tipoAvaliacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
