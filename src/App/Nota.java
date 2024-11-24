package App;

import Id.IdNota;
import valuable.IValuable;
import java.util.ArrayList;

public class Nota {
    private int id;
    private ArrayList<IValuable> avaliaveis = new ArrayList<>();

    public Nota(IValuable metodoAvaliativo) {
        this.id = IdNota.getId();
        adicionarMedotoAvaliativo(metodoAvaliativo);
    }

    public Nota(ArrayList<IValuable> avaliaveis) {
        this.id = IdNota.getId();
        this.avaliaveis = avaliaveis;
    }

    public Nota(int id, ArrayList<IValuable> avaliaveis) {
        this.id = id;
        this.avaliaveis = avaliaveis;
    }

    public int getId() {
        return id;
    }

    public ArrayList<IValuable> getAvaliaveis() {
        return avaliaveis;
    }

    public void adicionarMedotoAvaliativo(IValuable avaliavel) {
        this.avaliaveis.add(avaliavel);
    }

    public void removerMetodoAvaliativo(IValuable avaliavel) {
        this.avaliaveis.remove(avaliavel);
    }

    public double valorTotal() {
        double total = 0;
        for (IValuable avaliavel : avaliaveis){
            total += avaliavel.getValor();
        }
        return total;
    }
}
