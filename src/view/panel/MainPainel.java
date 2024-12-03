package view.panel;

import view.CardLayoutOptions;

import javax.swing.*;
import java.awt.*;

public class MainPainel extends JPanel {
    private AcoesPainel acoesPanel;

    public MainPainel(JPanel panel, CardLayoutOptions cardLayoutOptions) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1;
        gbc.weightx = 0;
        //gbc.insets = new Insets(10, 10, 10, 10);
        add((acoesPanel = new AcoesPainel(cardLayoutOptions)), gbc);


        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.33;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        add((panel), gbc);
    }

}
