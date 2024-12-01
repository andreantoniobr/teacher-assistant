package test.controllerTest;

import controller.Applicantion;
import controller.ControladorPeriodo;
import controller.ControladorTurma;
import controller.ControlladorMetodologiaNota;
import model.MetodologiaNota;
import model.Periodo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorPeriodoTest {
    private ControladorPeriodo controladorPeriodo = new ControladorPeriodo();
    private ControlladorMetodologiaNota controlladorMetodologiaNota = new ControlladorMetodologiaNota();

    @Test
    void removerMetodologiaPorHashCodeTest() throws Exception {
        Periodo periodo = new Periodo(1000, "PeridoTestPorHash");
        MetodologiaNota metodologiaNota = new MetodologiaNota(100, "MetodologiaTestPorHash");
        MetodologiaNota metodologiaNota2 = new MetodologiaNota(120, "MetodologiaTestPorHash");

        int quantidadeMetodoliasAntes = periodo.getNotas().size();

        this.controladorPeriodo.inserirPeriodo(periodo);
        periodo.adicionarMetodologiaNota(metodologiaNota);
        periodo.adicionarMetodologiaNota(metodologiaNota2);

        controladorPeriodo.removerMetodologiaPorHashCode(1000, metodologiaNota.getHashCode());
        int quantidadeEsperada = quantidadeMetodoliasAntes + 1;
        int resultado = periodo.getNotas().size();
        assertEquals(quantidadeEsperada, resultado);
    }
}