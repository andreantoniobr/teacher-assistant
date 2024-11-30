package view.frame;

import view.components.SaveButtom;
import view.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EditorPeriodoFrame extends DependentFrame {
    private JTextField nome;
    private JButton salvar;

    public EditorPeriodoFrame(String nome) {
        super("Editar Período", ViewConstants.dependentFrameWidth, 200);
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

        JPanel painelPeriodo = new JPanel(new GridBagLayout());
        painelPeriodo.setBorder(new CompoundBorder(new TitledBorder("Período"), new EmptyBorder(10, 10, 10, 10)));
        painelPeriodo.add(new JLabel("Nome do Período: "), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPeriodo.add((nome = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelPeriodo.add(salvar = new SaveButtom("Salvar"), gbc);
        add(painelPeriodo, BorderLayout.CENTER);
    }
}
