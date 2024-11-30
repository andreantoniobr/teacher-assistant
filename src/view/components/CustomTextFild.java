package view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CustomTextFild extends JTextField {
    public CustomTextFild(Color color, Color textColor) {
        setBackground(color);
        setForeground(textColor);
        //setBorder(new LineBorder(new Color(200, 200, 200),1));
        setBorder(new TextBubbleBorder(new Color(200, 200, 200),1,10,0));
        //setBorder(new RoundedBorder(10));
        //setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //setBorder(BorderFactory.createCompoundBorder(getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        //setFont(new Font("Tahoma", 1, 13));
        setFont(new Font("SansSerif", Font.BOLD, 12));
        setMargin(new Insets(5,5,5,5));
        setOpaque(true);
    }
}
