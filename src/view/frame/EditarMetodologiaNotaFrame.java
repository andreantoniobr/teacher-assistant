package view.frame;

import view.constant.ViewConstants;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EditarMetodologiaNotaFrame extends DependentFrame {
    private JTextField nome;
    private JButton salvar;

    public EditarMetodologiaNotaFrame(String nome) {
        super("Editar Metodologia de Nota", ViewConstants.dependentFrameWidth, 400);
        view();
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

    private void view() {
        setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel painelMetodologia = new JPanel(new GridBagLayout());
        painelMetodologia.setBorder(new CompoundBorder(new TitledBorder("Metodologia de Nota"), new EmptyBorder(10, 10, 10, 10)));
        painelMetodologia.add(new JLabel("Nome da Metodologia: "), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelMetodologia.add((nome = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelMetodologia.add(salvar = new JButton("Salvar"), gbc);
        add(painelMetodologia, BorderLayout.CENTER);
    }
}
