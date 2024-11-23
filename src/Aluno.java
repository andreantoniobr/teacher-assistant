import Id.IdAluno;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int id;
    private Turma turma;
    private ArrayList<Periodo> periodos = new ArrayList<>();

    public Aluno(String nome) {
        super(IdAluno.getId(), nome, Perfil.ALUNO);
    }

    public ArrayList<Periodo> getPeriodos() {
        return periodos;
    }

    public void adicionarPeriodo(Periodo periodo) {
        periodos.add(periodo);
    }

    public void removerPeriodo(Periodo periodo) {
        periodos.remove(periodo);
    }
}
