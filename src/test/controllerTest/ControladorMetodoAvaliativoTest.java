package test.controllerTest;

import controller.ControladorMetodoAvaliativo;
import model.valuable.MetodoAvaliativo;
import model.valuable.Prova;
import model.valuable.Trabalho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorMetodoAvaliativoTest {
    private ControladorMetodoAvaliativo controladorMetodoAvaliativo = new ControladorMetodoAvaliativo();

    @Test
    void getDadosMetodoAvaliativoPorIdTest() throws Exception {
        int idProva = 225;
        Prova prova = new Prova(idProva, "Prova POO", 5.5);

        //Adicionando objeto ao controlador
        this.controladorMetodoAvaliativo.inseirMetodoAvaliativo(prova);

        Object[] esperado = {idProva, prova.getTipoAvaliacao().toString(), prova.getValor()};
        Object[] resultado = this.controladorMetodoAvaliativo.getDadosMetodoAvaliativoPorId(idProva);
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void getCloneMetodoAvaliativoPorIdTest() throws Exception {
        int id = 300;
        Trabalho t1 = new Trabalho(id, "Trabalho POO", 8.5);

        //Adicionando objeto ao controlador
        this.controladorMetodoAvaliativo.inseirMetodoAvaliativo(t1);

        //Pegando objeto do controlador
        MetodoAvaliativo m1 = this.controladorMetodoAvaliativo.getCloneMetodoAvaliativoPorId(id);

        Object[] esperado = {m1.getId(), m1.getTipoAvaliacao().toString(), m1.getValor()};
        Object[] resultado = this.controladorMetodoAvaliativo.getDadosMetodoAvaliativoPorId(id);
        assertArrayEquals(esperado, resultado);
    }
}