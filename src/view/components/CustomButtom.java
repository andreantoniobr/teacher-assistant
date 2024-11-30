package view.components;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CustomButtom extends JButton{
    public CustomButtom(String buttonText, Color color, Color hoverColor, Color borderColor, Color textColor){
        setText(buttonText);
        setBackground(color);
        //setBorderPainted(false);
        setForeground(textColor);
        setBorder(new TextBubbleBorder(borderColor,1,10,0));

        //setBorder(BorderFactory.createCompoundBorder(getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 5)));
        //setFont(new Font("Tahoma", 1, 13));
        setMargin(new Insets(5,10,5,10));
        setOpaque(true);
        addEffects(color, hoverColor);
    }

    private void addEffects(Color color, Color hoverColor) {
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(color);
            }
        });
    }
}
