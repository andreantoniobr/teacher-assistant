import App.*;
import SwingInterface.MainFrame;
import valuable.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aplicantion aplicantion = new Aplicantion();
        aplicantion.inserirAluno(new Aluno("Andre Antonio Bezerra"));
        aplicantion.inserirAluno(new Aluno("Paulo Kaike"));
        aplicantion.inserirAluno(new Aluno("Junior Silva"));
        RunAppInterface(aplicantion);
    }

    public static void RunAppInterface(Aplicantion aplicantion){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(aplicantion);
            }
        });
    }
}