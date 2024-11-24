import App.*;
import SwingInterface.MainFrame;
import valuable.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prova prova = new Prova();
        Trabalho trabalho = new Trabalho();
        Simulado simulado = new Simulado();
        MetodoAvaliativoOutros metodoAvaliativoOutros = new MetodoAvaliativoOutros();


        RunAppInterface();
    }

    public static void RunAppInterface(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}