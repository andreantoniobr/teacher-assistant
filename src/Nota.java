import java.util.ArrayList;

public class Nota {
    private int id;
    private ArrayList<MetodoAvaliativo> metodosAvaliativos;

    public void adicionarMedotoAvaliativo(MetodoAvaliativo metodoAvaliativo) {
        this.metodosAvaliativos.add(metodoAvaliativo);
        System.out.println("Adicionado Metodo Avaliativo");
    }
    public void removerMetodoAvaliativo(MetodoAvaliativo metodoAvaliativo) {
        this.metodosAvaliativos.remove(metodoAvaliativo);
        System.out.println("Removido Metodo Avaliativo");
    }

    public double calcularNota() {
        double total = 0;
        for (MetodoAvaliativo metodoAvaliativo : metodosAvaliativos){
            total += metodoAvaliativo.getValor();
        }
        return total;
    }
}
