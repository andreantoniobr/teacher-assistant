package SwingInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AcoesPanel extends JPanel {
    private JButton aluno, turma, periodo, metodoAvaliativo, opcoes;

    public AcoesPanel(CardLayoutOptions cardLayoutOptions) {
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
        add((metodoAvaliativo = new JButton("Método Avaliativo")), gbc);
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        add((opcoes = new JButton("Opcões")), gbc);

        aluno.addActionListener(e -> {
            cardLayoutOptions.getCardLayout().show(cardLayoutOptions.getContainer(), CardConstants.ALUNOPANEL);
        });
        turma.addActionListener(e -> {
            cardLayoutOptions.getCardLayout().show(cardLayoutOptions.getContainer(), CardConstants.TURMAPANEL);
        });
    }
}
