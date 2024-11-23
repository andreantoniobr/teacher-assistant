import java.util.ArrayList;

public class Aluno extends Pessoa {
    private Turma turma;
    private ArrayList<Periodo> periodos;

    public Aluno(String nome) {
        super(nome, Perfil.ALUNO);
    }


    public ArrayList<Periodo> getPeriodos() {

        return periodos;
    }

    public void adicionarPeriodo(Periodo periodos) {

        System.out.println("Periodo adicionado.");
    }

    public void removerPeriodo(Periodo periodos) {

        System.out.println("Periodo removido");
    }
}
