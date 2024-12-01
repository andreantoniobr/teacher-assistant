package test.modelTest;

import model.Periodo;
import model.valuable.Prova;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class PeriodoTest {

    @Test
    void getNomePeriodoTest(){
        Periodo perido1 = new Periodo("2024-1");
        String periodoEsperado = "2024-1";
        String periodoObitido = perido1.getNome();
        Assertions.assertEquals(periodoEsperado, periodoObitido);
    }

    @Test
    void getMetodologiaNotaTest(){
        Prova prova = new Prova(5.0);
        double notaEsperadaDaMetodologia = 5.0;
        double notaObitidaDaMetodologia = prova.getValor();
        Assertions.assertEquals(notaEsperadaDaMetodologia, notaObitidaDaMetodologia);
    }

    @Test
    void adicionarMetodologiaNotaTest(){
        //criar os 2 tipos de metodos avaliativos, usei prova e frequencia
        Prova prova = new Prova(5.0);
        Prova frequencia = new Prova(1.0);
        // adicionar os tipos de metodos avaliativos em seus array lists.. como provas atuais e provas adicionados
        ArrayList<Prova> provasAtuais = new ArrayList<>(Arrays.asList(prova));
        //tive que adiconar o provas atuais em prova adicionada por que provas atuais ja esta presente nele..
        ArrayList<Prova> provaAdicionada = new ArrayList<>(provasAtuais);
        //adicionar a frequencia em prova adicionada aonde esta presente provas atuais aonde esta a prova..
        provaAdicionada.add(frequencia);
        //utilizei o assertTrue para dizer que se caso a frequencia estiver contida(contains) em provas atuais o test esta certo.
        Assertions.assertTrue(provaAdicionada.contains(frequencia));
        //coloquei o 2 para dizer que a lista tem 2 elementos, e ultilizando o size para o tamanho.
        Assertions.assertEquals(2,provaAdicionada.size());
    }


    @Test
    void removerAvaliaveisMeotodologiaNotaTest(){
        Prova prova = new Prova(5.0);
        Prova frequencia = new Prova(1.0);
        ArrayList<Prova> provasAtuais = new ArrayList<>(Arrays.asList(prova,frequencia));
        ArrayList<Prova> provaRemovida = new ArrayList<>(provasAtuais);
        //tive que remover a frenquencia da lista provaRemovida que a mesma tinha a povaAtuais que a prova estava dentro dela.
        provaRemovida.remove(frequencia);
        //fiz um assertFalse para caso a frenquencia estiver contida ainda na lista provaRemovida, ira da falso e o teste nao fucionara corretamente.
        Assertions.assertFalse(provaRemovida.contains(frequencia));
        //utilizando o size para o tamanho,
        Assertions.assertEquals(1, provaRemovida.size());
        // utilizando o assertTrue, para caso so tiver apenas a prova na listaRemovida,sera verdadeiro e o teste fucionarar corretamente.
        Assertions.assertTrue(provaRemovida.contains(prova));
    }

}
