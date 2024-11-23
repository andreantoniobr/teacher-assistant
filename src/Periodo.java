import java.util.ArrayList;
public class Periodo {
    private int id;
    private String nome;
    private ArrayList<Nota> notas;


    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void adicionarNota(Nota nota) {
        notas.add(nota);
        System.out.println("Nota adicionada.");
    }

    public void removerNota(Nota nota) {
        notas.remove(nota);
        System.out.println("Nota Removida.");
    }
}
