package test.controllerTest;

import controller.ControladorAluno;
import controller.ControladorTurma;
import model.Aluno;
import model.Turma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTurmaTest {
    private ControladorTurma controladorTurma = new ControladorTurma();
    Turma t1 = new Turma("TurmaT1");

    @Test
    void inserirTurmaTest() {
        int quantidadeTurmasAntes = this.controladorTurma.getTurmas().size();
        try {
            controladorTurma.inserirTurma(t1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int quantidadeEsperadaAlunos = quantidadeTurmasAntes + 1;
        int resultado = this.controladorTurma.getTurmas().size();
        assertEquals(quantidadeEsperadaAlunos, resultado);
    }

    @Test
    void getDadosTurmaPorIdTest() {
        Turma turmaPorId = new Turma(100, "TurmaPorID");
        try {
            controladorTurma.inserirTurma(turmaPorId);
            Object[] dadoEsperado = {turmaPorId.getId(), turmaPorId.getNome()};
            Object[] resultado = this.controladorTurma.getDadosTurmaPorId(100);
            assertArrayEquals(dadoEsperado, resultado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}