package view.frame;

import view.panel.*;
import view.CardLayoutOptions;
import view.constant.CardConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel cardsPanel;

    public MainFrame() {
        setTitle("Teacher Assistant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        addCardLayout();
        setVisible(true);
    }

    private void addCardLayout() {
        CardLayout cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        CardLayoutOptions cardLayoutOptions = new CardLayoutOptions();
        cardLayoutOptions.setCardLayout(cardLayout);
        cardLayoutOptions.setContainer(cardsPanel);
        addCardsInCardsPanel(cardLayoutOptions);
        add(cardsPanel);
    }

    private void addCardsInCardsPanel(CardLayoutOptions cardLayoutOptions) {
        cardsPanel.add(new MainPainel(new AlunoPainel(), cardLayoutOptions), CardConstants.ALUNOPAINEL);
        cardsPanel.add(new MainPainel(new TurmaPainel(), cardLayoutOptions), CardConstants.TURMAPAINEL);
        cardsPanel.add(new MainPainel(new PeriodoPainel(), cardLayoutOptions), CardConstants.PERIODOPAINEL);
        cardsPanel.add(new MainPainel(new MetodologiaNotaPainel(), cardLayoutOptions), CardConstants.METODOLOGIANOTAPAINEL);
    }
}
