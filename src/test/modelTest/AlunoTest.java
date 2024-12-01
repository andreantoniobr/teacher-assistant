package test.modelTest;

import model.Aluno;
import model.Periodo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class AlunoTest {

    @Test //Teste de nome.
    void getNomeTest() {
        Aluno aluno = new Aluno("AlunoTest");
        String nomeEsperado = "AlunoTest";
        String nomeObitido = aluno.getNome();
        Assertions.assertEquals(nomeEsperado, nomeObitido);
    }

    @Test // Teste de Email
    void getEmailTest(){
        Aluno email = new Aluno(" ", "Jeielalmeida@ads.fiponline.edu.br");
        String emailEsperado =  "Jeielalmeida@ads.fiponline.edu.br";
        String emailObitido = email.getEmail();
        Assertions.assertEquals(emailEsperado, emailObitido);
    }

    @Test // Teste de id
    void getIdTest() {
        Aluno aluno = new Aluno(1, "NomeAluno");
        int idEsperado = 1;
        int idObtido = aluno.getId();
        Assertions.assertEquals(idEsperado, idObtido);
    }

    @Test //Teste de quantos periodos.
    void getPeriodoTest() {
        Periodo periodo1 = new Periodo("2024-1");
        Periodo periodo2 = new Periodo("2024-2");
        //irei ultilizar de uma ferramenta do arraylist para que pegue uma lista ja pre-determinada, que seria o Arrays.aslist
        ArrayList<Periodo> periodosEsperado = new ArrayList<>(Arrays.asList(periodo1, periodo2));
        ArrayList<Periodo> periodosObtidos = new ArrayList<>(Arrays.asList(periodo1, periodo2));
        Assertions.assertEquals(periodosEsperado, periodosObtidos);
    }
}