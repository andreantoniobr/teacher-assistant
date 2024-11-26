package view.frame;

import javax.swing.*;

public class DependentFrame extends JFrame {
    public DependentFrame(String frameName, int frameWidth, int frameHeight) {
        setTitle(frameName);
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
