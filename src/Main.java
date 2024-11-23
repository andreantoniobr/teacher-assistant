import valuable.IValuable;
import valuable.Prova;
import valuable.Trabalho;
import valuable.Apresentacao;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Andre");
        Aluno aluno2 = new Aluno("Davi");
        Aluno aluno3 = new Aluno("Paulo Kaike");

        Prova prova1 = new Prova(10);
        Apresentacao apresentacao1 = new Apresentacao(5);
        Trabalho trabalho1 = new Trabalho(7.5);

        ArrayList<IValuable> avaliaveis = new ArrayList<>();
        avaliaveis.add(prova1);
        avaliaveis.add(apresentacao1);
        avaliaveis.add(trabalho1);

        Nota n1 = new Nota(avaliaveis);

        Periodo p1 = new Periodo("Periodo 1");
        p1.adicionarNota(n1);

        aluno1.adicionarPeriodo(p1);

        for (Periodo periodo : aluno1.getPeriodos()){
            for (Nota nota : periodo.getNotas()){
                System.out.println(nota.valorTotal());
            }
        }


    }
}