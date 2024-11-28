package test.modelTest;

import model.Aluno;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void getNomeTest() {
        Aluno aluno = new Aluno("AlunoTest");
        String nomeEsperado = "AlunoTest";
        String nome = aluno.getNome();
        Assert.assertEquals(nomeEsperado, nome);
    }
}