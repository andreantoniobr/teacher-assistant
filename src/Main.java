import view.frame.MainFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
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