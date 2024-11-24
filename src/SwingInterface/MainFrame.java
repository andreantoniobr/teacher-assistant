package SwingInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JPanel cards;

    public MainFrame() {
        setTitle("Teacher Assistant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        CardLayout cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        CardLayoutOptions cardLayoutOptions = new CardLayoutOptions();
        cardLayoutOptions.setCardLayout(cardLayout);
        cardLayoutOptions.setContainer(cards);

        cards.add(new MainPainel(new AlunoPainel(), cardLayoutOptions), CardConstants.ALUNOPANEL);
        cards.add(new MainPainel(new TurmaPainel(), cardLayoutOptions), CardConstants.TURMAPANEL);

        add(cards);

        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
