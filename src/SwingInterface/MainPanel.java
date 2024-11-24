package SwingInterface;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel currentPanel;
    private AcoesPanel acoesPanel;

    public MainPanel(JPanel panel, CardLayoutOptions cardLayoutOptions) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        currentPanel = panel;

        //gbc.gridy++;
        //add((databasePane = new DatabasePane()), gbc);
        //gbc.gridy++;
        //add((systemDatabasePane = new SystemDatabasePane()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;
        //gbc.anchor = GridBagConstraints.WEST;
        gbc.weighty = 1;
        gbc.weightx = 0;
        add((acoesPanel = new AcoesPanel(cardLayoutOptions)), gbc);


        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.33;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(4, 4, 4, 4);
        //add((sourcePane = new SourcePane()), gbc);
        add((panel), gbc);
    }

}
