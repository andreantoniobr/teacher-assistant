package test.controllerTest;

import controller.ControladorAluno;
import model.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorAlunoTest {
    private ControladorAluno controladorAluno = new ControladorAluno();
    Aluno a1 = new Aluno("Andre");
    Aluno a2 = new Aluno("Pablo");

    @Test
    void inserirAlunoTest() throws Exception {
        int quantidadeAlunosAntes = this.controladorAluno.getAlunos().size();
        controladorAluno.inserirAluno(a1);
        controladorAluno.inserirAluno(a2);
        int quantidadeEsperadaAlunos = quantidadeAlunosAntes + 2;
        int resultado = this.controladorAluno.getAlunos().size();
        assertEquals(quantidadeEsperadaAlunos, resultado);
    }

    @Test
    void getDadosAlunoPorIdTest() throws Exception {
        Aluno alunoPorId = new Aluno(100, "NomeAlunoPorId", "email@email.com");
        controladorAluno.inserirAluno(alunoPorId);
        Object[] dadoAlunoEsperado = {alunoPorId.getNome(), alunoPorId.getEmail(), -1};
        Object[] resultado = this.controladorAluno.getDadosAlunoPorId(100);
        assertArrayEquals(dadoAlunoEsperado, resultado);
    }

    @Test
    void editarAlunoTest() throws Exception {
        Aluno alunoModificar = new Aluno(108, "NomeAlunoModificar", "email@email.com");
        this.controladorAluno.inserirAluno(alunoModificar);
        this.controladorAluno.editarAluno(108, "NovoNomeAluno", "NovoEmailAluno@email.com", 1);
        Object[] dadoAlunoEsperado = {"NovoNomeAluno", "NovoEmailAluno@email.com", 1};
        Object[] resultado = this.controladorAluno.getDadosAlunoPorId(108);
        assertArrayEquals(dadoAlunoEsperado, resultado);
    }
}