import App.*;
import SwingInterface.MainFrame;
import valuable.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aplicantion aplicantion = new Aplicantion();
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