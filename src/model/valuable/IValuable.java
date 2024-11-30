package model.valuable;

public interface IValuable {
    public int getId();
    public String getNome();
    public void setValor(double valor);
    public double getValor();
    public String getHashCode();
}
