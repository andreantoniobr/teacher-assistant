package test.modelTest;

import model.MetodologiaNota;
import model.valuable.Prova;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MetodologiaNotaTest {
    @Test
    void getNomeMetodologiaNotaTest(){
        MetodologiaNota nome = new MetodologiaNota("Prova");
        String metodologiaEsperada = "Prova";
        String metodologiaObitido = nome.getNome();
        Assertions.assertEquals(metodologiaEsperada, metodologiaObitido);
    }

    @Test
    void getIdMetodologiaNotaTest(){
        MetodologiaNota metodologiaNota = new MetodologiaNota(100, "NomeMetodologia");
        int idMetodologiaEsperado = 100;
        int idMetodologiaObitida = metodologiaNota.getId();
        Assertions.assertEquals(idMetodologiaEsperado, idMetodologiaObitida);
    }

    @Test
    void getAvaliaveisMetodologiaNotaTest(){
        Prova prova = new Prova(5.0);
        double valorEsperado = 5.0;
        double valorObitido = prova.getValor();
        Assertions.assertEquals(valorEsperado, valorObitido);
    }
    @Test
    void adicionarAvaliaveisMetodologiaNotaTest(){
        //criar os 2 tipos de metodos avaliativos ;D
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