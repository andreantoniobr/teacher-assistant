package view.panel;
import view.CardLayoutOptions;
import view.constants.CardConstants;

import javax.swing.*;
import java.awt.*;

public class AcoesPainel extends JPanel {
    private JButton aluno, turma, periodo, metodologiaNota, opcoes;

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
        gbc.weightx = 1;
        gbc.insets = new Insets(4, 4, 4, 4);

        add((aluno = new JButton("Aluno")), gbc);
        gbc.gridy++;
        add((turma = new JButton("Turma")), gbc);
        gbc.gridy++;
        add((periodo = new JButton("Período")), gbc);
        gbc.gridy++;
        add((metodologiaNota = new JButton("Metodologia de Nota")), gbc);
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        add((opcoes = new JButton("Opcões")), gbc);
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
