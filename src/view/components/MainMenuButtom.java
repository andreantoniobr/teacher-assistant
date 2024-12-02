package view.components;

import javax.swing.*;
import java.awt.*;

public class MainMenuButtom extends JButton {
    public MainMenuButtom(String buttonText){
        Color color = new Color(43, 96, 236);
        setText(buttonText);
        setBackground(color);
        setForeground(new Color(255, 255, 255));
        setBorder(new TextBubbleBorder(color,1,10,0));
        setMargin(new Insets(5,10,5,10));
        setOpaque(true);
        addEffects(color, new Color(55, 129, 254));
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
