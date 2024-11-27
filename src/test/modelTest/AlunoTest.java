package test.modelTest;

import model.Aluno;
import org.junit.Assert;

class AlunoTest {

    @org.junit.jupiter.api.Test
    void getNomeTest() {
        Aluno aluno = new Aluno("AlunoTest");
        String nomeEsperado = "AlunoTest";
        String nome = aluno.getNome();
        Assert.assertEquals(nomeEsperado, nome);
    }
}