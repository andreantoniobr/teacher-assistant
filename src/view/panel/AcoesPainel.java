package view.panel;
import view.CardLayoutOptions;
import view.components.MainMenuButtom;
import view.components.SaveButtom;
import view.components.TextBubbleBorder;
import view.constants.CardConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AcoesPainel extends JPanel {
    private JButton aluno, turma, periodo, metodologiaNota, opcoes;
    GridBagConstraints gbc = new GridBagConstraints();

    public AcoesPainel(CardLayoutOptions cardLayoutOptions) {
        criarInterfacelAcoesPainel();
        adicionarListenersBotoes(cardLayoutOptions);
    }

    private void criarInterfacelAcoesPainel() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);

        addLogoImage();

        gbc.gridy++;
        gbc.insets = new Insets(20, 10, 10, 10);
        add((aluno = new SaveButtom("Aluno")), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 10, 10, 10);
        add((turma = new SaveButtom("Turma")), gbc);
        gbc.gridy++;
        add((periodo = new SaveButtom("Período")), gbc);
        gbc.gridy++;
        add((metodologiaNota = new SaveButtom("Metodologia de Nota")), gbc);
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0, 10, 25, 10);
        add((opcoes = new SaveButtom("Opcões")), gbc);
    }

    private void addLogoImage() {
        try {
            BufferedImage logo = ImageIO.read(new File("images/teacher_assistant_logo.png"));
            Image resizedLogo = logo.getScaledInstance(120, 85, Image.SCALE_DEFAULT);
            JPanel jPanel = new JPanel();
            JLabel label = new JLabel(new ImageIcon(resizedLogo));
            jPanel.add(label);
            add(jPanel, gbc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void adicionarListenersBotoes(CardLayoutOptions cardLayoutOptions) {
        aluno.addActionListener(e -> {
            cardLayoutOptions.showCard(CardConstants.ALUNOPAINEL);
        });
        turma.addActionListener(e -> {
            cardLayoutOptions.showCard(CardConstants.TURMAPAINEL);
        });
        periodo.addActionListener(e -> {
            cardLayoutOptions.showCard(CardConstants.PERIODOPAINEL);
        });
        metodologiaNota.addActionListener(e -> {
            cardLayoutOptions.showCard(CardConstants.METODOLOGIANOTAPAINEL);
        });
    }
}
