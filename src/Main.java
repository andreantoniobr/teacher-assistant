import swingInterface.MainFrame;
import valuable.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Prova prova = new Prova();
        Trabalho trabalho = new Trabalho();
        Simulado simulado = new Simulado();
        MetodoAvaliativoOutros metodoAvaliativoOutros = new MetodoAvaliativoOutros();


        runApp();
    }

    public static void runApp(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}