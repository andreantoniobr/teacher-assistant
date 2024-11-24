package SwingInterface;
import App.Aluno;
import App.Aplicantion;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AlunoPanel extends JPanel {
    private JTextField nome;
    private JTextField email;
    private JTextArea alunos;

    private JButton adicionarAluno;

    public AlunoPanel(Aplicantion aplication) {
        setLayout(new GridLayout(2, 1));
        setBorder(new CompoundBorder(new TitledBorder("Aluno"), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(new JLabel("Nome do Aluno: "), gbc);
        gbc.gridy++;
        panel.add(new JLabel("E-mail: "), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add((nome = new JTextField(10)), gbc);
        gbc.gridy++;
        panel.add((email = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        panel.add(adicionarAluno = new JButton("Adicionar Aluno"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panel, gbc);







        alunos = new JTextArea();
        alunos.setEditable(false);
        MostraAlunos(aplication);
        add((new JScrollPane(alunos)), BorderLayout.CENTER);

        adicionarAluno.addActionListener(e->{
            String nome = getNome();
            if(!nome.isEmpty()){
                Aluno aluno = new Aluno(nome, getEmail());
                aplication.inserirAluno(aluno);
                MostraAlunos(aplication);
            }
        });
    }

    private void MostraAlunos(Aplicantion aplication) {
        alunos.setText(aplication.GetTodosAlunos());
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String email) {
        this.nome.setText(email);
    }




}
