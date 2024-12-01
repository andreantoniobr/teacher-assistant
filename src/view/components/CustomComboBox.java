package view.components;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox extends JComboBox {
    public CustomComboBox(){
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(42, 42, 42));
        setBorder(new TextBubbleBorder(new Color(200, 200, 200),1,7,0));
        setFont(new Font("SansSerif", Font.BOLD, 12));
        setOpaque(true);
    }
}
