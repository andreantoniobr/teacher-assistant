import valuable.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Andre");
        Aluno aluno2 = new Aluno("Davi");
        Aluno aluno3 = new Aluno("Paulo Kaike");

        //Avalicoes Aluno 1
        Prova prova1 = new Prova(10);
        Apresentacao apresentacao1 = new Apresentacao(5);
        Trabalho trabalho1 = new Trabalho(7.5);

        //Avalicoes Aluno 2
        Prova prova2 = new Prova(7.2);
        Apresentacao apresentacao2 = new Apresentacao(4.5);
        Trabalho trabalho2 = new Trabalho(4.5);
        Simulado simulado1 = new Simulado(8.8);

        ArrayList<IValuable> avaliaveis1 = new ArrayList<>();
        avaliaveis1.add(prova1);
        avaliaveis1.add(apresentacao1);
        avaliaveis1.add(trabalho1);

        ArrayList<IValuable> avaliaveis2 = new ArrayList<>();
        avaliaveis2.add(prova2);
        avaliaveis2.add(apresentacao2);
        avaliaveis2.add(trabalho2);
        avaliaveis2.add(simulado1);

        Nota n1 = new Nota(avaliaveis1);
        Nota n2 = new Nota(avaliaveis2);

        Periodo p1 = new Periodo("Periodo 1");
        Periodo p1Aluno2 = new Periodo("Periodo 1");

        p1.adicionarNota(n1);
        p1Aluno2.adicionarNota(n2);

        aluno1.adicionarPeriodo(p1);
        aluno2.adicionarPeriodo(p1Aluno2);

        for (Periodo periodo : aluno1.getPeriodos()){
            for (Nota nota : periodo.getNotas()){
                System.out.println(nota.valorTotal());
            }
        }

        for (Periodo periodo : aluno2.getPeriodos()){
            for (Nota nota : periodo.getNotas()){
                System.out.println(nota.valorTotal());
            }
        }


    }
}