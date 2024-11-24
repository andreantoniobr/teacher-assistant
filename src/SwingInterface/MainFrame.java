package SwingInterface;

import App.Aplicantion;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JPanel cards;

    public MainFrame(Aplicantion aplication) {
        setTitle("Teacher Assistant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        CardLayoutOptions cardLayoutOptions = new CardLayoutOptions();
        cardLayoutOptions.setCardLayout(cardLayout);
        cardLayoutOptions.setContainer(cards);

        cards.add(new MainPanel(new AlunoPanel(aplication), cardLayoutOptions), CardConstants.ALUNOPANEL);
        cards.add(new MainPanel(new TurmaPanel(), cardLayoutOptions), CardConstants.TURMAPANEL);

        add(cards);

        pack();
        setVisible(true);
    }
}
