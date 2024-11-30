package view.frame;

import view.components.SaveButtom;
import view.constants.ViewConstants;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EditarTurmaFrame extends DependentFrame {
    private JTextField nome;
    private JButton salvar;

    public EditarTurmaFrame(String nome) {
        super("Editar Turma", ViewConstants.dependentFrameWidth, 200);
        criarInterface();
        setNome(nome);
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public JButton getSalvar() {
        return salvar;
    }

    private void criarInterface() {
        setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel painelTurma = new JPanel(new GridBagLayout());
        painelTurma.setBorder(new CompoundBorder(new TitledBorder(ViewConstants.TURMA), new EmptyBorder(10, 10, 10, 10)));
        painelTurma.add(new JLabel(ViewConstants.CAMPONOMEDATURMA), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelTurma.add((nome = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelTurma.add(salvar = new SaveButtom("Salvar"), gbc);
        add(painelTurma, BorderLayout.CENTER);
    }
}
